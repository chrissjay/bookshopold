package whj.bookshop.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import whj.bookshop.model.UserRoleR;

@Mapper
public interface UserRoleRMapper {
    @Delete({
        "delete from user_role_r",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user_role_r (ID, USER_CODE, ",
        "ROLE_CODE, SORTNO, ",
        "STATE)",
        "values (#{id,jdbcType=INTEGER}, #{userCode,jdbcType=VARCHAR}, ",
        "#{roleCode,jdbcType=VARCHAR}, #{sortno,jdbcType=INTEGER}, ",
        "#{state,jdbcType=INTEGER})"
    })
    int insert(UserRoleR record);

    @InsertProvider(type=UserRoleRSqlProvider.class, method="insertSelective")
    int insertSelective(UserRoleR record);

    @Select({
        "select",
        "ID, USER_CODE, ROLE_CODE, SORTNO, STATE",
        "from user_role_r",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="USER_CODE", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_CODE", property="roleCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="SORTNO", property="sortno", jdbcType=JdbcType.INTEGER),
        @Result(column="STATE", property="state", jdbcType=JdbcType.INTEGER)
    })
    UserRoleR selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserRoleRSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserRoleR record);

    @Update({
        "update user_role_r",
        "set USER_CODE = #{userCode,jdbcType=VARCHAR},",
          "ROLE_CODE = #{roleCode,jdbcType=VARCHAR},",
          "SORTNO = #{sortno,jdbcType=INTEGER},",
          "STATE = #{state,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserRoleR record);
}