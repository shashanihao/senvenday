package newten.control;

import newten.bean.NewTenAccessEntity;
import newten.dao.NewTenAccessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@RestController
@RequestMapping(value = "tenAccess")
public class NewTenAccessControl {
    @Autowired(required = false)
    NewTenAccessDao dao;

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String  insertNewTenAccess(HttpServletRequest request, HttpServletResponse response){
        NewTenAccessEntity tenAccessEntity=new NewTenAccessEntity();
        tenAccessEntity.setPhoneType(request.getParameter("phoneType"));
        tenAccessEntity.setWhichUser(request.getParameter("testUser"));
        tenAccessEntity.setStartTime(request.getParameter("startTime"));
        tenAccessEntity.setResurmTime(request.getParameter("resurmTime"));
        tenAccessEntity.setTotalTime(request.getParameter("totalTime"));
        tenAccessEntity.setWhichSystem(request.getParameter("phoneSystem"));
        tenAccessEntity.setThreadName(request.getParameter("threadName"));
        tenAccessEntity.setWhichPage(request.getParameter("whichPage"));
     boolean result=dao.insertNewTenAccess(tenAccessEntity);
      return result+"";
    }
}
