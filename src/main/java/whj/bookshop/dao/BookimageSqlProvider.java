package whj.bookshop.dao;

import org.apache.ibatis.jdbc.SQL;
import whj.bookshop.model.Bookimage;

public class BookimageSqlProvider {

    public String insertSelective(Bookimage record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("bookimage");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getBid() != null) {
            sql.VALUES("bid", "#{bid,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Bookimage record) {
        SQL sql = new SQL();
        sql.UPDATE("bookimage");
        
        if (record.getBid() != null) {
            sql.SET("bid = #{bid,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}