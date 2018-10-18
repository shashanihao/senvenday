package control;

import bean.AccessTime;
import dao.AccessDao;
import dao.ClickDao;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/access")
public class AccessControl {


    @RequestMapping(value="/insertaccess",method = RequestMethod.POST)
    @ResponseBody
    public String insertAccess(@RequestBody String p){  //第一种方式   服务器接收的是json字符串数据
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccessDao dao= (AccessDao) context.getBean("dao");
        JSONObject jsonObject=JSONObject.fromObject(p);
        AccessTime accessTime=new AccessTime();
        accessTime.setStartdata(jsonObject.get("startdata").toString());
        accessTime.setPausedata(jsonObject.getString("pausedata"));
        boolean result=dao.insertAccess(accessTime);
        return result+"";
    }
}
