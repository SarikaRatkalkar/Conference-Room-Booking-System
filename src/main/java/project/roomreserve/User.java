package project.roomreserve;

public class User {
	
	int u_id;
	String u_fullname;
	String u_email;
	String u_username;
	String u_password;
	String role;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int u_id, String u_fullname, String u_email, String u_username, String u_password, String role) {
		super();
		this.u_id = u_id;
		this.u_fullname = u_fullname;
		this.u_email = u_email;
		this.u_username = u_username;
		this.u_password = u_password;
		this.role = role;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_fullname() {
		return u_fullname;
	}

	public void setU_fullname(String u_fullname) {
		this.u_fullname = u_fullname;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_username() {
		return u_username;
	}

	public void setU_username(String u_username) {
		this.u_username = u_username;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
