package newten.dao;

import newten.bean.NewTenAccessEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class NewTenAccessDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        String sql="create table if not exists tenAccessT(id int UNSIGNED AUTO_INCREMENT," +
                "whichUser varchar (200) not null," +
                "startTime varchar (200)not null," +
                "resurmTime varchar (200) not null ,"+
                "totalTime varchar (200) not null ,"+
                "phoneType varchar (200) not null ,"+
                "whichSystem varchar (200) not null ,"+
                "threadName varchar (200) not null ,"+
                "whichPage varchar (200) not null ,"+
                "primary key (id))ENGINE=InnoDB DEFAULT CHARSET=utf8";
        jdbcTemplate.execute(sql);
    }
    public boolean insertNewTenAccess(NewTenAccessEntity tenAccessEntity){
        String sql="insert into tenAccessT(id,whichUser,startTime,resurmTime,totalTime,phoneType," +
                "whichSystem,threadName,whichPage)values(?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{null,tenAccessEntity.getWhichUser(),tenAccessEntity.getStartTime(),tenAccessEntity.getResurmTime(),
        tenAccessEntity.getTotalTime(),tenAccessEntity.getPhoneType(),tenAccessEntity.getWhichSystem(),
        tenAccessEntity.getThreadName(),tenAccessEntity.getWhichPage()})==1;
    }

}
