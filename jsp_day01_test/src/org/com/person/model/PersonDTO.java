package org.com.person.model;

public class PersonDTO {
	private int seq;
	private String id;
	private String name;
	private int age;
	private String email;

	public PersonDTO() {
		this(0, "", "", 0, "");
	}

	public PersonDTO(int seq, String id, String name, int age, String email) {
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public PersonDTO(int seq) {
		this.seq = seq;
		this.id = "";
		this.name = "";
		this.age = 0;
		this.email = "";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PersonDTO [seq=" + seq + ", id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}
}
