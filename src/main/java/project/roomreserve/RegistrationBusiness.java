package project.roomreserve;

public class RegistrationBusiness {

public boolean insertData(String u_fullname, String u_email, String u_username, String u_password, String role) {
		
		Connectivity obj = new DatabaseConnectivity();
		return obj.insertObject(u_fullname, u_email, u_username, u_password, role);
	}
}
