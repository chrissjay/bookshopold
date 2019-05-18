package whj.bookshop.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import whj.bookshop.model.Role;

@Mapper
public interface RoleMapper {
    @Delete({
        "delete from role",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into role (ID, ROLE_CODE, ",
        "ROLE_NAME, SORTNO, ",
        "STATE)",
        "values (#{id,jdbcType=INTEGER}, #{roleCode,jdbcType=VARCHAR}, ",
        "#{roleName,jdbcType=VARCHAR}, #{sortno,jdbcType=INTEGER}, ",
        "#{state,jdbcType=INTEGER})"
    })
    int insert(Role record);

    @InsertProvider(type=RoleSqlProvider.class, method="insertSelective")
    int insertSelective(Role record);

    @Select({
        "select",
        "ID, ROLE_CODE, ROLE_NAME, SORTNO, STATE",
        "from role",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ROLE_CODE", property="roleCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_NAME", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="SORTNO", property="sortno", jdbcType=JdbcType.INTEGER),
        @Result(column="STATE", property="state", jdbcType=JdbcType.INTEGER)
    })
    Role selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Role record);

    @Update({
        "update role",
        "set ROLE_CODE = #{roleCode,jdbcType=VARCHAR},",
          "ROLE_NAME = #{roleName,jdbcType=VARCHAR},",
          "SORTNO = #{sortno,jdbcType=INTEGER},",
          "STATE = #{state,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Role record);
}