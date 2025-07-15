package project.roomreserve;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewBookedRooms")
public class EmpBookedRoomsSrevlet extends HttpServlet{

	 protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        HttpSession session = req.getSession(false);
	        User user = (User) session.getAttribute("user");

	        if (session == null || user == null || !"employee".equalsIgnoreCase(user.getRole())) {
	            res.sendRedirect("Login.jsp");
	            return;
	        }

	        Connectivity db = new DatabaseConnectivity();
	        List<Booking> bookings = db.getBookingsByUserId(user.getU_id());

	        req.setAttribute("bookings", bookings);
	        req.getRequestDispatcher("BookedRooms.jsp").forward(req, res);
	    }
	
}
