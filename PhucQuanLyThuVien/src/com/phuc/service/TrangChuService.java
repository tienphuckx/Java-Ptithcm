package com.phuc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TrangChuService extends DatabaseService 
{
	// COUNT SO LUONG SACH
	public int getSoLuongSach()
	{
		int soLuongSach = 0;
		String sql = "SELECT COUNT(*) FROM sach";

		try
		{
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
		    soLuongSach += rs.getInt(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return soLuongSach;
	}
	// COUNT SO LUONG THE LOAI
	public int getSoLuongTheLoai()
	{
		int soLuongTheLoai = 0;
		String sql = "SELECT COUNT(*) FROM theloai";

		try
		{
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			soLuongTheLoai += rs.getInt(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return soLuongTheLoai;
	}
	
	
	// COUNT SO LUONG NHA XUAT BAN
	public int getSoLuongNXB()
	{
		int soLuongNXB = 0;
		
		String sql = "SELECT COUNT(*) FROM nhaxuatban";

		try
		{
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			soLuongNXB += rs.getInt(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return soLuongNXB;
	}
	

	// COUNT SO LUONG HO SO
	public int getSoLuongHS()
	{
		int soLuongHS = 0;
		String sql = "SELECT COUNT(*) FROM hosos";
		try
		{
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			soLuongHS += rs.getInt(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return soLuongHS;
	}
	
	// COUNT SO LUONG HO SO DANG MUON
	public int getSoLuongHSDM()
	{
		int soLuongHSDM = 0;
		String sql = "SELECT COUNT(*) FROM hosos WHERE TrinhTrang=1";
		try
		{
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			soLuongHSDM += rs.getInt(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return soLuongHSDM;
	}
	
	// COUNT SO LUONG HO SO DA XONG
	public int getSoLuongHSDX()
	{
		int soLuongHSDX = 0;
		String sql = "SELECT COUNT(*) FROM hosos WHERE TrinhTrang=0";
		try
		{
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			soLuongHSDX += rs.getInt(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return soLuongHSDX;
	}
}
