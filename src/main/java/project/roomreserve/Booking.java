package project.roomreserve;

public class Booking {

	int booking_id;
    String room_name;
    String booking_date;
    String start_time;
    String end_time;
    String selected_equipment;
    String employee_name;
    String employee_email;
   

    
    public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(int booking_id, String room_name, String booking_date, String start_time, String end_time,
			String selected_equipment, String employee_name, String employee_email) {
		super();
		this.booking_id = booking_id;
		this.room_name = room_name;
		this.booking_date = booking_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.selected_equipment = selected_equipment;
		this.employee_name = employee_name;
		this.employee_email = employee_email;
	}



	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getSelected_equipment() {
		return selected_equipment;
	}

	public void setSelected_equipment(String selected_equipment) {
		this.selected_equipment = selected_equipment;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}
    
	
    
}
