package newten.control;

import newten.bean.NewTenClickEntity;
import newten.dao.NewTenClickDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "tenClick")
public class NewTenClickControl {
    @Autowired(required = false)
    NewTenClickDao  dao;

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insertNewTenClick(HttpServletRequest request, HttpServletResponse response){
        NewTenClickEntity tenClickEntity=new NewTenClickEntity();
         tenClickEntity.setTestUser(request.getParameter("testUser"));
         tenClickEntity.setBtnText(request.getParameter("btnText"));
         tenClickEntity.setPhoneType(request.getParameter("phoneType"));
         tenClickEntity.setWhatClickTime(request.getParameter("clickTime"));
         tenClickEntity.setWhereBtn(request.getParameter("whereBtn"));
         tenClickEntity.setWhichMethod(request.getParameter("whichMethod"));
         tenClickEntity.setWhichSystem(request.getParameter("whichSystem"));
         tenClickEntity.setWhichThread(request.getParameter("whichThread"));
         tenClickEntity.setWhichPage(request.getParameter("whichPage"));
         boolean result=dao.insertNewTenClick(tenClickEntity);
        return result+"";
    }
}
