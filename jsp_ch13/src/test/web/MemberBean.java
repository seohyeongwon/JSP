package test.web;

public class MemberBean {
	private String name;
	private String age;
	private String weight;
	private String height;
	private String sex;

	public MemberBean() {
		this("", "", "", "", "");
	}

	public MemberBean(String name, String age, String weight, String height, String sex) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "MemberBean [name=" + name + ", age=" + age + ", weight=" + weight + ", height=" + height + ", sex="
				+ sex + "]";
	}
	

}
