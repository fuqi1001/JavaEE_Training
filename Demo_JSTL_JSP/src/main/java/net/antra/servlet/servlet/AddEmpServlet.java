package main.java.net.antra.servlet.servlet;

import main.java.net.antra.servlet.bussinessLogic.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by qifu on 17/8/30.
 */
@WebServlet(name="addEmployee", urlPatterns="/addEmployee")
public class AddEmpServlet extends HttpServlet{
    private static final long serialVersionUID = 2816246018987310520L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("firstName");
        String last_name = req.getParameter("lastName");
        String age = req.getParameter("age");
        EmployeeService es = new EmployeeService();
        req.getSession().setAttribute("empList", es.addNewEmployee(first_name, last_name, age,req.getSession().getAttribute("empList")));

        resp.sendRedirect("/addEmployee.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
