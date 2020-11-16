package by.grodno.nosevich.webapp.servlets;

import by.grodno.nosevich.webapp.entities.Department;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.grodno.nosevich.webapp.service.DepartmentService.getDepartmentService;

public class AddDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/AddDepartment.jsp").forward(req,resp);
    }
}
