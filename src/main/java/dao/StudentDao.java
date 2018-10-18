package dao;

import bean.AccessTime;
import bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Component
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        String sql = "CREATE TABLE IF NOT EXISTS `Access`(\n" +
                "   `id` INT UNSIGNED AUTO_INCREMENT,\n" +
                "   `startdata` VARCHAR(100) NOT NULL,\n" +
                "   `pausedata` VARCHAR(40) NOT NULL,\n" +
                "   PRIMARY KEY ( `id` )\n" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        jdbcTemplate.execute(sql);
    }

    public boolean insertStudent(Student student){
        String sql="insert into student(id,name,age,sex)values(?,?,?,?)";
        return  jdbcTemplate.update(sql, new Object[] { null,student.getName(), student.getAge(), student.getSex()},
                new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR }) == 1;
    }
    public List<Student> queryall(){
        String sql="select id,name,age,sex from student";
        return  jdbcTemplate.query(sql,new StudentMapper());
    }
    public boolean insertAccessTime(AccessTime accessTime){
        String sql="insert into Access(id,startdata,pausedata)values(?,?,?) ";
        return jdbcTemplate.update(sql,new Object[]{null,accessTime.getStartdata(),accessTime.getPausedata()},
                new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, }) == 1;
    }

    class StudentMapper implements RowMapper<Student>{
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student=new Student();
            student.setId(resultSet.getInt(1));
            student.setName(resultSet.getString(2));
            student.setAge(resultSet.getInt(3));
            student.setSex(resultSet.getString(4));
            return student;
        }


    }

}
