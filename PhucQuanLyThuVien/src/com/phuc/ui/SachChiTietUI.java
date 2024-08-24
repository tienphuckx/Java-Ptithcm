package com.phuc.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.phuc.model.Sach;
import com.phuc.service.SachService;

public class SachChiTietUI extends JFrame 
{
	// SACH INFO
	JTextField txtMaSach, txtTenSach, txtTheLoai, txtNhaXuatBan , txtSoTrang, txtSoLuong;
	
	
	// SACH ACTION
	JButton btnSave, btnDelete;
	
	//CONSTRUCTOR
	public SachChiTietUI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}
	
	

	private void addEvents() 
	{
		// XOA SACH THEO MA SACH
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaSach();
			}
		});
		
		
		// SUA SACH THEO MA SACH
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Sach sach = new Sach();
				sach.setMa(txtMaSach.getText());
				sach.setMaNXB(txtNhaXuatBan.getText());
				sach.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
				sach.setSoTrang(Integer.parseInt(txtSoTrang.getText()));
				sach.setTen(txtTenSach.getText());
				sach.setTheLoai(txtTheLoai.getText());
				suaSach(sach);
			}
		});
	}

	protected void suaSach(Sach sach) {
		SachService sachService = new SachService();
		sachService.suaSachTheoMaSach(sach);
	}



	protected void xoaSach() {
		SachService sachService = new SachService();
		sachService.xoaSachTheoMaSach(txtMaSach.getText());
	}

	private void addControls() {
		// MAIN CONTAINER
		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
						
		JPanel sachInfor = new JPanel();		
		JPanel sachAction = new JPanel();		
				
		container.add(sachInfor);
		container.add(sachAction);
		
		// SACH INFOR ---------------------------------------------------
		sachInfor.setLayout(new BoxLayout(sachInfor, BoxLayout.Y_AXIS));
		
		JPanel pnMaSach = new JPanel();		
		txtMaSach = new JTextField(30);		
		pnMaSach.add(txtMaSach);
		sachInfor.add(pnMaSach);
		
		JPanel pnTenSach = new JPanel();		
		txtTenSach = new JTextField(30);		
		pnTenSach.add(txtTenSach);
		sachInfor.add(pnTenSach);
		
		JPanel pnTheLoai = new JPanel();		
		txtTheLoai = new JTextField(30);
		pnTheLoai.add(txtTheLoai);
		sachInfor.add(pnTheLoai);
		
		JPanel pnNhaXuatBan = new JPanel();
		txtNhaXuatBan = new JTextField(30);	
		pnNhaXuatBan.add(txtNhaXuatBan);
		sachInfor.add(pnNhaXuatBan);
		
		JPanel pnSoTrang = new JPanel();
		txtSoTrang = new JTextField(30);
		pnSoTrang.add(txtSoTrang);
		sachInfor.add(pnSoTrang);
		
		JPanel pnSoLuong = new JPanel();
		txtSoLuong = new JTextField(30);
		pnSoLuong.add(txtSoLuong);
		sachInfor.add(pnSoLuong);
		
		// DRAW BORDER FOR SO LUONG
		TitledBorder borderSoLuong = new TitledBorder(
						BorderFactory.createLineBorder(
						Color.BLACK), "Số lượng");
		pnSoLuong.setBorder(borderSoLuong);
		
		
		// DRAW BORDER FOR So Trang
		TitledBorder borderSoTrang = new TitledBorder(
						BorderFactory.createLineBorder(
						Color.BLACK), "Số trang");
		pnSoTrang.setBorder(borderSoTrang);
		
		
		// DRAW BORDER FOR TOM TAT
				TitledBorder borderMaSach = new TitledBorder(
								BorderFactory.createLineBorder(
								Color.BLACK), "Mã sách");
				pnMaSach.setBorder(borderMaSach);
		
				
		// DRAW BORDER FOR TOM TAT
		TitledBorder borderTenSach = new TitledBorder(
								BorderFactory.createLineBorder(
								Color.BLACK), "Tên sách");
				pnTenSach.setBorder(borderTenSach);
				
				
				// DRAW BORDER FOR TOM TAT
				TitledBorder borderTheLoai = new TitledBorder(
								BorderFactory.createLineBorder(
								Color.BLACK), "Thể loại");
				pnTheLoai.setBorder(borderTheLoai);
				
				
				// DRAW BORDER FOR TOM TAT
				TitledBorder borderNXB = new TitledBorder(
								BorderFactory.createLineBorder(
								Color.BLACK), "Nhà xuất bản");
				pnNhaXuatBan.setBorder(borderNXB);
		
		// SACH ACTION --------------------------------------------------
		sachAction.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JPanel pnBtnSave = new JPanel();
		btnSave = new JButton();
		pnBtnSave.add(btnSave);
		sachAction.add(pnBtnSave);
		
		JPanel pnBtnDelete = new JPanel();
		btnDelete = new JButton();
		pnBtnDelete.add(btnDelete);
		sachAction.add(pnBtnDelete);
		
		
		btnSave.setIcon(new ImageIcon("hinhanh/save.png"));
		btnDelete.setIcon(new ImageIcon("hinhanh/delete.png"));
		
		
		
		// DRAW BORDER FOR PN SACH INFO
		TitledBorder borderOfNorth = new TitledBorder(
						BorderFactory.createLineBorder(
						Color.BLACK), "Thông tin chi tiết sách");
		sachInfor.setBorder(borderOfNorth);
				
				
		// DRAW BORDER FOR PN SACH ACTION
		TitledBorder borderOfCenter = new TitledBorder(
						BorderFactory.createLineBorder(
						Color.BLACK), "Hành động");
		sachAction.setBorder(borderOfCenter);
	}
	
	public void showWindow(Sach sach) 
	{
		this.setSize(600, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		showSachDaChon(sach);
	}



	private void showSachDaChon(Sach sach) 
	{
		txtMaSach.setText(sach.getMa());
		txtNhaXuatBan.setText(sach.getMaNXB());
		txtSoLuong.setText("" + sach.getSoLuong());
		txtSoTrang.setText("" + sach.getSoTrang());
		txtTenSach.setText(sach.getTen());
		txtTheLoai.setText(sach.getTheLoai());
		
	}
}
