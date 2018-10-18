package control;

import bean.LoginEntity;
import dao.UserNameLoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/userlogin")
public class LoginControl {
    /*dao此处的变量名一定要和applicationContext.xml里面的id名一样，不然会报错*/
   @Autowired
   UserNameLoginDao dao;

    @RequestMapping(value = "/insert")
    public String insertUser(){

        LoginEntity loginEntity=new LoginEntity();
        loginEntity.setLoginname("admin");
        loginEntity.setPwd("123456");
        boolean result=dao.insertUserLogin(loginEntity);
        return result+"";
    }
@RequestMapping(value = "/query",method = RequestMethod.POST)
   public String queryUser(HttpServletRequest request,HttpServletResponse response){
       String a=request.getParameter("loginname");
       String b=request.getParameter("pwd");
      List<LoginEntity> loginList= dao.queryUserLogin(a);
      LoginEntity loginEntity=loginList.get(0);
      String c=loginEntity.getPwd();
      boolean result=c.equals(b);
         Object obj=result;
        return obj+"";
    }
}
