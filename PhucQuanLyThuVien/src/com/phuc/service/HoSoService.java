package com.phuc.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.phuc.model.HoSo;

public class HoSoService extends DatabaseService 
{
	public HoSoService()
	{}
	
	public void svThemHoSo(String _MaThanhVien, String _Masach, Date _ngaymuon, int _tinhtrang)
    {
        String insertQuery = "INSERT INTO hosos (MaThanhVien, MaSach, NgayMuon, TrinhTrang) VALUES (?,?,?,?)";   
                      
        try {
            PreparedStatement ps = connection.prepareStatement(insertQuery);        
            ps.setString(1, _MaThanhVien);
            ps.setString(2, _Masach);
            ps.setDate(3, (java.sql.Date) _ngaymuon);
            ps.setInt(4, _tinhtrang); 
            
            if(ps.executeUpdate()!= 0)
            {
                JOptionPane.showMessageDialog(null, "Đã thêm!", "Thông Báo",1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Không thành công!", "Thông Báo",2);
            }
        } catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null, "Không thành công!", "Thông Báo",2);
        }
    }
	
	public int Checkexist(String _MaThanhVien, String _Masach)
    {
        String insertQuery = "SELECT * FROM hosos WHERE MaThanhVien = ? AND MaSach = ? ";                        
        try {
            PreparedStatement ps = connection.prepareStatement(insertQuery);        
            ps.setString(1, _MaThanhVien);      
            ps.setString(2, _Masach);  
            ResultSet rs = ps.executeQuery();
            rs.next();
            Date ngay = null;
            ngay = rs.getDate("NgayMuon");  
            if(ngay == null )
            {
                return 0;
            }
            else
            {
                return 1;

            }
        } catch (SQLException ex) {
        }
        return -1;
    }
	
	public ArrayList<HoSo> getTatCaHoso()
	{
		ArrayList<HoSo> arraylistHoSo = new ArrayList<HoSo>();
		try
		{
			String sql = "SELECT * FROM hosos";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				HoSo hs = new HoSo();
				hs.setMaThanhVien(rs.getString("MaThanhVien"));
				hs.setMaSach(rs.getString("MaSach"));
				hs.setNgayMuon(rs.getDate("NgayMuon"));
				hs.setTinhTrang(rs.getInt("TrinhTrang"));				
				arraylistHoSo.add(hs);				
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return arraylistHoSo;
	}
	
	public ArrayList<HoSo> getHosoByMaThanhvien(String _MaThanhVien)
	{
		ArrayList<HoSo> arraylistHoSo = new ArrayList<HoSo>();
		try
		{
			String sql = "SELECT * FROM hosos WHERE MaThanhVien LIKE CONCAT( '%',?,'%')";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, _MaThanhVien);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				HoSo hs = new HoSo();
				hs.setMaThanhVien(rs.getString("MaThanhVien"));
				hs.setMaSach(rs.getString("MaSach"));
				hs.setNgayMuon(rs.getDate("NgayMuon"));
				hs.setTinhTrang(rs.getInt("TrinhTrang"));				
				arraylistHoSo.add(hs);				
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return arraylistHoSo;
	}
	
	public ArrayList<HoSo> getHosoByMaSach(String _MaSach)
	{
		ArrayList<HoSo> arraylistHoSo = new ArrayList<HoSo>();
		try
		{
			String sql = "SELECT * FROM hosos WHERE MaSach LIKE CONCAT( '%',?,'%')";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, _MaSach);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				HoSo hs = new HoSo();
				hs.setMaThanhVien(rs.getString("MaThanhVien"));
				hs.setMaSach(rs.getString("MaSach"));
				hs.setNgayMuon(rs.getDate("NgayMuon"));
				hs.setTinhTrang(rs.getInt("TrinhTrang"));				
				arraylistHoSo.add(hs);				
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return arraylistHoSo;
	}
	
	public void xoaHoSo(String _MaThanhVien, String _Masach)
    {
        String insertQuery = "DELETE FROM hosos WHERE MaThanhVien = ? AND Masach = ?";                        
        try {
            PreparedStatement ps = connection.prepareStatement(insertQuery);        
            ps.setString(1, _MaThanhVien); 
            ps.setString(2, _Masach);
          
            if(ps.executeUpdate()!= 0)
            {
                JOptionPane.showMessageDialog(null, "Đã xóa!", "Thông Báo",1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Không thành công!", "Thông Báo",2);

            }
        } catch (SQLException ex) {
            System.err.println("Xay ra loi: "+ex);
        }
    }
}
