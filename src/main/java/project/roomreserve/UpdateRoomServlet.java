package project.roomreserve;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UpdateRoom")
public class UpdateRoomServlet extends HttpServlet{
	    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	        int room_id = Integer.parseInt(req.getParameter("room_id"));
	        String room_name = req.getParameter("room_name");
	        int capacity = Integer.parseInt(req.getParameter("capacity"));
	        String location = req.getParameter("location");
	        String size = req.getParameter("size");
	        String equipment = req.getParameter("equipment");

	        Rooms room = new Rooms(room_id, room_name, capacity, location, size, equipment);
	        EditRoomsBusiness rb = new EditRoomsBusiness();
	        boolean success = rb.updateRoom(room);

	        if (success) {
	            res.sendRedirect("EditRooms.jsp");
	        } else {
	            res.sendRedirect("UpdateRoom.jsp?room_id=" + room_id + "&error=1");
	        }
	    }
	}


