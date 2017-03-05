package com.ants.User;

import java.util.Date;

public class CareGiver extends User{
	
	private String employee_id;
	private int flag;
	private Schedule[] schedule_list;
	private Answer[] answers_list;
	
	public CareGiver(String username, String password, String first_name, String last_name, Date date_of_birth,String employee_id) {
		super(username, password, first_name, last_name, date_of_birth);
		
		this.setEmployee_id(employee_id);
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Schedule[] getSchedule_list() {
		return schedule_list;
	}

	public void setSchedule_list(Schedule[] schedule_list) {
		this.schedule_list = schedule_list;
	}

	public Answer[] getAnswers_list() {
		return answers_list;
	}

	public void setAnswers_list(Answer[] answers_list) {
		this.answers_list = answers_list;
	}

	

	

}
