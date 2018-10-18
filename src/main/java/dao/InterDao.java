package dao;

import bean.InterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class InterDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        String sql="create table if not exists newInter(" +
                "id INT UNSIGNED AUTO_INCREMENT," +
                "myurl varchar(400) not null," +
                " mymethod varchar(100) not null," +
                "ishttp varchar(100) not null," +
                " mybody varchar(200) not null," +
                "PRIMARY key(id))ENGINE=InnoDB DEFAULT CHARSET=utf8";
        jdbcTemplate.execute(sql);
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean insertInter(InterEntity interEntity){
        String sql="insert into newInter(id,myurl,mymethod,ishttp,mybody)values(?,?,?,?,?)";
         return jdbcTemplate.update(sql,new Object[]{null,interEntity.getMyurl(),interEntity.getMymetnod(),interEntity.isIshttp(),interEntity.getMybody()})==1;
    }
}
