package whj.bookshop.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import whj.bookshop.model.Role;
import whj.bookshop.model.User;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    @Delete({
        "delete from user",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (ID, USER_CODE, ",
        "USER_NAME, USER_PWD, ",
        "SORTNO, STATE)",
        "values (#{id,jdbcType=INTEGER}, #{userCode,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{userPwd,jdbcType=VARCHAR}, ",
        "#{sortno,jdbcType=INTEGER}, #{state,jdbcType=INTEGER})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @Select({
        "select",
        "ID, USER_CODE, USER_NAME, USER_PWD, SORTNO, STATE",
        "from user",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="USER_CODE", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_NAME", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_PWD", property="userPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="SORTNO", property="sortno", jdbcType=JdbcType.INTEGER),
        @Result(column="STATE", property="state", jdbcType=JdbcType.INTEGER)
    })
    User selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set USER_CODE = #{userCode,jdbcType=VARCHAR},",
          "USER_NAME = #{userName,jdbcType=VARCHAR},",
          "USER_PWD = #{userPwd,jdbcType=VARCHAR},",
          "SORTNO = #{sortno,jdbcType=INTEGER},",
          "STATE = #{state,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);

    /**
     * 获取用户信息
     * @param paramMap
     * @return List<UserInfo>
     */
    List<User> getUserInfos(Map<String, Object> paramMap);

    /**
     * 获取用户角色信息
     * @param paramMap
     * @return List<UserRoleInfo>
     */
    List<Role> getRoleInfos(Map<String, Object> paramMap);
}