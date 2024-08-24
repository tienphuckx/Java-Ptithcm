package com.phuc.model;

public class Sach 
{
	private String ma;
	private String ten;
	private String maNXB;
	private int soTrang;
	private int soLuong;
	private String theLoai;
	
	
	
	
	
	public Sach() {
		super();
	}
	public Sach(String ma, String ten, String maNXB, int soTrang, int soLuong, String theLoai) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.maNXB = maNXB;
		this.soTrang = soTrang;
		this.soLuong = soLuong;
		this.theLoai = theLoai;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
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
	public String getMaNXB() {
		return maNXB;
	}
	public void setMaNXB(String maNXB) {
		this.maNXB = maNXB;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	@Override
	public String toString() 
	{
		return "Tên sách :" + this.getTen();
	}
	
}
