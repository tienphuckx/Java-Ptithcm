package com.phuc.model;

import java.util.Date;

public class HoSo 
{
	private String maThanhVien;
	private String maSach;
	private Date ngayMuon;
	private int tinhTrang;
	
	
	
	
	public HoSo() {
		super();
	}
	public HoSo(String maThanhVien, String maSach, Date ngayMuon, int tinhTrang) {
		super();
		this.maThanhVien = maThanhVien;
		this.maSach = maSach;
		this.ngayMuon = ngayMuon;
		this.tinhTrang = tinhTrang;
	}
	public String getMaThanhVien() {
		return maThanhVien;
	}
	public void setMaThanhVien(String maHoSo) {
		this.maThanhVien = maHoSo;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public Date getNgayMuon() {
		return ngayMuon;
	}
	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
	@Override
	public String toString() 
	{
		return "Thông tin hồ sơ --Mã hồ sơ:" + this.maThanhVien + this.getMaSach();
	}
	
}
