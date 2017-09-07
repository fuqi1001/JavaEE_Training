package main.java.deptemp.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
//		System.out.println("do filter work before pass to next filter util hit the servlet");
        HttpServletRequest req = (HttpServletRequest)arg0;
        Object obj = req.getSession().getAttribute("invalidUser");
        if(req.getRequestURI().startsWith("/DeptEmp_JPA/login")){
            arg2.doFilter(arg0, arg1);
        }else{
            if(obj == null || (boolean)obj){
                req.getRequestDispatcher("/index.jsp").forward(arg0, arg1);
            }else{
                arg2.doFilter(arg0, arg1);
            }
        }
//		System.out.println("filter:" + req.getRequestURI());
//		System.out.println("do filter work after the servlet is done");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }
}
