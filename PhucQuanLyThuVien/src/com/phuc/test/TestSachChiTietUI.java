package com.phuc.test;

import com.phuc.model.Sach;
import com.phuc.ui.SachChiTietUI;

public class TestSachChiTietUI {

	public static void main(String[] args) 
	{
		SachChiTietUI sachChiTietUI = new SachChiTietUI("Chi tiết cuốn sách");
		Sach sach = new Sach();
		sachChiTietUI.showWindow(sach);
	}

}
