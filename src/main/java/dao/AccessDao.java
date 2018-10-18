package dao;

import bean.AccessTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccessDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        String sql="create table if not exists AccessT(" +
                "id INT UNSIGNED AUTO_INCREMENT," +
                "startdata varchar(200) not null," +
                " pausedata varchar(100) not null," +
                "PRIMARY key(id))ENGINE=InnoDB DEFAULT CHARSET=utf8";
        jdbcTemplate.execute(sql);
    }

    public boolean insertAccess(AccessTime accessTime){
        String sql="insert into AccessT(id,startdata,pausedata)values(?,?,?)";
        return  jdbcTemplate.update(sql,new Object[]{null,accessTime.getStartdata(),accessTime.getPausedata()})==1;
    }
}
