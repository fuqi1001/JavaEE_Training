package main.java.net.antra.servlet.servlet;

import main.java.net.antra.servlet.utility.UserUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by qifu on 17/8/29.
 */
@WebServlet(name="login", urlPatterns="/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 7381248825996568609L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String psw = req.getParameter("password");

        boolean isValidUser = UserUtility.validateUser(userName, psw, req);
        if(isValidUser) {
            req.getSession().setAttribute("invalidUser", false);
            req.getSession().setAttribute("userName", userName.toUpperCase());
            req.getRequestDispatcher("/success.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("invalidUser", true);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("servlet got destroyed");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("servlet got initialized");
    }
}
