package org.comstudy21.travel.model;

public class TravelVO {
	private String tcode;
	private String tarea;
	private String tdate;
	private String ttime;
	private int tday;
	private String thotel;
	private int tmoney;
	private String tair;
	
	public TravelVO() {
		this("", "", "", "", 0, "", 0, "");
	}

	public TravelVO(String tcode, String tarea, String tdate, String ttime, int tday, String thotel, int tmoney, String tair) {
		this.tcode = tcode;
		this.tarea = tarea;
		this.tdate = tdate;
		this.ttime = ttime;
		this.tday = tday;
		this.thotel = thotel;
		this.tmoney = tmoney;
		this.tair = tair;
	}

	public String getTcode() {
		return tcode;
	}

	public void setTcode(String tcode) {
		this.tcode = tcode;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getTdate() {
		return tdate;
	}

	public void setTdate(String tdate) {
		this.tdate = tdate;
	}

	public String getTtime() {
		return ttime;
	}

	public void setTtime(String ttime) {
		this.ttime = ttime;
	}

	public int getTday() {
		return tday;
	}

	public void setTday(int tday) {
		this.tday = tday;
	}

	public String getThotel() {
		return thotel;
	}

	public void setThotel(String thotel) {
		this.thotel = thotel;
	}

	public int getTmoney() {
		return tmoney;
	}

	public void setTmoney(int tmoney) {
		this.tmoney = tmoney;
	}

	public String getTair() {
		return tair;
	}

	public void setTair(String tair) {
		this.tair = tair;
	}

	@Override
	public String toString() {
		return tcode + "-" + tarea + "-" + tdate + "-" + ttime + "/" + "/" + thotel + "/" + tair;
	}
}
