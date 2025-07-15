package project.roomreserve;

import java.util.List;

public interface Connectivity {
	
	public User getUserDetails(String username, String password, String role);

//	public boolean isValid(String user, String pass, String role);
	
	public boolean insertObject(String u_fullname, String u_email, String u_username, String u_password, String role);
	
	public boolean insertRooms(String room_name, int capacity, String location, String size, String equipment);
	
	public List<Rooms> getAllRooms();
	
	public boolean deleteRoom(int room_id);
	
	public Rooms getRoomById(int room_id);
	
	public boolean updateRoom(Rooms room);
	
	public List<Rooms> getAvailableRooms(String date, String startTime, String endTime);
	
	public boolean bookRoom(int user_id, int room_id, String date, String startTime, String endTime, String selectedEquipment);
	
	List<Booking> getBookingsByUserId(int user_id);
	
	boolean cancelBooking(int booking_id);
	
	List<Booking> getAllBookingsWithUserDetails();




}
