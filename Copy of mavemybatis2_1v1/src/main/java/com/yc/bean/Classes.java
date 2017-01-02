package com.yc.bean;

public class Classes {
	private int cid;
	private String cname;
	private Teacher teacher1;
	
	@Override
	public String toString() {
		return "Classes [cid=" + cid + ", cname=" + cname + ", teacher1=" + teacher1 + "]";
	}
	public Teacher getTeacher1() {
		return teacher1;
	}
	public void setTeacher1(Teacher teacher1) {
		this.teacher1 = teacher1;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	

}
