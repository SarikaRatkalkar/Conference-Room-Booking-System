package project.roomreserve;

public class AddRoomsBusiness {

	public boolean insertRooms(String room_name, int capacity, String location, String size, String equipment) {
		
		Connectivity obj = new DatabaseConnectivity();
		return obj.insertRooms(room_name, capacity, location, size, equipment);

}
}
