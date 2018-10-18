package dao;

import bean.ClickEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class ClickDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        String sql="create table if not exists clickT(id int unsigned AUTO_INCREMENT," +
                "clickBtnTime VARCHAR(200) NOT NULL," +
                "clickBtnText VARCHAR(200) NOT NULL," +
                "btnNextDecriber VARCHAR(200) NOT NULL," +
                "whichPage VARCHAR(200) NOT NULL," +
                "PRIMARY KEY(id))ENGINE=InnoDB DEFAULT CHARSET=utf8";
        jdbcTemplate.execute(sql);
    }
    public  boolean insertClick(ClickEntity clickEntity){
        String sql="insert into clickT(id,clickBtnTime,clickBtnText,btnNextDecriber,whichPage)values(?,?,?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{null,clickEntity.getClickBtnTime(),clickEntity.getClickBtnText(),
                clickEntity.getBtnNextDecriber(),clickEntity.getWhichPage()})==1;
    }
    public List<ClickEntity> queryClick(){
        String sql="select id,clickBtnTime,clickBtnText,btnNextDecriber,whichPage from clickT";
        return jdbcTemplate.query(sql,new ClickMapper());
    }
    class  ClickMapper implements RowMapper<ClickEntity>{
        @Override
        public ClickEntity mapRow(ResultSet resultSet, int i) throws SQLException {
           ClickEntity clickEntity=new ClickEntity();
           clickEntity.setId(resultSet.getInt(1));
           clickEntity.setClickBtnTime(resultSet.getString(2));
           clickEntity.setClickBtnText(resultSet.getString(3));
           clickEntity.setBtnNextDecriber(resultSet.getString(4));
           clickEntity.setWhichPage(resultSet.getString(5));
            return clickEntity;
        }
    }
}
