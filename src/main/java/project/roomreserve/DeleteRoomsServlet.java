package project.roomreserve;


import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DeleteRoom")
public class DeleteRoomsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int roomId = Integer.parseInt(req.getParameter("room_id"));

        EditRoomsBusiness rb = new EditRoomsBusiness();
        rb.deleteRoom(roomId);

        res.sendRedirect("EditRooms.jsp");
    }
}

