package com.laptrinhjavaweb.jdbc;

public class User {
	
	public User() {
		super();
	}
	public User(String name, String sdt, String address) {
		super();
		this.name = name;
		this.sdt = sdt;
		this.address = address;
	}
	private String name;
	private String sdt;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
