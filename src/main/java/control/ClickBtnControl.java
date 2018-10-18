package control;

import bean.ClickEntity;
import dao.ClickDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/click")
public class ClickBtnControl {
    @RequestMapping(value = "/insert")
    @ResponseBody
    public String insertClick(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ClickDao dao= (ClickDao) context.getBean("dao");
        ClickEntity clickEntity=new ClickEntity();
        clickEntity.setClickBtnTime("2018:17:10");
        clickEntity.setClickBtnText("下一步");
        clickEntity.setBtnNextDecriber("避免按钮重复点击");
        clickEntity.setWhichPage("当前页面");
        boolean result=dao.insertClick(clickEntity);
        return  result+"";
    }
    @RequestMapping("/query")
    public  String queryall(Model model){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ClickDao dao= (ClickDao) context.getBean("dao");
        model.addAttribute("click",dao.queryClick());
        return dao.queryClick().toString();
    }
}
