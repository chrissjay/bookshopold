package whj.bookshop.dao;

import org.apache.ibatis.jdbc.SQL;
import whj.bookshop.model.Bookinfo;

public class BookinfoSqlProvider {

    public String insertSelective(Bookinfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("bookinfo");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getBid() != null) {
            sql.VALUES("bid", "#{bid,jdbcType=INTEGER}");
        }
        
        if (record.getAuthor() != null) {
            sql.VALUES("author", "#{author,jdbcType=VARCHAR}");
        }
        
        if (record.getPress() != null) {
            sql.VALUES("press", "#{press,jdbcType=VARCHAR}");
        }
        
        if (record.getTime() != null) {
            sql.VALUES("time", "#{time,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }
}