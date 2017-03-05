package com.ants.User;

import java.util.Date;

public class Patient extends User{
	
	private Date date_of_dignosis;
	
	public Patient(String username, String password, String first_name, String last_name, Date date_of_birth,Date date_of_dignosis ) {
		super(username, password, first_name, last_name, date_of_birth);
		this.setDate_of_dignosis(date_of_dignosis);
	}
	public Date getDate_of_dignosis() {
		return date_of_dignosis;
	}
	public void setDate_of_dignosis(Date date_of_dignosis) {
		this.date_of_dignosis = date_of_dignosis;
	}

	

}
