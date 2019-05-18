package whj.bookshop.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import whj.bookshop.model.Book;

@Mapper
public interface BookMapper {
    @Delete({
        "delete from book",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into book (id, name, ",
        "cid, bookType, price, ",
        "originalPrice, uid, ",
        "author, press, version, ",
        "degree, publishDate, ",
        "date, description)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{cid,jdbcType=INTEGER}, #{booktype,jdbcType=INTEGER}, #{price,jdbcType=DOUBLE}, ",
        "#{originalprice,jdbcType=DOUBLE}, #{uid,jdbcType=INTEGER}, ",
        "#{author,jdbcType=VARCHAR}, #{press,jdbcType=VARCHAR}, #{version,jdbcType=VARCHAR}, ",
        "#{degree,jdbcType=DOUBLE}, #{publishdate,jdbcType=VARCHAR}, ",
        "#{date,jdbcType=TIMESTAMP}, #{description,jdbcType=LONGVARCHAR})"
    })
    int insert(Book record);

    @InsertProvider(type=BookSqlProvider.class, method="insertSelective")
    int insertSelective(Book record);

    @Select({
        "select",
        "id, name, cid, bookType, price, originalPrice, uid, author, press, version, ",
        "degree, publishDate, date, description",
        "from book",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="cid", property="cid", jdbcType=JdbcType.INTEGER),
        @Result(column="bookType", property="booktype", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DOUBLE),
        @Result(column="originalPrice", property="originalprice", jdbcType=JdbcType.DOUBLE),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="author", property="author", jdbcType=JdbcType.VARCHAR),
        @Result(column="press", property="press", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.VARCHAR),
        @Result(column="degree", property="degree", jdbcType=JdbcType.DOUBLE),
        @Result(column="publishDate", property="publishdate", jdbcType=JdbcType.VARCHAR),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARCHAR)
    })
    Book selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BookSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Book record);

    @Update({
        "update book",
        "set name = #{name,jdbcType=VARCHAR},",
          "cid = #{cid,jdbcType=INTEGER},",
          "bookType = #{booktype,jdbcType=INTEGER},",
          "price = #{price,jdbcType=DOUBLE},",
          "originalPrice = #{originalprice,jdbcType=DOUBLE},",
          "uid = #{uid,jdbcType=INTEGER},",
          "author = #{author,jdbcType=VARCHAR},",
          "press = #{press,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=VARCHAR},",
          "degree = #{degree,jdbcType=DOUBLE},",
          "publishDate = #{publishdate,jdbcType=VARCHAR},",
          "date = #{date,jdbcType=TIMESTAMP},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Book record);

    @Update({
        "update book",
        "set name = #{name,jdbcType=VARCHAR},",
          "cid = #{cid,jdbcType=INTEGER},",
          "bookType = #{booktype,jdbcType=INTEGER},",
          "price = #{price,jdbcType=DOUBLE},",
          "originalPrice = #{originalprice,jdbcType=DOUBLE},",
          "uid = #{uid,jdbcType=INTEGER},",
          "author = #{author,jdbcType=VARCHAR},",
          "press = #{press,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=VARCHAR},",
          "degree = #{degree,jdbcType=DOUBLE},",
          "publishDate = #{publishdate,jdbcType=VARCHAR},",
          "date = #{date,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Book record);
}