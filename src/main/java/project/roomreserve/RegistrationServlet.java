package project.roomreserve;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");

        String u_fullname = req.getParameter("u_fullname");
        String u_email = req.getParameter("u_email");
        String u_username = req.getParameter("u_username");
        String u_password = req.getParameter("u_password");
        String role = req.getParameter("role");

        RegistrationBusiness rb = new RegistrationBusiness();
        boolean result = rb.insertData(u_fullname, u_email, u_username, u_password, role);

        if (result) {
            res.sendRedirect("Login.jsp");
        } else {
            res.sendRedirect("Registration.jsp?error=1");
        }
        
        System.out.println("Registering user: " + u_fullname + ", " + u_email + ", " + u_username + ", role: " + role);

    }
}

