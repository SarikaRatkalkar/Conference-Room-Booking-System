package project.roomreserve;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CancelBooking")
public class CancelBookingServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int booking_id = Integer.parseInt(req.getParameter("booking_id"));
        Connectivity db = new DatabaseConnectivity();

        boolean result = db.cancelBooking(booking_id);
        if (result) {
            res.sendRedirect("EmpDashboard.jsp?msg=Booking+Cancelled");
        } else {
            res.sendRedirect("BookedRooms.jsp?error=1");
        }
    }
}
