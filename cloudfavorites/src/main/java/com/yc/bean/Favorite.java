package com.yc.bean;

import java.io.Serializable;

public class Favorite implements Serializable{
	private Integer f_id ;
	private String f_label ;
	private String f_url ; 
	private String f_tags ;
	private String f_desc ;
	private Integer t_count;
	public Integer getT_count() {
		return t_count;
	}
	public void setT_count(Integer t_count) {
		this.t_count = t_count;
	}
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public String getF_label() {
		return f_label;
	}
	public void setF_label(String f_label) {
		this.f_label = f_label;
	}
	public String getF_url() {
		return f_url;
	}
	public void setF_url(String f_url) {
		this.f_url = f_url;
	}
	public String getF_tags() {
		return f_tags;
	}
	public void setF_tags(String f_tags) {
		this.f_tags = f_tags;
	}
	public String getF_desc() {
		return f_desc;
	}
	public void setF_desc(String f_desc) {
		this.f_desc = f_desc;
	}
	@Override
	public String toString() {
		return "Favorite [f_id=" + f_id + ", f_label=" + f_label + ", f_url=" + f_url + ", f_tags=" + f_tags
				+ ", f_desc=" + f_desc + ", t_count=" + t_count + "]";
	}
	
	
}
