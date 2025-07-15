package project.roomreserve;

public class Rooms {
	
	int room_id;
	String room_name;
	int capacity;
	String location;
	String size;
	String equipment;
	
	public Rooms() {
		// TODO Auto-generated constructor stub
	}

	public Rooms(int room_id, String room_name, int capacity, String location, String size, String equipment) {
		super();
		this.room_id = room_id;
		this.room_name = room_name;
		this.capacity = capacity;
		this.location = location;
		this.size = size;
		this.equipment = equipment;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	
	

}
