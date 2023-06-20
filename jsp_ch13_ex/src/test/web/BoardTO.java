package test.web;

import java.security.Timestamp;

public class BoardTO {
	private String num;
	private String title;
	private String author;
	private String email;
	private int writeday;

	public BoardTO() {
		this("", "", "", "", 0);
	}
	
	public BoardTO(String num, String title, String author, String email, int writday) {
	
		this.num = num;
		this.title = title;
		this.author = author;
		this.email = email;
		this.writeday = writeday;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public int getWriteday() {
		return writeday;
	}

	public void setWriteday(int writeday) {
		this.writeday = writeday;
	}

	@Override
	public String toString() {
		return "BoardTO [num=" + num + ", title=" + title + ", author=" + author + ", email=" + email + ", writeday="
				+ writeday + "]";
	}


}
