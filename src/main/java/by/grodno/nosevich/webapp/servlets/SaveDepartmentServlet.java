package by.grodno.nosevich.webapp.servlets;

import by.grodno.nosevich.webapp.entities.Department;
import by.grodno.nosevich.webapp.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.grodno.nosevich.webapp.service.DepartmentService.getDepartmentService;
import static by.grodno.nosevich.webapp.service.UserService.getUserService;

public class SaveDepartmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Department department = new Department();
        department.setName(req.getParameter("name"));
        department.setCity(req.getParameter("city"));
        if(!hasTheSameDepartment(department)){
            getDepartmentService().add(department);
        }
        resp.sendRedirect("/WebAppSample/users");
    }

    private boolean hasTheSameDepartment(Department dept){
        for (Department currentDept : getDepartmentService().getAll()){
            if (dept.equals(currentDept)){
                return true;
            }
        }
        return false;
    }
}
