package user;

import java.sql.Date;

public class Question {
	
	private String question;
	private Date timestamp;

	public Question(String question, Date timestamp) {
		super();
		this.question = question;
		this.setTimestamp(timestamp);
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
