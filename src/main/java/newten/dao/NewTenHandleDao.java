package newten.dao;

import newten.bean.NewTenHandleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class NewTenHandleDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private String whatHandle;//什么异常
    private String handleTime;//产生异常时间
    private String hanldeMethod;//哪个方法里面异常
    private String handlePage;//异常产生的当前页面
    private String testUser;
    private String phoneType;//什么机型
    private String whichSystem;//什么系统
    private String whichThread;//哪个线程

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        String sql="create table if not exists tenHandleT(id int UNSIGNED AUTO_INCREMENT," +
                "whatHandle varchar (200)," +
                "handleTime varchar (200)," +
                "hanldeMethod varchar (200)," +
                "handlePage varchar (200)," +
                "testUser varchar (200)," +
                "phoneType varchar (200)," +
                "whichSystem varchar (200)," +
                "whichThread varchar (200),primary key(id))ENGINE=InnoDB DEFAULT CHARSET=utf8";
        jdbcTemplate.execute(sql);
    }
    public boolean insertHandle(NewTenHandleEntity newHandleEntity){
        String sql="insert into tenHandleT(id,whatHandle,handleTime,hanldeMethod,handlePage,testUser,phoneType,whichSystem," +
                "whichThread)values(?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{null,newHandleEntity.getWhatHandle(),newHandleEntity.getHandleTime(),
        newHandleEntity.getHanldeMethod(),newHandleEntity.getHandlePage(),newHandleEntity.getTestUser(),newHandleEntity.getPhoneType(),
        newHandleEntity.getWhichSystem(),newHandleEntity.getWhichThread()})==1;
    }
}
