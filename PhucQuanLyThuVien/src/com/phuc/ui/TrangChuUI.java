package com.phuc.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.phuc.model.Sach;
import com.phuc.service.SachService;
import com.phuc.service.TrangChuService;

public class TrangChuUI extends JFrame 
{
	// VARABLE
	
	// NORTH LEFT SITE --> BOOK INFO ----------------------------------------------------
	JTextField txtSoLuongSach, txtSoLuongTheLoai, txtSoLuongNXB;
	JButton btnChiTietSach,btnSLSach,btnListNhaXuatBan,btnListTheLoai;
	
	// NORTH RIGHT SITE --> HO SO INFO ----------------------------------------------------
	JTextField txtSoLuongHoSo, txtSoLuongHoSoDangMuon, txtSoLuongHoSoDaXong;
	JButton btnChiTietHoSo;
	
	
	// CENTER ----------------------------------------------------
	DefaultTableModel dtmSach;
	JTable tblSach;
	
	// SOUTH ----------------------------------------------------
	JButton btnAboutUs;
	
	// ARRAYLIST 10 SACH MOI NHAT
	ArrayList<Sach> arrayListSach = null;
	
	// CONSTRUCTOR
	public TrangChuUI(String title)
	{
		super(title);
		addControls();
		addEvents();
		
		showMuoiSachMoiNhat();
		
		showThongKeSach();
		showThongKeSoLuongTheLoai();
		showThongKeSoLuongNXB();
		
		showSoLuongHS();
		showSoLuongHSDangMuon();
		showSoLuongHSDaXong();
	}

	private void showSoLuongHSDaXong() {
		// TODO Auto-generated method stub
		TrangChuService trangChuService = new TrangChuService();		
		txtSoLuongHoSoDaXong.setText("" + trangChuService.getSoLuongHSDX());
	}

	private void showSoLuongHSDangMuon() {
		// TODO Auto-generated method stub
		TrangChuService trangChuService = new TrangChuService();		
		txtSoLuongHoSoDangMuon.setText("" + trangChuService.getSoLuongHSDM());
	}

	private void showSoLuongHS() {
		// TODO Auto-generated method stub
		TrangChuService trangChuService = new TrangChuService();	
		txtSoLuongHoSo.setText("" + trangChuService.getSoLuongHS());
	}

	private void showThongKeSoLuongNXB() {
		// TODO Auto-generated method stub
		TrangChuService trangChuService = new TrangChuService();
		txtSoLuongNXB.setText(""+trangChuService.getSoLuongNXB());
	}

	private void showThongKeSoLuongTheLoai() {
		// TODO Auto-generated method stub
		TrangChuService trangChuService = new TrangChuService();
		txtSoLuongTheLoai.setText(""+trangChuService.getSoLuongTheLoai());
	}

	private void showThongKeSach() {
		TrangChuService trangChuService = new TrangChuService();
		txtSoLuongSach.setText(""+trangChuService.getSoLuongSach());
		
	}

	private void showMuoiSachMoiNhat() 
	{		
				SachService sachService = new SachService();
				arrayListSach = sachService.getTatCaSach();
				
				// SHOW DATA TO MAIN TABLE
				dtmSach.setRowCount(0);
				for(Sach sach : arrayListSach)
				{
					Vector<Object> vector = new Vector<Object>();
					vector.add(sach.getMa());
					vector.add(sach.getTen());
					vector.add(sach.getSoTrang());
					vector.add(sach.getSoLuong());
					vector.add(sach.getTheLoai());
					dtmSach.addRow(vector);
				}
	}

	private void addEvents() 
	{
		// OPEN TRANG CHI TIET SACH 
		btnChiTietSach.addActionListener(new ActionListener() 
		{
					
					@Override
					public void actionPerformed(ActionEvent e) {
						SachUI searchUI = new SachUI("Trang sách");
						searchUI.showWindow();
					}
		});
				
				
		// OPEN TRANG CHI TIET HO SO
		/*
		btnChiTietHoSo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HoSoUI hoSoUI = new HoSoUI("Trang hồ sơ");
				hoSoUI.showWindow();
			}
		});	
		*/
		
		
		// OPEN TRANG CHI TIET HO SO
		
				btnChiTietHoSo.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						HoSoUI hoSoUI = new HoSoUI("Trang hồ sơ");
						hoSoUI.showWindow();
					}
				});	
	}

	private void addControls() 
	{		
		// MAIN CONTAINER
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		JPanel pnNorth = new JPanel();		
		JPanel pnCenter = new JPanel();		
		JPanel pnSouth = new JPanel();
		
			
		container.add(pnNorth, BorderLayout.NORTH);
		
		container.add(pnCenter, BorderLayout.CENTER);
		container.add(pnSouth, BorderLayout.SOUTH);
		  
		
		
		
		// THE NORTH PART
		pnNorth.setLayout(new BorderLayout());
		JPanel pnNorthLeft = new JPanel(); // LEFT PANEL --> WEST
		JPanel pnNorthCenter = new JPanel();  // CENTER --> CENTER
		JPanel pnNorthRight = new JPanel(); // RIGHT PANEL --> EAST
		pnNorth.add(pnNorthLeft, BorderLayout.CENTER);
		pnNorth.add(pnNorthRight, BorderLayout.EAST);
		
		
		
		
		
		
		// THE NORTH LEFT ---------------------------------------------------------
		pnNorthLeft.setLayout(new BoxLayout(pnNorthLeft, BoxLayout.Y_AXIS));
		
		// TIEU DE SACH
		JPanel pnTieuDeSach = new JPanel();
		JLabel lblTieuDeSach = new JLabel("SÁCH");
		lblTieuDeSach.setForeground(Color.BLACK);
		Font fPublisher = new Font("arial", Font.BOLD, 15);
		lblTieuDeSach.setFont(fPublisher);
		pnTieuDeSach.add(lblTieuDeSach);
		pnNorthLeft.add(pnTieuDeSach);
				
		// PANEL SO LUONG SACH
		JPanel pnSoLuongSach = new JPanel();
		JLabel lblSoLuongSach = new JLabel("Số lượng sách");
		txtSoLuongSach = new JTextField(5);
		btnSLSach = new JButton("Thêm sách");
		pnSoLuongSach.add(lblSoLuongSach);
		pnSoLuongSach.add(txtSoLuongSach);
//		pnSoLuongSach.add(btnSLSach);
		pnNorthLeft.add(pnSoLuongSach);
		
		// PANEL SO LUONG THE LOAI
		JPanel pnSoLuongTheLoai = new JPanel();
		JLabel lblSoLuongTheLoai = new JLabel("Số lượng thể loại");
		txtSoLuongTheLoai = new JTextField(5);
		btnListTheLoai = new JButton("Thêm thể loại");
		pnSoLuongTheLoai.add(lblSoLuongTheLoai);
		pnSoLuongTheLoai.add(txtSoLuongTheLoai);
//		pnSoLuongTheLoai.add(btnListTheLoai);
		pnNorthLeft.add(pnSoLuongTheLoai);
		
		// PANEL SO LUONG NHA XUAT BAN
		JPanel pnSoLuongNXB = new JPanel();
		JLabel lblSoLuongNXB = new JLabel("Số lượng nhà xuất bản");
		txtSoLuongNXB = new JTextField(5);
		btnListNhaXuatBan = new JButton("Thêm nhà sản xuất");
		pnSoLuongNXB.add(lblSoLuongNXB);
		pnSoLuongNXB.add(txtSoLuongNXB);
//		pnSoLuongNXB.add(btnListNhaXuatBan);
		pnNorthLeft.add(pnSoLuongNXB);
		
		
		JPanel pnBtnTrangSach = new JPanel();
		btnChiTietSach = new JButton("Chi tiết Trang sách");
		pnBtnTrangSach.add(btnChiTietSach);
		pnNorthLeft.add(pnBtnTrangSach);
		
		
		
		
		
		
				
		// THE NORTH RIGHT ---------------------------------------------------------
		pnNorthRight.setLayout(new BoxLayout(pnNorthRight, BoxLayout.Y_AXIS));
		
		//  TIEU DE HO SO
		JPanel pnHoSo = new JPanel();
		JLabel lblHoSo = new JLabel("HỒ SƠ");
		lblHoSo.setForeground(Color.BLACK);
		Font fHoSo = new Font("arial", Font.BOLD, 15);
		lblHoSo.setFont(fHoSo);
		pnHoSo.add(lblHoSo);
		pnNorthRight.add(pnHoSo);
		
		// PANEL SO LUONG HO SO
		JPanel pnSoLuongHoSo = new JPanel();
		JLabel lblSoLuongHoSo = new JLabel("Số lượng hồ sơ");
		txtSoLuongHoSo = new JTextField(5);
//		btnSLHoSo = new JButton("Danh sách");
		pnSoLuongHoSo.add(lblSoLuongHoSo);
		pnSoLuongHoSo.add(txtSoLuongHoSo);
//		pnSoLuongHoSo.add(btnSLHoSo);
		pnNorthRight.add(pnSoLuongHoSo);
		
		// PANEL SO LUONG HO SO DANG CHO MUON
		JPanel pnSoLuongHoSoDangMuon = new JPanel();
		JLabel lblSoLuongHoSoDangMuon = new JLabel("Hồ sơ đang mượn");
		txtSoLuongHoSoDangMuon = new JTextField(5);
//		btnSLHSDangMuon = new JButton("Danh sách");
		pnSoLuongHoSoDangMuon.add(lblSoLuongHoSoDangMuon);
		pnSoLuongHoSoDangMuon.add(txtSoLuongHoSoDangMuon);
//		pnSoLuongHoSoDangMuon.add(btnSLHSDangMuon);
		pnNorthRight.add(pnSoLuongHoSoDangMuon);
		
		// PANEL SO LUONG HO SO DA XONG
		JPanel pnSLHSDaXong = new JPanel();
		JLabel lblSLHSDaXong = new JLabel("Hồ sơ đã xong");
		txtSoLuongHoSoDaXong = new JTextField(5);
//		btnSLHSDaXong = new JButton("Danh sách");
		pnSLHSDaXong.add(lblSLHSDaXong);
		pnSLHSDaXong.add(txtSoLuongHoSoDaXong);
//		pnSLHSDaXong.add(btnSLHSDaXong);
		pnNorthRight.add(pnSLHSDaXong);
		
		// BTN TRANG HO SO
		JPanel pnBtnTrangHoSo = new JPanel();
		btnChiTietHoSo = new JButton("Chi tiết Trang hồ sơ");
		pnBtnTrangHoSo.add(btnChiTietHoSo);
		pnNorthRight.add(pnBtnTrangHoSo);
		
		
		// PANEL CENTER -------------------------------------------------------------
		pnCenter.setLayout(new BorderLayout());
		dtmSach = new DefaultTableModel();
		dtmSach.addColumn("Mã sách");
		dtmSach.addColumn("Tên sách");
		dtmSach.addColumn("Số trang");
		dtmSach.addColumn("Nhà xuất bản");
		dtmSach.addColumn("Thể loại");
		
		tblSach = new JTable(dtmSach);
		
		JScrollPane scTable = new JScrollPane(tblSach,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		pnCenter.add(scTable, BorderLayout.CENTER);
		
		
		// PN SOUTH
		JPanel pnBtnSouth = new JPanel();		
		btnAboutUs = new JButton("Thông tin về nhóm chúng tôi");
		pnBtnSouth.add(btnAboutUs);
		pnSouth.add(pnBtnSouth);		
		
		
		
		
		
		
				// DRAW BORDER FOR PN NORTH LEFT SITE
				TitledBorder borderOfNorthLeft = new TitledBorder(
						BorderFactory.createLineBorder(
						Color.BLUE), "THỐNG KÊ");
				pnNorthLeft.setBorder(borderOfNorthLeft);
				
				// DRAW BORDER FOR PN NORTH Right SITE
				TitledBorder borderOfNorthRight = new TitledBorder(
						BorderFactory.createLineBorder(
						Color.BLUE), "HỒ SƠ");
				pnNorthRight.setBorder(borderOfNorthRight);
				
				// DRAW BORDER FOR PN Center SITE
				TitledBorder borderOfCenter = new TitledBorder(
						BorderFactory.createLineBorder(
						Color.BLUE), "SÁCH MỚI");
				
				pnCenter.setBorder(borderOfCenter);
				
				// DRAW BORDER FOR PN South SITE
						TitledBorder borderOfSouth = new TitledBorder(
								BorderFactory.createLineBorder(
								Color.BLUE), "THÔNG TIN VỀ NHÓM CHÚNG TÔI");
						pnSouth.setBorder(borderOfSouth);
		
	}
	
	public void showWindow() 
	{
		this.setSize(700, 650);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
}
