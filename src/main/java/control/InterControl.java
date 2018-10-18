package control;

import bean.InterEntity;
import dao.InterDao;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/inter")
public class InterControl {

    @RequestMapping(value = "/insertIntor",method = RequestMethod.POST)
    @ResponseBody
    public String insertInter(@RequestBody String data){
      // data="{"mybody":"okhttp3.RequestBody$2@4a847be0","myurl":"http:\/\/192.168.8.222:8088\/access\/insertaccess","ishttp":"false","mymethod":"POST"}"
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        InterDao dao= (InterDao) context.getBean("dao");
        JSONObject jsonObject=JSONObject.fromObject(data);
        InterEntity interEntity=new InterEntity();
        interEntity.setMyurl(jsonObject.getString("myurl"));
        interEntity.setMymetnod(jsonObject.getString("mymethod"));
        interEntity.setIshttp(jsonObject.getBoolean("ishttp"));
        interEntity.setMybody(jsonObject.getString("mymethod"));
        boolean result=dao.insertInter(interEntity);
        return result+"";
    }
}
