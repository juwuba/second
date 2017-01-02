package com.yc.web.serializable;

import java.io.Serializable;
import java.util.Set;

public class JsonModel implements Serializable {
	private static final long serialVersionUID = 2807790834494525811L;
	private Integer code;
	private Integer code1;
	private Integer code2;
	private String errorMsg;
	private String errorMsg1;
	private String errorMsg2;
	private Object obj;
	private Object obj1;
	private Object obj2;
	private Set<String> set;
	
	
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public Integer getCode1() {
		return code1;
	}
	public void setCode1(Integer code1) {
		this.code1 = code1;
	}
	public Integer getCode2() {
		return code2;
	}
	public void setCode2(Integer code2) {
		this.code2 = code2;
	}
	public String getErrorMsg1() {
		return errorMsg1;
	}
	public void setErrorMsg1(String errorMsg1) {
		this.errorMsg1 = errorMsg1;
	}
	public String getErrorMsg2() {
		return errorMsg2;
	}
	public void setErrorMsg2(String errorMsg2) {
		this.errorMsg2 = errorMsg2;
	}
	public Object getObj1() {
		return obj1;
	}
	public void setObj1(Object obj1) {
		this.obj1 = obj1;
	}
	public Object getObj2() {
		return obj2;
	}
	public void setObj2(Object obj2) {
		this.obj2 = obj2;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "JsonModel [code=" + code + ", code1=" + code1 + ", code2=" + code2 + ", errorMsg=" + errorMsg
				+ ", errorMsg1=" + errorMsg1 + ", errorMsg2=" + errorMsg2 + ", obj=" + obj + ", obj1=" + obj1
				+ ", obj2=" + obj2 + ", set=" + set + "]";
	}
	
	

}
