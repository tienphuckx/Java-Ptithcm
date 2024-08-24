package com.phuc.model;

public class NhaXuatBan {
	private String ma;
	private String ten;
	private String diaChi;
	private String soPhone;
	
	
	
	
	
	public NhaXuatBan() {
		super();
	}
	public NhaXuatBan(String ma, String ten, String diaChi, String soPhone) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.diaChi = diaChi;
		this.soPhone = soPhone;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoPhone() {
		return soPhone;
	}
	public void setSoPhone(String soPhone) {
		this.soPhone = soPhone;
	}
	@Override
	public String toString() 
	{
		return "Thông tin nhà xuất bản -- :" + this.getTen();
	}
	
}
