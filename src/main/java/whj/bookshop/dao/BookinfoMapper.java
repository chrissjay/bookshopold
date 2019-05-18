package whj.bookshop.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import whj.bookshop.model.Bookinfo;

@Mapper
public interface BookinfoMapper {
    @Insert({
        "insert into bookinfo (id, bid, ",
        "author, press, time)",
        "values (#{id,jdbcType=INTEGER}, #{bid,jdbcType=INTEGER}, ",
        "#{author,jdbcType=VARCHAR}, #{press,jdbcType=VARCHAR}, #{time,jdbcType=TIMESTAMP})"
    })
    int insert(Bookinfo record);

    @InsertProvider(type=BookinfoSqlProvider.class, method="insertSelective")
    int insertSelective(Bookinfo record);
}