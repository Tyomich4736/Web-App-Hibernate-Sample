package by.grodno.nosevich.webapp.servlets;
import by.grodno.nosevich.webapp.entities.Department;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;

import static by.grodno.nosevich.webapp.service.DepartmentService.getDepartmentService;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> depts = getDepartmentService().getAll();
        req.setAttribute("depts",depts);
        req.getRequestDispatcher("/AddUser.jsp").forward(req,resp);
    }
}
