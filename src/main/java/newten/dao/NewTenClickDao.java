package newten.dao;

import newten.bean.NewTenClickEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class NewTenClickDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        String sql="create table if not exists tenClickT(id int UNSIGNED AUTO_INCREMENT," +
                "whatClickTime varchar (200) not null,whereBtn varchar (200)," +
                "btnText varchar (200)," +
                "whichMethod varchar (200),testUser varchar (200),phoneType varchar (200),whichSystem varchar (200)," +
                "whichThread varchar (200),whichPage varchar (200)," +
                "primary key(id))ENGINE=InnoDB DEFAULT CHARSET=utf8";
        jdbcTemplate.execute(sql);
    }
    public boolean insertNewTenClick(NewTenClickEntity newTenClickEntity){
        String sql="insert into tenClickT(id,whatClickTime,whereBtn,btnText,whichMethod,testUser,phoneType,whichSystem," +
                "whichThread,whichPage)values(?,?,?,?,?,?,?,?,?,?)";
        return  jdbcTemplate.update(sql,new Object[]{null,newTenClickEntity.getWhatClickTime(),newTenClickEntity.getWhereBtn(),
        newTenClickEntity.getBtnText(),newTenClickEntity.getWhichMethod(),newTenClickEntity.getTestUser(),newTenClickEntity.getPhoneType(),
        newTenClickEntity.getWhichSystem(),newTenClickEntity.getWhichThread(),newTenClickEntity.getWhichPage()})==1;
    }
}
