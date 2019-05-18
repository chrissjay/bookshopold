package whj.bookshop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whj.bookshop.dao.UserMapper;
import whj.bookshop.model.Role;
import whj.bookshop.model.User;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserInfos(Map<String, Object> paramMap) {
        paramMap.put("state", 1);
        return userMapper.getUserInfos(paramMap);
    }

    public List<Role> getRoleInfos(Map<String, Object> paramMap) {
        paramMap.put("state", 1);
        return userMapper.getRoleInfos(paramMap);
    }

}
