package dto;

public class UserDTO {
	/*
		    user_m_id INT AUTO_INCREMENT PRIMARY KEY, 
		    user_id VARCHAR(15) UNIQUE NOT NULL,      
		    user_name VARCHAR(15) NOT NULL,
		    user_pw VARCHAR(15) NOT NULL,
		    user_address TEXT NOT NULL,               
		    user_phone VARCHAR(20) NOT NULL
	*/
	
	private static int userManageId;
	private String userId;
	private String userName;
	private String userPw;
	private String userAddress;
	private String userPhone;
	
	public static int getUserManageId() {
		return userManageId;
	}
	public void setUserManageId(int userManageId) {
		this.userManageId = userManageId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
}