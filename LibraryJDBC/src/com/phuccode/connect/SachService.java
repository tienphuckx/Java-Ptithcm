package com.phuccode.connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.phuccode.model.NhaXuatBan;
import com.phuccode.model.Sach;

public class SachService extends MySqlService 
{
	// RETURN A LIST OF BOOK BY SEARCH
	public ArrayList<Sach> getSachByMaNhaXuatBan(String maNhaXuatBan)
	{
		ArrayList<Sach> arrListSach = new ArrayList<Sach>();
		try
		{
			String sql = "SELECT * FROM sach WHERE MaNhaXuatBan = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, maNhaXuatBan);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				Sach sach = new Sach();
				sach.setMaSach(rs.getString("MaSach"));
				sach.setTenSach(rs.getString("TenSach"));
				sach.setMaNhaXuatBan(rs.getString("MaNhaXuatBan"));
				sach.setSoTrang(rs.getInt("SoTrang"));
				arrListSach.add(sach);
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return arrListSach;
	}
}
