package dao;


import bean.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TeacherDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        String sql="create table if not exists Teachers(id INT UNSIGNED AUTO_INCREMENT ," +
                "teacherName VARCHAR(20)," +
                "teacherAge VARCHAR(30)," +
                "teacherSex VARCHAR(20)," +
                "whichCourse VARCHAR(100)," +
                "PRIMARY KEY(id)ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        jdbcTemplate.execute(sql);
    }
    public boolean insertTeacher(Teacher teacher){
        String sql="insert into Teachers(id,teacherName,teacherAge,teacherSex,whichCourse)values(?,?,?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{null,teacher.getTeacherName(),
                teacher.getTeacherAge(),teacher.getTeacherSex(),teacher.getWhichCourse()})==1;
    }
}
