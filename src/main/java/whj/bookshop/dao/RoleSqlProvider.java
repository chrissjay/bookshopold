package whj.bookshop.dao;

import org.apache.ibatis.jdbc.SQL;
import whj.bookshop.model.Role;

public class RoleSqlProvider {

    public String insertSelective(Role record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("role");
        
        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getRoleCode() != null) {
            sql.VALUES("ROLE_CODE", "#{roleCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleName() != null) {
            sql.VALUES("ROLE_NAME", "#{roleName,jdbcType=VARCHAR}");
        }
        
        if (record.getSortno() != null) {
            sql.VALUES("SORTNO", "#{sortno,jdbcType=INTEGER}");
        }
        
        if (record.getState() != null) {
            sql.VALUES("STATE", "#{state,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Role record) {
        SQL sql = new SQL();
        sql.UPDATE("role");
        
        if (record.getRoleCode() != null) {
            sql.SET("ROLE_CODE = #{roleCode,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleName() != null) {
            sql.SET("ROLE_NAME = #{roleName,jdbcType=VARCHAR}");
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