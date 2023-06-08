package org.comstudy21.travel.model;

public class ReservationVO {
	private String rno;
	private String rjumin;
	private String rname;
	private String rphone1;
	private String rphone2;
	private String rphone3;
	private String remail;
	private String rstat;
	private String tcode;
	private TravelVO travelVO;
	
	public ReservationVO() {
		this("","","","","","","","","", null);
	}
	
	public ReservationVO(String rno, String rjumin, String rname, String rphone1, String rphone2, String rphone3, String remail, String rstat, String tcode, TravelVO travelVO) {
		this.rno = rno;
		this.rjumin = rjumin;
		this.rname = rname;
		this.rphone1 = rphone1;
		this.rphone2 = rphone2;
		this.rphone3 = rphone3;
		this.remail = remail;
		this.rstat = rstat;
		this.tcode = tcode;
		this.travelVO = travelVO;
	}
	
	

	public ReservationVO(String rno) {
		this(rno,"","","","","","","","", null);
	}

	public TravelVO getTravelVO() {
		return travelVO;
	}

	public void setTravelVO(TravelVO travelVO) {
		this.travelVO = travelVO;
	}

	public String getRno() {
		return rno;
	}

	public void setRno(String rno) {
		this.rno = rno;
	}

	public String getRjumin() {
		return rjumin;
	}

	public void setRjumin(String rjumin) {
		this.rjumin = rjumin;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRphone1() {
		return rphone1;
	}

	public void setRphone1(String rphone1) {
		this.rphone1 = rphone1;
	}

	public String getRphone2() {
		return rphone2;
	}

	public void setRphone2(String rphone2) {
		this.rphone2 = rphone2;
	}

	public String getRphone3() {
		return rphone3;
	}

	public void setRphone3(String rphone3) {
		this.rphone3 = rphone3;
	}

	public String getRemail() {
		return remail;
	}

	public void setRemail(String remail) {
		this.remail = remail;
	}

	public String getRstat() {
		return rstat;
	}

	public void setRstat(String rstat) {
		this.rstat = rstat;
	}

	public String getTcode() {
		return tcode;
	}

	public void setTcode(String tcode) {
		this.tcode = tcode;
	}

	@Override
	public String toString() {
		return "ReservationVO [rno=" + rno + ", rjumin=" + rjumin + ", rname=" + rname + ", rphone1=" + rphone1
				+ ", rphone2=" + rphone2 + ", rphone3=" + rphone3 + ", remail=" + remail + ", rstat=" + rstat
				+ ", tcode=" + tcode + "]" + (travelVO!=null?travelVO.toString():"");
	}
}