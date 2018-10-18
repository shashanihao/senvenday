package control;

import bean.AccessTime;
import bean.NewStudent;
import bean.Student;
import dao.NewStudentDao;
import dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/a")
public class SenvenControl {

    @RequestMapping(value = "/b")
    public String insertStudent(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao dao= (StudentDao) context.getBean("dao");
        Student student=new Student();
        student.setName("哈哈哈哈");
        student.setAge(18);
        student.setSex("nv");
       boolean result=dao.insertStudent(student);
        return result+"";
    }
    @RequestMapping(value = "/c")
    public  String queryAll(Model model){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao dao= (StudentDao) context.getBean("dao");
        model.addAttribute("students",dao.queryall());
        return dao.queryall().toString();
    }
    @RequestMapping("/access")
    @ResponseBody
    public String insertAccessTime(String startdata, String pausedata){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
       StudentDao dao= (StudentDao) context.getBean("dao");
        AccessTime accessTime=new AccessTime();
        accessTime.setStartdata("201888");
        accessTime.setPausedata("2019999");
        boolean result=dao.insertAccessTime(accessTime);
       return result+"";
    }
    public  String insertNewStudent(){
        ApplicationContext context=new ClassPathXmlApplicationContext("");
        NewStudentDao dao= (NewStudentDao) context.getBean("dao");
        NewStudent n=new NewStudent();
        n.setName("");
        boolean result=dao.insertNewStudent(n);
        return  result+"";
    }

}
