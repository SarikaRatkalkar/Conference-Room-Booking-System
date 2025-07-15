package project.roomreserve;

import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;

@WebServlet("/AvailableRoomsServlet")
public class AvailableRoomsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String date = req.getParameter("booking_date");
        String startTime = req.getParameter("start_time");
        String endTime = req.getParameter("end_time");

        Connectivity db = new DatabaseConnectivity();
        List<Rooms> availableRooms = db.getAvailableRooms(date, startTime, endTime);

        // store booking info for reuse during booking
        HttpSession session = req.getSession();
        session.setAttribute("booking_date", date);
        session.setAttribute("start_time", startTime);
        session.setAttribute("end_time", endTime);
        session.setAttribute("availableRooms", availableRooms);

        req.getRequestDispatcher("AvailableRooms.jsp").forward(req, res);
    }
}

