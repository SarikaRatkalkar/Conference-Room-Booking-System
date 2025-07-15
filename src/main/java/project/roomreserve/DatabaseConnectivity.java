package project.roomreserve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnectivity implements Connectivity{
	
	@Override
	public User getUserDetails(String username, String password, String role) {
	    User user = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomreserve", "root", "Mysql28$");

	        String query = "SELECT * FROM users WHERE u_username = ? AND u_password = ? AND role = ?";
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setString(1, username);
	        pstmt.setString(2, password);
	        pstmt.setString(3, role);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            user = new User();  // Your existing model class
	            user.setU_id(rs.getInt("u_id"));
	            user.setU_fullname(rs.getString("u_fullname"));
	            user.setU_email(rs.getString("u_email"));
	            user.setU_username(rs.getString("u_username"));
	            user.setU_password(rs.getString("u_password"));
	            user.setRole(rs.getString("role"));
	        }

	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user;  // Returns null if invalid user
	}



//	@Override
//	public boolean isValid(String user, String pass, String role) {
//		// TODO Auto-generated method stub
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomreserve","root","Mysql28$");
//			//parameterized query(prepared statement) is used to block SQL injection - hacking approach
//			String query = "select * from users where u_username=? and u_password=? and role=?";
//			PreparedStatement pstmt = con.prepareStatement(query);
//			pstmt.setString(1,user);
//			pstmt.setString(2,pass);
//			pstmt.setString(3,role);
//			 
//			
//			ResultSet rs = pstmt.executeQuery();
//			
//			if(rs.next()==true) {
//				return true;
//			}
//			else {
//				return false;
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return true;
//	}

	@Override
	public boolean insertObject(String u_fullname, String u_email, String u_username, String u_password,
			String role) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomreserve","root","Mysql28$");
			String query = "insert into users (u_fullname, u_email, u_username, u_password, role) values (?, ?, ?, ?, ?)";
			//parameterized query(prepared statement) is used to block SQL injection - hacking approach
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1,u_fullname);
			pstmt.setString(2,u_email);
			pstmt.setString(3,u_username);
			pstmt.setString(4,u_password);
			pstmt.setString(5,role);
			 
			
			int data = pstmt.executeUpdate();
			
			if(data>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertRooms(String room_name, int capacity, String location, String size, String equipment) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomreserve","root","Mysql28$");
			String query = "insert into rooms (room_name, capacity, location, size, equipment) values (?, ?, ?, ?, ?)";
			//parameterized query(prepared statement) is used to block SQL injection - hacking approach
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1,room_name);
			pstmt.setInt(2,capacity);
			pstmt.setString(3,location);
			pstmt.setString(4,size);
			pstmt.setString(5,equipment);
			 
			
			int data = pstmt.executeUpdate();
			
			if(data>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Rooms> getAllRooms() {
		// TODO Auto-generated method stub
		
		List<Rooms> roomList = new ArrayList<>();
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomreserve", "root", "Mysql28$");
	        String query = "SELECT * FROM rooms";
	        PreparedStatement stmt = con.prepareStatement(query);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Rooms r = new Rooms();
	            r.setRoom_id(rs.getInt("room_id"));
	            r.setRoom_name(rs.getString("room_name"));
	            r.setCapacity(rs.getInt("capacity"));
	            r.setLocation(rs.getString("location"));
	            r.setSize(rs.getString("size"));
	            r.setEquipment(rs.getString("equipment"));
	            roomList.add(r);
	        }
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return roomList;
	}

	@Override
	public boolean deleteRoom(int room_id) {
		// TODO Auto-generated method stub
		
		 try {
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomreserve", "root", "Mysql28$");
		        String query = "DELETE FROM rooms WHERE room_id = ?";
		        PreparedStatement stmt = con.prepareStatement(query);
		        stmt.setInt(1, room_id);
		        int result = stmt.executeUpdate();
		        con.close();
		        return result > 0;
		    } catch (Exception e) {
		        e.printStackTrace();
		        return false;
		    }
	}
	
	@Override
	public Rooms getRoomById(int room_id) {
	    Rooms room = new Rooms();
	    try {
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomreserve", "root", "Mysql28$");
	        String query = "SELECT * FROM rooms WHERE room_id = ?";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setInt(1, room_id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            room.setRoom_id(rs.getInt("room_id"));
	            room.setRoom_name(rs.getString("room_name"));
	            room.setCapacity(rs.getInt("capacity"));
	            room.setLocation(rs.getString("location"));
	            room.setSize(rs.getString("size"));
	            room.setEquipment(rs.getString("equipment"));
	        }
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return room;
	}

	@Override
	public boolean updateRoom(Rooms room) {
	    try {
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomreserve", "root", "Mysql28$");
	        String query = "UPDATE rooms SET room_name=?, capacity=?, location=?, size=?, equipment=? WHERE room_id=?";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, room.getRoom_name());
	        ps.setInt(2, room.getCapacity());
	        ps.setString(3, room.getLocation());
	        ps.setString(4, room.getSize());
	        ps.setString(5, room.getEquipment());
	        ps.setInt(6, room.getRoom_id());

	        int result = ps.executeUpdate();
	        con.close();
	        return result > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	@Override
	public List<Rooms> getAvailableRooms(String date, String startTime, String endTime) {
	    List<Rooms> availableRooms = new ArrayList<>();

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomreserve", "root", "Mysql28$");

	        String query = "SELECT * FROM rooms WHERE room_id NOT IN (" +
	                       "SELECT room_id FROM bookings WHERE booking_date = ? AND " +
	                       "((start_time < ? AND end_time > ?) OR (start_time < ? AND end_time > ?) OR (start_time >= ? AND end_time <= ?))" +
	                       ")";

	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, date);
	        ps.setString(2, endTime);  // room ends after new booking starts
	        ps.setString(3, startTime); // room starts before new booking ends
	        ps.setString(4, endTime);
	        ps.setString(5, startTime);
	        ps.setString(6, startTime); // room starts within new slot
	        ps.setString(7, endTime);   // room ends within new slot

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Rooms r = new Rooms();
	            r.setRoom_id(rs.getInt("room_id"));
	            r.setRoom_name(rs.getString("room_name"));
	            r.setCapacity(rs.getInt("capacity"));
	            r.setLocation(rs.getString("location"));
	            r.setSize(rs.getString("size"));
	            r.setEquipment(rs.getString("equipment"));
	            availableRooms.add(r);
	        }

	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return availableRooms;
	}

	@Override
	public boolean bookRoom(int user_id, int room_id, String date, String startTime, String endTime, String selectedEquipment) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomreserve", "root", "Mysql28$");

	        String query = "INSERT INTO bookings(user_id, room_id, booking_date, start_time, end_time, selected_equipment) VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setInt(1, user_id);
	        ps.setInt(2, room_id);
	        ps.setString(3, date);
	        ps.setString(4, startTime);
	        ps.setString(5, endTime);
	        ps.setString(6, selectedEquipment);

	        int rows = ps.executeUpdate();
	        con.close();
	        return rows > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	@Override
	public List<Booking> getBookingsByUserId(int user_id) {
	    List<Booking> bookings = new ArrayList<>();
	    try {
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomreserve", "root", "Mysql28$");
	        String query = "SELECT b.booking_id, r.room_name, b.booking_date, b.start_time, b.end_time, b.selected_equipment " +
	                       "FROM bookings b JOIN rooms r ON b.room_id = r.room_id WHERE b.user_id = ?";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setInt(1, user_id);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Booking b = new Booking();
	            b.booking_id = rs.getInt("booking_id");
	            b.room_name = rs.getString("room_name");
	            b.booking_date = rs.getString("booking_date");
	            b.start_time = rs.getString("start_time");
	            b.end_time = rs.getString("end_time");
	            b.selected_equipment = rs.getString("selected_equipment");
	            bookings.add(b);
	        }

	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return bookings;
	}

	@Override
	public boolean cancelBooking(int booking_id) {
	    try {
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomreserve", "root", "Mysql28$");
	        String query = "DELETE FROM bookings WHERE booking_id = ?";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setInt(1, booking_id);
	        int rows = ps.executeUpdate();
	        con.close();
	        return rows > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	@Override
	public List<Booking> getAllBookingsWithUserDetails() {
	    List<Booking> bookings = new ArrayList<>();
	    try {
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roomreserve", "root", "Mysql28$");

	        String query = "SELECT b.booking_id, u.u_fullname, u.u_email, r.room_name, b.booking_date, b.start_time, b.end_time, b.selected_equipment " +
	                       "FROM bookings b " +
	                       "JOIN users u ON b.user_id = u.u_id " +
	                       "JOIN rooms r ON b.room_id = r.room_id";

	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Booking b = new Booking();
	            b.setBooking_id(rs.getInt("booking_id"));
	            b.setEmployee_name(rs.getString("u_fullname"));
	            b.setEmployee_email(rs.getString("u_email"));
	            b.setRoom_name(rs.getString("room_name"));
	            b.setBooking_date(rs.getString("booking_date"));
	            b.setStart_time(rs.getString("start_time"));
	            b.setEnd_time(rs.getString("end_time"));
	            b.setSelected_equipment(rs.getString("selected_equipment"));
	            bookings.add(b);
	        }

	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return bookings;
	}


	
}


