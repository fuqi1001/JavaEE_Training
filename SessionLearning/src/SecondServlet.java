import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class SecondServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            HttpSession session = request.getSession(false);
            String n = (String)session.getAttribute("uname");
            String sid = (String)session.getId();
            out.print("Hello " + n + " sessionId: "+ sid + " creation time: " + session.getCreationTime());
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
