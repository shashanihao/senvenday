package control;

import bean.Teacher;
import dao.TeacherDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherContrlo {
    @RequestMapping(value = "/insertteacher")
    public String insertTeacher(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherDao dao= (TeacherDao) context.getBean("dao");
        Teacher teacher=new Teacher();
        teacher.setTeacherName("呵呵");
        teacher.setTeacherAge("19");
        teacher.setTeacherSex("女");
        teacher.setWhichCourse("语文");
        boolean result=dao.insertTeacher(teacher);
        return result+"";
    }
}
