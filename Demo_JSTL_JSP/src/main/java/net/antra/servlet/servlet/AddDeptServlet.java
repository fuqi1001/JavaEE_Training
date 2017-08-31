package main.java.net.antra.servlet.servlet;

import main.java.net.antra.servlet.bussinessLogic.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by qifu on 17/8/30.
 */
@WebServlet(name="addDepartment", urlPatterns="/addDepartment")
public class AddDeptServlet extends HttpServlet {
    private static final long serialVersionUID = 2816246018987310520L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("deptName");
        String email = req.getParameter("deptEmail");
        String[] employee = req.getParameterValues("employee");
        DepartmentService ds = new DepartmentService();
        req.getSession().setAttribute("deptList",
                ds.addNewDepartment(
                        name, email, employee, req.getSession().getAttribute("deptList"),
                        req.getSession().getAttribute("empList")));

        resp.sendRedirect("/addDepartment.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
