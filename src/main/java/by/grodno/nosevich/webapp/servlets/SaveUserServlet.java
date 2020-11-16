package by.grodno.nosevich.webapp.servlets;

import by.grodno.nosevich.webapp.entities.Department;
import by.grodno.nosevich.webapp.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static by.grodno.nosevich.webapp.service.DepartmentService.getDepartmentService;
import static by.grodno.nosevich.webapp.service.UserService.getUserService;

public class SaveUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException{
        if (fieldsNotNull(req)) {
            User user = new User();
            user.setFirstName(req.getParameter("firstName"));
            user.setLastName(req.getParameter("lastName"));
            try {
                user.setBirthdate(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("birthdate")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            user.setSalary(Integer.parseInt(req.getParameter("salary")));
            user.setDepartment(getDepartmentService().getById(
                    Integer.parseInt(req.getParameter("departmentId"))
            ));
            user.setMale(Boolean.parseBoolean(req.getParameter("male")));
            getUserService().add(user);
        }
        resp.sendRedirect("/WebAppSample/users");
    }
    private boolean fieldsNotNull(HttpServletRequest req){
        if(req.getParameter("firstName")!=null
        && req.getParameter("lastName")!=null
        && req.getParameter("salary")!=null
        && req.getParameter("departmentId")!=null
        ) return true;
        return false;
    }
}
