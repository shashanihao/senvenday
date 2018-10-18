package newten.control;

import newten.bean.NewTenHandleEntity;
import newten.dao.NewTenHandleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "tenHandle")
public class NewTenHandleControl {
    @Autowired(required = false)
    NewTenHandleDao dao;

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insertHandle(HttpServletRequest request, HttpServletResponse response){
        NewTenHandleEntity tenHandleEntity=new NewTenHandleEntity();
        tenHandleEntity.setTestUser(request.getParameter("testUser"));
        tenHandleEntity.setHandleTime(request.getParameter("handleTime"));
        tenHandleEntity.setHanldeMethod(request.getParameter("handleMethod"));
        tenHandleEntity.setPhoneType(request.getParameter("phoneType"));
        tenHandleEntity.setWhichSystem(request.getParameter("whichSystem"));
        tenHandleEntity.setWhatHandle(request.getParameter("whatHandle"));
        tenHandleEntity.setWhichThread(request.getParameter("whichThread"));
        tenHandleEntity.setHandlePage(request.getParameter("handlePage"));
     boolean result=dao.insertHandle(tenHandleEntity);
        return result+"";
    }
}
