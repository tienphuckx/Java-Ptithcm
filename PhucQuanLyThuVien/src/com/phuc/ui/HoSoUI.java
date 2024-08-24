package com.phuc.ui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.phuc.model.HoSo;
import com.phuc.service.HoSoService;
import com.phuc.service.SachService;
import javax.swing.SwingConstants;

public class HoSoUI extends JFrame 
{
	// NORTH -------------------
	JTextField txtTimHoSoTheoMaThanhVien, txtTimHoSoTheoMaSach;
	JButton btnTimHoSoTheoMaThanhVien, btnTimHoSoTheoMaSach;
	
	// CENTER -----------------
	DefaultTableModel dtmHoSo;
	JTable tblHoSo;
	
	// SOUTH -----------------
	JButton btnThemHoSo, btnSuaHoSo, btnXemChiTiet, btnXoa ;
	
	// ARRAY LIST SACH --> TABLE
	ArrayList<HoSo> arrayListHoSo = null;
	
	
	// CONSTRUCTOR
	public HoSoUI(String title)
	{
		super(title);
		addControls();
		addEvents();
		
		showAllHoso();
		
		
	}

	private void showAllHoso() 
	{
		HoSoService hssv = new HoSoService();
		arrayListHoSo = hssv.getTatCaHoso();
		
		// SHOW DATA TO MAIN TABLE
		dtmHoSo.setRowCount(0);
		for(HoSo hs : arrayListHoSo)
		{
			Vector<Object> vector = new Vector<Object>();
			vector.add(hs.getMaThanhVien());
			vector.add(hs.getMaSach());
			vector.add(hs.getNgayMuon());
			vector.add((hs.getTinhTrang() == 1 ? "Đang mượn" : "Đã trả"));

			dtmHoSo.addRow(vector);
		}
	}
	
	private void suaHoSo() 
	{
		int row = tblHoSo.getSelectedRow();
		String _MaThanVien = tblHoSo.getModel().getValueAt(row, 0).toString();
		String _MaSach = tblHoSo.getModel().getValueAt(row, 1).toString();
		String _Ngaymuon = tblHoSo.getModel().getValueAt(row, 2).toString();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		Date startDate = null;
		try {
		    startDate = df.parse(_Ngaymuon);
		} catch (ParseException e) {
		    System.out.print("Xảy ra lỗi trong quá trình xử lý ngày tháng!");
		}
		String _TinhTrang = tblHoSo.getModel().getValueAt(row, 0).toString();
		int _tt = ((_TinhTrang).equals("Đang mượn") ? 1 : 0);
		SuaHoSoUI suahs = new SuaHoSoUI("Sửa hồ sơ", _MaThanVien, _MaSach, startDate, _tt);
		suahs.showWindow();
		showAllHoso();
	}
	
	private void xoaHoSo() 
	{
		int row = tblHoSo.getSelectedRow();
		String _MaThanVien = tblHoSo.getModel().getValueAt(row, 0).toString();
		String _MaSach = tblHoSo.getModel().getValueAt(row, 1).toString();
		DefaultTableModel model = (DefaultTableModel) tblHoSo.getModel();
		   int[] rows = tblHoSo.getSelectedRows();
		   for(int i=0;i<rows.length;i++){
		     model.removeRow(rows[i]-i);
		   }
		HoSoService hssv = new HoSoService();
		int check = hssv.Checkexist(_MaThanVien,_MaSach);
        if(check != 1)
        	JOptionPane.showMessageDialog(null, "Không tồn tại!", "Thông Báo",1);
        else if(check == 1)
        	hssv.xoaHoSo(_MaThanVien, _MaSach);
	}
	
	

	private void addEvents() 
	{
		// TIM KIEM SACH
		btnTimHoSoTheoMaThanhVien.addActionListener(new ActionListener() 
		{
					
					@Override
					public void actionPerformed(ActionEvent e) {																								
						timHoSoTheoMaThanhvien();
					}			
		});	
		
		btnTimHoSoTheoMaSach.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timHosotheoMaSach();
			}			
		});
		
		// CHI TIET SACH
		
		// THEM SACH
		
		btnThemHoSo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ThemHoSoUI themhsUI = new ThemHoSoUI("Thêm mới hồ sơ");
				themhsUI.showWindow();
			}
		});

		btnSuaHoSo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				suaHoSo();
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaHoSo();
			}
		});
		
		btnXemChiTiet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}
	
	private void timHoSoTheoMaThanhvien() 
	{		
		HoSoService hssv = new HoSoService();
		arrayListHoSo = hssv.getHosoByMaThanhvien(txtTimHoSoTheoMaThanhVien.getText());
		// SHOW THE DATA INTO THE TABLE
		dtmHoSo.setRowCount(0);
		for(HoSo hs : arrayListHoSo)
		{
			Vector<Object> vector = new Vector<Object>();
			vector.add(hs.getMaThanhVien());
			vector.add(hs.getMaSach());
			vector.add(hs.getNgayMuon());
			vector.add((hs.getTinhTrang() == 1 ? "Đang mượn" : "Đã trả"));

			dtmHoSo.addRow(vector);
		}
	}

	private void timHosotheoMaSach()
	{

		HoSoService hssv = new HoSoService();
		arrayListHoSo = hssv.getHosoByMaSach(txtTimHoSoTheoMaSach.getText());
		// SHOW THE DATA INTO THE TABLE
		dtmHoSo.setRowCount(0);
		for(HoSo hs : arrayListHoSo)
		{
			Vector<Object> vector = new Vector<Object>();
			vector.add(hs.getMaThanhVien());
			vector.add(hs.getMaSach());
			vector.add(hs.getNgayMuon());
			vector.add((hs.getTinhTrang() == 1 ? "Đang mượn" : "Đã trả"));

			dtmHoSo.addRow(vector);
		}
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
				
		
		// THE NORTH  --> SEARCH ---------------------------------------------------------
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));
		
		JPanel pnTimTheoMaThanhVien = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnTimTheoMaThanhVien.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		JLabel lblTimHoSoTheoMaThanhVien = new JLabel("T\u00ECm h\u1ED3 s\u01A1 theo m\u00E3 th\u00E0nh vi\u00EAn");
		txtTimHoSoTheoMaThanhVien = new JTextField(20);
		btnTimHoSoTheoMaThanhVien = new JButton("Tìm");
		pnTimTheoMaThanhVien.add(lblTimHoSoTheoMaThanhVien);
		pnTimTheoMaThanhVien.add(txtTimHoSoTheoMaThanhVien);
		pnTimTheoMaThanhVien.add(btnTimHoSoTheoMaThanhVien);
		pnNorth.add(pnTimTheoMaThanhVien);
		
		JPanel pnTimTheoMaSach = new JPanel();
		FlowLayout fl_pnTimTheoMaSach = (FlowLayout) pnTimTheoMaSach.getLayout();
		fl_pnTimTheoMaSach.setAlignment(FlowLayout.LEFT);
		JLabel lblTimHoSoTheoMaSach = new JLabel("T\u00ECm h\u1ED3 s\u01A1 theo m\u00E3 s\u00E1ch");
		txtTimHoSoTheoMaSach = new JTextField(20);
		btnTimHoSoTheoMaSach = new JButton("Tìm");
		pnTimTheoMaSach.add(lblTimHoSoTheoMaSach);
		pnTimTheoMaSach.add(txtTimHoSoTheoMaSach);
		pnTimTheoMaSach.add(btnTimHoSoTheoMaSach);
		pnNorth.add(pnTimTheoMaSach);
		
		
		// THE CENTER --> TABLE ----------------------------------------------------------
		pnCenter.setLayout(new BorderLayout());
		dtmHoSo = new DefaultTableModel();
		dtmHoSo.addColumn("Mã thành viên");
		dtmHoSo.addColumn("Mã sách");
		dtmHoSo.addColumn("Ngày mượn");
		dtmHoSo.addColumn("Tình trạng");;
		tblHoSo = new JTable(dtmHoSo);
		JScrollPane scTable = new JScrollPane(tblHoSo,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCenter.add(scTable, BorderLayout.CENTER);
		
		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnSouth.add(btnXemChiTiet);
		
		
		
		// THE S  ---> ---------------------------------------------------------------
		btnThemHoSo = new JButton("Thêm hồ sơ");
		pnSouth.add(btnThemHoSo);
		
		
		
		// DRAW BORDER FOR PN Center SITE
		TitledBorder borderOfNorth = new TitledBorder(
				BorderFactory.createLineBorder(
				Color.BLACK), "Tìm kiếm hồ sơ");
		pnNorth.setBorder(borderOfNorth);
		
		
		// DRAW BORDER FOR PN Center SITE
		TitledBorder borderOfCenter = new TitledBorder(
				BorderFactory.createLineBorder(
				Color.BLACK), "Tất cả hồ sơ");
		pnCenter.setBorder(borderOfCenter);
		
		// DRAW BORDER FOR PN South SITE
				TitledBorder borderOfSouth = new TitledBorder(
						BorderFactory.createLineBorder(
						Color.BLACK), "Thêm mới hồ sơ");
				pnSouth.setBorder(borderOfSouth);
				
				btnSuaHoSo = new JButton("Sửa hồ sơ");
				btnSuaHoSo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				pnSouth.add(btnSuaHoSo);
				
				btnXoa = new JButton("Xóa hồ sơ");
				btnXoa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				pnSouth.add(btnXoa);
	}
	
	
	public void showWindow() 
	{
		this.setSize(600, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
}


