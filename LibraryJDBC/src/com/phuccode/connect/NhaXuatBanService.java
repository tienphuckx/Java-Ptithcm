package com.phuccode.connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.phuccode.model.NhaXuatBan;

public class NhaXuatBanService extends MySqlService 
{
	

	// GET LIST NHA XUAT BAN
	public ArrayList<NhaXuatBan> getAllNhaXuatBan()
	{
		
		ArrayList<NhaXuatBan> arraylistNhaXuatBan = new ArrayList<NhaXuatBan>();
		try
		{
			String sql = "SELECT * FROM nhaxuatban";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				NhaXuatBan nhaXuatBan = new NhaXuatBan();
				nhaXuatBan.setMaNhaXuatBan(rs.getString("MaNhaXuatBan"));
				nhaXuatBan.setTenNhaXuatBan(rs.getString("TenNhaXuatBan"));
				nhaXuatBan.setDiaChi(rs.getString("DiaChi"));
				nhaXuatBan.setDienThoai(rs.getNString("SoPhone"));
				
				arraylistNhaXuatBan.add(nhaXuatBan);				
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return arraylistNhaXuatBan;
	}
}
