package com.example.venkada.ants.User;

public class Profile {
	private String FirstName;
	private String LastName;
	private String phone_num;
	private String address;
	
	public Profile(String firstName, String lastName, String phone_num, String address) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.phone_num = phone_num;
		this.address = address;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
