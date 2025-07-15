package project.roomreserve;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddRooms")
public class AddRoomsServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");

        if (session == null || user == null || !"admin".equalsIgnoreCase(user.getRole())) {
            res.sendRedirect("Login.jsp");
            return;
        }
        
        String room_name = req.getParameter("room_name");
        int capacity = Integer.parseInt(req.getParameter("capacity"));
        String location = req.getParameter("location");
        String size = req.getParameter("size");
        String equipment = req.getParameter("equipment"); 

        
        AddRoomsBusiness ab = new AddRoomsBusiness();
        boolean result = ab.insertRooms(room_name, capacity, location, size, equipment);    
        if (result) {
            res.sendRedirect("AdminDashboard.jsp");
        } else {
        	res.sendRedirect("AddRooms.jsp");
        }
        
//        System.out.println("Registering user: " + u_fullname + ", " + u_email + ", " + u_username + ", role: " + role);

    }

}
