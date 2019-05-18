package whj.bookshop.common;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import whj.bookshop.model.Role;
import whj.bookshop.model.User;
import whj.bookshop.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 为当前subject授权
     * @param principalCollection
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Map<String, Object> params = new HashMap<>();
        params.put("userCode", (String) super.getAvailablePrincipal(principalCollection));
        List<Role> roles = userService.getRoleInfos(params);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if(!roles.isEmpty()) {
            for(Role role : roles) {
                info.addRole(role.getRoleCode());
            }
        }
        return info;
    }

    /**
     * 认证登陆subject身份
     * @param authenticationToken
     * @return AuthenticationInfo
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Map<String, Object> params = new HashMap<>();
        params.put("userCode", (String)authenticationToken.getPrincipal());
        List<User> users = userService.getUserInfos(params);
        if (users.isEmpty()) {
            throw new UnknownAccountException();
        } else if(users.size() > 1) {
            throw new DisabledAccountException();
        } else {
            User user = users.get(0);
            // 校验密码
            return new SimpleAuthenticationInfo(authenticationToken.getPrincipal(), user.getUserPwd(), ByteSource.Util.bytes("2w@W"),  getName());
        }
    }

}

