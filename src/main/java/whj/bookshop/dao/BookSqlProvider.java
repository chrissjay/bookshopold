package whj.bookshop.dao;

import org.apache.ibatis.jdbc.SQL;
import whj.bookshop.model.Book;

public class BookSqlProvider {

    public String insertSelective(Book record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("book");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCid() != null) {
            sql.VALUES("cid", "#{cid,jdbcType=INTEGER}");
        }
        
        if (record.getBooktype() != null) {
            sql.VALUES("bookType", "#{booktype,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=DOUBLE}");
        }
        
        if (record.getOriginalprice() != null) {
            sql.VALUES("originalPrice", "#{originalprice,jdbcType=DOUBLE}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=INTEGER}");
        }
        
        if (record.getAuthor() != null) {
            sql.VALUES("author", "#{author,jdbcType=VARCHAR}");
        }
        
        if (record.getPress() != null) {
            sql.VALUES("press", "#{press,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            sql.VALUES("version", "#{version,jdbcType=VARCHAR}");
        }
        
        if (record.getDegree() != null) {
            sql.VALUES("degree", "#{degree,jdbcType=DOUBLE}");
        }
        
        if (record.getPublishdate() != null) {
            sql.VALUES("publishDate", "#{publishdate,jdbcType=VARCHAR}");
        }
        
        if (record.getDate() != null) {
            sql.VALUES("date", "#{date,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Book record) {
        SQL sql = new SQL();
        sql.UPDATE("book");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCid() != null) {
            sql.SET("cid = #{cid,jdbcType=INTEGER}");
        }
        
        if (record.getBooktype() != null) {
            sql.SET("bookType = #{booktype,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=DOUBLE}");
        }
        
        if (record.getOriginalprice() != null) {
            sql.SET("originalPrice = #{originalprice,jdbcType=DOUBLE}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=INTEGER}");
        }
        
        if (record.getAuthor() != null) {
            sql.SET("author = #{author,jdbcType=VARCHAR}");
        }
        
        if (record.getPress() != null) {
            sql.SET("press = #{press,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            sql.SET("version = #{version,jdbcType=VARCHAR}");
        }
        
        if (record.getDegree() != null) {
            sql.SET("degree = #{degree,jdbcType=DOUBLE}");
        }
        
        if (record.getPublishdate() != null) {
            sql.SET("publishDate = #{publishdate,jdbcType=VARCHAR}");
        }
        
        if (record.getDate() != null) {
            sql.SET("date = #{date,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}