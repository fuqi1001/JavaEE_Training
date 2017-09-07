package main.java.deptemp.servlet;

import main.java.deptemp.businessLogic.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="addDepartment", urlPatterns="/addDept")
public class AddDeptServlet extends HttpServlet{
    private static final long serialVersionUID = 2816246018987310520L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("deptName");
        String email = req.getParameter("deptEmail");

        DepartmentService ds = new DepartmentService();
        req.getSession().setAttribute("deptList", ds.addNewDepartment(name, email));
        resp.sendRedirect("/addDepartment.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req,resp);
    }
}
