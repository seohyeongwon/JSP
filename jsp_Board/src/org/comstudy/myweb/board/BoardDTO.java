package org.comstudy.myweb.board;

public class BoardDTO {
	private int num;
	private String author;
	private String email;
	private String title;
	private String content;
	private String password;
	private String writeday;
	private int readcnt;
	private int rep_root;
	private int rep_step;
	private int rep_indent;

	public BoardDTO() {
		this(0, "", "", "", "", "", "", 0, 0, 0, 0);
	}

	public BoardDTO(int num) {
		this(num, "", "", "", "", "", "", 0, 0, 0, 0);
	}

	public BoardDTO(int num, String title, String content) {
		this(num, "", "", title, content, "", "", 0, 0, 0, 0);
	}

	public BoardDTO(String author, String email, String title, String content, String password) {
		
		this(0, author, email, title, content, password, "", 0, 0, 0, 0);
	}

	public BoardDTO(int num, String author, String email, String title, String content, String password,
			String writeday, int readcnt, int rep_root, int rep_step, int rep_indent) {
		this.num = num;
		this.author = author;
		this.email = email;
		this.title = title;
		this.content = content;
		this.password = password;
		this.writeday = writeday;
		this.readcnt = readcnt;
		this.rep_root = rep_root;
		this.rep_step = rep_step;
		this.rep_indent = rep_indent;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public int getRep_root() {
		return rep_root;
	}

	public void setRep_root(int rep_root) {
		this.rep_root = rep_root;
	}

	public int getRep_step() {
		return rep_step;
	}

	public void setRep_step(int rep_step) {
		this.rep_step = rep_step;
	}

	public int getRep_indent() {
		return rep_indent;
	}

	public void setRep_indent(int rep_indent) {
		this.rep_indent = rep_indent;
	}

	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", author=" + author + ", email=" + email + ", title=" + title + ", content="
				+ content + ", password=" + password + ", writeday=" + writeday + ", readcnt=" + readcnt + ", rep_root="
				+ rep_root + ", rep_step=" + rep_step + ", rep_indent=" + rep_indent + "]";
	}
}
