package by.grodno.nosevich.webapp.servlets;

import by.grodno.nosevich.webapp.entities.Department;
import by.grodno.nosevich.webapp.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static by.grodno.nosevich.webapp.service.DepartmentService.getDepartmentService;
import static by.grodno.nosevich.webapp.service.UserService.getUserService;

public class UserTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = getUserService().getAll();
        List<Department> depts = getDepartmentService().getAll();
        req.setAttribute("users", users);
        req.setAttribute("depts", depts);
        req.getRequestDispatcher("/UserTable.jsp").forward(req,resp);
    }
}
