package com.phuc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.phuc.model.Sach;

public class SachService extends DatabaseService
{
		// GET TAT CA SACH
		public ArrayList<Sach> getTatCaSach()
		{
			ArrayList<Sach> arraylistSach = new ArrayList<Sach>();
			try
			{
				String sql = "SELECT * FROM sach";
				PreparedStatement stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					Sach sach = new Sach();
					sach.setMa(rs.getString("MaSach"));
					sach.setTen(rs.getString("TenSach"));
					sach.setMaNXB(rs.getString("MaNhaXuatBan"));
					sach.setSoTrang(rs.getInt("SoTrang"));
					sach.setSoLuong(rs.getInt("SoLuong"));
					sach.setTheLoai(rs.getString("MaTheLoai"));
					
					arraylistSach.add(sach);				
				}
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			return arraylistSach;
		}

		// GET SACH BY MA THE LOAI getSachByMaTheLoai
		public ArrayList<Sach> getSachByMaTheLoai(String maTheLoai)
		{
			ArrayList<Sach> arrListSach = new ArrayList<Sach>();
			try
			{
				String sql = "SELECT * FROM sach WHERE MaTheLoai LIKE CONCAT( '%',?,'%')";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, maTheLoai);
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next())
				{
					Sach sach = new Sach();
					sach.setMa(rs.getString("MaSach"));
					sach.setTen(rs.getString("TenSach"));
					sach.setMaNXB(rs.getString("MaNhaXuatBan"));
					sach.setSoLuong(rs.getInt("SoLuong"));
					sach.setSoTrang(rs.getInt("SoTrang"));
					sach.setTheLoai(rs.getString("MaTheLoai"));
					arrListSach.add(sach);
				}
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			return arrListSach;
		}
		
		
		// TIM KIEM SACH THEO TEN     (like CONCAT( '%',?,'%')";)
		public ArrayList<Sach> getTheoTen(String ten)
		{
			ArrayList<Sach> arrListSach = new ArrayList<Sach>();
			try
			{
				String sql = "SELECT * FROM sach WHERE TenSach LIKE CONCAT( '%',?,'%')";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, ten);
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					Sach sach = new Sach();
					sach.setMa(rs.getString("MaSach"));
					sach.setTen(rs.getString("TenSach"));
					sach.setMaNXB(rs.getString("MaNhaXuatBan"));
					sach.setSoLuong(rs.getInt("SoLuong"));
					sach.setSoTrang(rs.getInt("SoTrang"));
					sach.setTheLoai(rs.getString("MaTheLoai"));
					arrListSach.add(sach);
				}
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}		
			
			return arrListSach;
		}
		
		// TIM KIEM SACH THEO TEN
		public ArrayList<Sach> getTheoMaNXB(String maNXB)
		{
			ArrayList<Sach> arrListSach = new ArrayList<Sach>();
					
			try
			{
				String sql = "SELECT * FROM sach WHERE MaNhaXuatBan LIKE CONCAT( '%',?,'%')";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, maNXB);
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					Sach sach = new Sach();
					sach.setMa(rs.getString("MaSach"));
					sach.setTen(rs.getString("TenSach"));
					sach.setMaNXB(rs.getString("MaNhaXuatBan"));
					sach.setSoLuong(rs.getInt("SoLuong"));
					sach.setSoTrang(rs.getInt("SoTrang"));
					sach.setTheLoai(rs.getString("MaTheLoai"));
					arrListSach.add(sach);
				}
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}		
			return arrListSach;
		}

		// THEM MOI SACH
		public void themSach(Sach sach)
		{

			String sql = "INSERT INTO sach(MaSach,TenSach,MaNhaXuatBan,SoTrang,SoLuong,MaTheLoai) VALUES(?,?,?,?,?,?)";
			
			try
			{
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, sach.getMa());
				stmt.setString(2, sach.getTen());
				stmt.setString(3, sach.getMaNXB());
				stmt.setInt(4, sach.getSoTrang());
				stmt.setInt(5, sach.getSoLuong());
				stmt.setString(6, sach.getTheLoai());
				stmt.execute();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			} 
		}
		
		// XOA SACH THEO maSach
		public void xoaSachTheoMaSach(String maSach)
		{
			String sql = "DELETE FROM sach WHERE MaSach=?";
			
			try
			{
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, maSach);
				stmt.executeUpdate();
				/*
				 * 
				int rows = stmt.executeUpdate();
				if(rows > 0) {
					System.out.println("DELETE SUCCESSFULLY!");
				}else {
					System.out.println("FAIL TO DELETE!");
				}
				
				*/
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			} 
		}

		public void suaSachTheoMaSach(Sach sach) 
		{
			/*
			 * String sql = "UPDATE users SET fullname=?, password=?, email=? WHERE username=?";			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, new_fullname);
			stmt.setString(2, new_password);
			stmt.setString(3, new_email);
			stmt.setString(4, huyentran);
			int rows = stmt.executeUpdate();
			if(rows > 0) {
				System.out.println("UPDATE SUCCESSFULLY!");
			}else {
				System.out.println("FAIL TO UPDATE!");
			}
			
			
			MaSach,TenSach,MaNhaXuatBan,SoTrang,SoLuong,MaTheLoai
			 */
			
			String sql = "UPDATE sach SET TenSach=?, MaNhaXuatBan=?, SoTrang=?, SoLuong=?, MaTheLoai=? WHERE MaSach=?";
			
			try
			{
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, sach.getTen());
				stmt.setString(2, sach.getMaNXB());
				stmt.setInt(3, sach.getSoTrang());
				stmt.setInt(4, sach.getSoLuong());
				stmt.setString(5, sach.getTheLoai());
				stmt.setString(6, sach.getMa());
				int rows = stmt.executeUpdate();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			
		}
		
		
}
