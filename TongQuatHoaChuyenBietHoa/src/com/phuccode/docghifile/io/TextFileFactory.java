package com.phuccode.docghifile.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.phuccode.docghifile.model.KhachHang;

public class TextFileFactory {
	
	public static boolean save(ArrayList<KhachHang> dskh, String path)
	{
		/*
		 * ArrayList date need to save
		 * String path to save
		 * UTF-8
		 */
		try
		{
			// Standing in ram
			// Luu file --> Ram to ssd --> OUT
			// Doc file --> Ssd --> ram --> INT
			
			FileOutputStream   fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter     bw  = new BufferedWriter(osw);
			
			for(KhachHang kh: dskh)
			{
				String line = kh.getMa() + ";" + kh.getTen();
				bw.write(line);
				bw.newLine();
			}
			bw.close();
			osw.close();
			fos.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;		
	}
	
	
	public static ArrayList<KhachHang> read (String path)
	{
		ArrayList<KhachHang> result = new ArrayList<KhachHang>();
		try {
			FileInputStream    fis = new FileInputStream(path);
			InputStreamReader  isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader 	   br = new BufferedReader(isr);
			
			String line = br.readLine();
			while(line != null)
			{
				String []arr = line.split(";");
				if(arr.length == 2)
				{					
					result.add(new KhachHang(arr[0], arr[1]));
				}
				line = br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
