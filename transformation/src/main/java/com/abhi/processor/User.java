package com.abhi.processor;

public class User {
	private Long userId;
	private String userName;

	public User(Long userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
