package by.grodno.nosevich.webapp.servlets;

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

public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        /*User user = getUserService().getById(id);
        getUserService().delete(user);*/
        getUserService().deleteById(id);
        resp.sendRedirect("/WebAppSample/users");
    }
}