package by.grodno.nosevich.webapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.grodno.nosevich.webapp.service.DepartmentService.getDepartmentService;
import static by.grodno.nosevich.webapp.service.UserService.getUserService;

public class DeleteDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        getDepartmentService().deleteById(id);
        resp.sendRedirect("/WebAppSample/users");
    }
}