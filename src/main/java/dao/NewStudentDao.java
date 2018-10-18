package dao;

import bean.NewStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class NewStudentDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public  boolean insertNewStudent(NewStudent newStudent){
        String sql="insert into NewStudent(id,name,age,sex)values(?,?,?,?)";
        return  jdbcTemplate.update(sql,new Object[]{null,newStudent.getName(),newStudent.getAge(),newStudent.getSex()})==1;
    }
}
