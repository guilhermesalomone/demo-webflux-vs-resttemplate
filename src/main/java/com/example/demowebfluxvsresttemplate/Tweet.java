package com.example.demowebfluxvsresttemplate;

public class Tweet {

	private String msg;
	private String user;

	public Tweet() {
		super();
	}

	public Tweet(String msg, String user) {
		this.msg = msg;
		this.user = user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	

}
