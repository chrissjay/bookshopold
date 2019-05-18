package whj.bookshop.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import whj.bookshop.model.Bookimage;

@Mapper
public interface BookimageMapper {
    @Delete({
        "delete from bookimage",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into bookimage (id, bid, ",
        "type)",
        "values (#{id,jdbcType=INTEGER}, #{bid,jdbcType=INTEGER}, ",
        "#{type,jdbcType=INTEGER})"
    })
    int insert(Bookimage record);

    @InsertProvider(type=BookimageSqlProvider.class, method="insertSelective")
    int insertSelective(Bookimage record);

    @Select({
        "select",
        "id, bid, type",
        "from bookimage",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="bid", property="bid", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER)
    })
    Bookimage selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BookimageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Bookimage record);

    @Update({
        "update bookimage",
        "set bid = #{bid,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Bookimage record);
}