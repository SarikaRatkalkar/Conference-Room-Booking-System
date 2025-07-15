package project.roomreserve;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewAllBookings")
public class ViewAllBookingsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");

        if (session == null || user == null || !"admin".equalsIgnoreCase(user.getRole())) {
            res.sendRedirect("Login.jsp");
            return;
        }

        Connectivity db = new DatabaseConnectivity();
        List<Booking> bookings = db.getAllBookingsWithUserDetails();

        req.setAttribute("bookings", bookings);
        req.getRequestDispatcher("ViewAllBookings.jsp").forward(req, res);
    }
}

