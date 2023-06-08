package org.saram.reservation.model;

public class PeopleVO {
	int pno;
	String name;
	String phone;
	String rpay;
	int rno;
	ProductVO productVo;
	
	public PeopleVO() {
		this(0, "", "", "", 0, null);
	}
	
	public PeopleVO(int pno) {
		this.pno = pno;
	}

	public PeopleVO(int pno, String name, String phone, String rpay, int rno) {
		this.pno = pno;
		this.name = name;
		this.phone = phone;
		this.rpay = rpay;
		this.rno = rno;
	}

	public PeopleVO(int pno, String name, String phone, String rpay, int rno, ProductVO productVo) {
		super();
		this.pno = pno;
		this.name = name;
		this.phone = phone;
		this.rpay = rpay;
		this.rno = rno;
		this.productVo = productVo;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRpay() {
		return rpay;
	}

	public void setRpay(String rpay) {
		this.rpay = rpay;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public ProductVO getProductVo() {
		return productVo;
	}

	public void setProductVo(ProductVO productVo) {
		this.productVo = productVo;
	}

	@Override
	public String toString() {
		return "PeopleVO [pno=" + pno + ", name=" + name + ", phone=" + phone + ", rpay=" + rpay + ", rno=" + rno
				+ ", productVo=" + productVo + "]";
	}
}
