package project.roomreserve;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/authenticate")
//public class LoginServlet extends HttpServlet{
//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
//		
//		String user = req.getParameter("username");
//		String pass = req.getParameter("password");
//		String role = req.getParameter("role");
//	
//		UserAuthentication object = new UserAuthentication();
//		boolean result = object.checkUser(user, pass, role);
//		
//		Connectivity db = new DatabaseConnectivity();
//        User userObj = db.getUserDetails(username, password, role);
//		PrintWriter out = res.getWriter();
//		
//		 HttpSession session = req.getSession(true);
//		
//		 if(result) {
//	            
//	            session.setAttribute("username", user);
//	            session.setAttribute("role", role);
//	            
//	            if ("admin".equals(role)) {
//	            	//out.println("valid user");
//	                res.sendRedirect("AdminDashboard.jsp");
//	            } else if ("employee".equals(role)) {
//	            	//out.println("valid user");
//	                res.sendRedirect("EmpDashboard.jsp");
//	            } else {
//	            	//out.println("invalid user");
//	            	String message = "Invalid username or password";
//					session.setAttribute("msg", message);
//					res.sendRedirect("Login.jsp");
//	                
//	            }
//	        } 
//	    }
//		
//	
//	
//	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		doGet(req, res);
//	}
	

@WebServlet("/authenticate")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        doGet(req, res);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        Connectivity db = new DatabaseConnectivity();
        User userObj = db.getUserDetails(username, password, role);

        HttpSession session = req.getSession(true);

        if (userObj != null) {
            session.setAttribute("user", userObj); // store full User object

            if ("admin".equalsIgnoreCase(role)) {
                res.sendRedirect("AdminDashboard.jsp");
            } else if ("employee".equalsIgnoreCase(role)) {
                res.sendRedirect("EmpDashboard.jsp");
            }
        } else {
            session.setAttribute("msg", "Invalid username or password");
            res.sendRedirect("Login.jsp");
        }
    }
}

