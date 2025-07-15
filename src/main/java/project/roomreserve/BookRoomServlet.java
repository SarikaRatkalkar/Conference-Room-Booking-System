package project.roomreserve;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;

@WebServlet("/BookRoom")
public class BookRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null || !"employee".equalsIgnoreCase(user.getRole())) {
            res.sendRedirect("Login.jsp");
            return;
        }

        int user_id = user.getU_id();
        int room_id = Integer.parseInt(req.getParameter("room_id"));
        String date = req.getParameter("booking_date");
        String startTime = req.getParameter("start_time");
        String endTime = req.getParameter("end_time");

        String[] selectedEquipments = req.getParameterValues("selected_equipment");
        String equipmentStr = "";

        if (selectedEquipments != null) {
            equipmentStr = String.join(", ", selectedEquipments);
        }

        Connectivity db = new DatabaseConnectivity();
        boolean result = db.bookRoom(user_id, room_id, date, startTime, endTime, equipmentStr);

        if (result) {
            res.sendRedirect("EmpDashboard.jsp?msg=Booking Successful");
        } else {
            res.sendRedirect("AvailableRooms.jsp?msg=Booking Failed");
        }
    }
}

