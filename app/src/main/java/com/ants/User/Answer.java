package user;

import java.sql.Date;

public class Answer {
	private String answer;
	private Date timestamp;
	
	public Answer(String answer, Date timestamp) {
		super();
		this.answer = answer;
		this.setTimestamp(timestamp);
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	

}
