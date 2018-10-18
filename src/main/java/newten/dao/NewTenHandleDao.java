package newten.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class NewTenHandleDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        String sql="create table if not exists tenHandleT(id int UNSIGNED AUTO_INCREMENT," +
                ")";
        jdbcTemplate.execute(sql);
    }
}
