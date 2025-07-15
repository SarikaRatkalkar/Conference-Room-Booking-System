package project.roomreserve;

import java.util.List;

public class EditRoomsBusiness {
	
	 Connectivity dao = new DatabaseConnectivity();

	    public List<Rooms> getAllRooms() {
	        return dao.getAllRooms();
	    }

	    public boolean deleteRoom(int id) {
	        return dao.deleteRoom(id);
	    }

	    public Rooms getRoomById(int room_id) {
	        return dao.getRoomById(room_id);
	    }

	    public boolean updateRoom(Rooms room) {
	        return dao.updateRoom(room);
	    }
}
