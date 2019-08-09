package com.bae.persistence.domain;

public class SentUser {

	private int id;
	private String name;
	private int memberId;

	public SentUser() {

	}

	public SentUser(int id, String name, int memberId) {
		this.id = id;
		this.name = name;
		this.memberId = memberId;
	}

	public SentUser(User u) {
		this.id = u.getId();
		this.name = u.getName();
		this.memberId = u.getMemberId();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getMemberId() {
		return memberId;
	}

}
