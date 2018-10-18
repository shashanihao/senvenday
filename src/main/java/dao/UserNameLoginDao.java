package dao;

import bean.LoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserNameLoginDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        String sql="create table if not exists UserLoginT(" +
                "id INT UNSIGNED AUTO_INCREMENT," +
                "loginname varchar(100) not  null, " +
                "pwd varchar (100) not null," +
                "primary  key(id))ENGINE=InnoDB DEFAULT CHARSET=utf8";
        jdbcTemplate.execute(sql);
    }

    public boolean insertUserLogin(LoginEntity loginEntity){
        String sql="insert into UserLoginT(id,loginname,pwd)values(?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{null,loginEntity.getLoginname(),loginEntity.getPwd()})==1;
    }
    public List<LoginEntity> queryUserLogin(String aname){
        String sql="select*from UserLoginT where loginname=?";
      List<LoginEntity> list=jdbcTemplate.query(sql,new LoginMapper(),aname);
      return list;
    }
    class LoginMapper implements RowMapper<LoginEntity> {

        @Override
        public LoginEntity mapRow(ResultSet resultSet, int i) throws SQLException {
            LoginEntity loginEntity=new LoginEntity();
            loginEntity.setLoginname(resultSet.getString("loginname"));
            loginEntity.setPwd(resultSet.getString("pwd"));
            return loginEntity;
        }
    }
}
