package com.phuccode.docghifile.model;

public class KhachHang {
	private String ma;
	private String ten;
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
	public KhachHang(String ma, String ten) {
		super();
		this.ma = ma;
		this.ten = ten;
	}
	public KhachHang() {
		super();
	}
	@Override
	public String toString() {
		return "KhachHang [ma=" + ma + ", ten=" + ten + "]";
	}
	
	
}
