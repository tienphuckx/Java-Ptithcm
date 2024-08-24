package com.phuc.model;

public class ThanhVien 
{
	private String ma;
	private String hoTen;
	private String soPhone;
	
	
	public ThanhVien() {
		super();
	}
	public ThanhVien(String ma, String hoTen, String soPhone) {
		super();
		this.ma = ma;
		this.hoTen = hoTen;
		this.soPhone = soPhone;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getHoTen() {
		return hoTen; 
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSoPhone() {
		return soPhone;
	}
	public void setSoPhone(String soPhone) {
		this.soPhone = soPhone;
	}
	
	
}
