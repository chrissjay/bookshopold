package whj.bookshop.dao;

import org.apache.ibatis.jdbc.SQL;
import whj.bookshop.model.User;

public class UserSqlProvider {

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserCode() != null) {
            sql.VALUES("USER_CODE", "#{userCode,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("USER_NAME", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPwd() != null) {
            sql.VALUES("USER_PWD", "#{userPwd,jdbcType=VARCHAR}");
        }
        
        if (record.getSortno() != null) {
            sql.VALUES("SORTNO", "#{sortno,jdbcType=INTEGER}");
        }
        
        if (record.getState() != null) {
            sql.VALUES("STATE", "#{state,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getUserCode() != null) {
            sql.SET("USER_CODE = #{userCode,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("USER_NAME = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPwd() != null) {
            sql.SET("USER_PWD = #{userPwd,jdbcType=VARCHAR}");
        }
        
        if (record.getSortno() != null) {
            sql.SET("SORTNO = #{sortno,jdbcType=INTEGER}");
        }
        
        if (record.getState() != null) {
            sql.SET("STATE = #{state,jdbcType=INTEGER}");
        }
        
        sql.WHERE("ID = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}