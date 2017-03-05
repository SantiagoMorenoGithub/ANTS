package com.ants.User;

import java.util.Map;

public class Schedule {
	private Question question;
	private int hour;
	private int min;
	private Map<String, Boolean> day;

	/**
	 * @param question
	 * @param hour
	 * @param min
	 * @param day
	 */
	public Schedule(Question question, int hour, int min, Map<String, Boolean> day) {
		super();
		this.question = question;
		this.hour = hour;
		this.min = min;
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Map<String, Boolean> getDay() {
		return day;
	}

	public void setDay(Map<String, Boolean> day) {
		this.day = day;
	}
}
