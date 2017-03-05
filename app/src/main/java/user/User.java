package user;

public abstract class User {
	private String userName;
	private String password;
	private Profile info;
	

	public User(String userName, String password) {
		super();
		this.userName = userName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setProfile(String firstName, String lastName, String phone_num, String address){
		this.info = new Profile(firstName, lastName, phone_num, address)  ;
	}
}
