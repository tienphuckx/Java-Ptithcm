package com.phuccode;

public abstract class NhanVien 
{
	// ABSTRACT NHAN VIEN
	// CO RAT NHIEU LOAI NHAN VIEN
	// MOI LOAI NHAN VIEN CO LUONG KHAC NHAU
	private String ten;
	private String cmnd;
	
	
	
	@Override
	public String toString() {
		return "NhanVien [Ten=" + ten + ", Luong=" + xuatLuong() + "]";
	}



	public NhanVien() {
		super();
	}



	public NhanVien(String ten, String cmnd) {
		super();
		this.ten = ten;
		this.cmnd = cmnd;
	}



	public String getTen() {
		return ten;
	}



	public void setTen(String ten) {
		this.ten = ten;
	}



	public String getCmnd() {
		return cmnd;
	}



	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}



	public abstract int xuatLuong();
}
