package com.phuc.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.phuc.model.Sach;
import com.phuc.service.SachService;

public class SachUI extends JFrame 
{
	// NORTH -------------------
	JTextField txtTimSachTheoMaTheLoai, txtTimSachTheoTen, txtTimSachTheoMaNXB;
	JButton btnTimSachTheoMaTheLoai, btnTimSachTheoTen, btnTimSachTheoMaNXB;
	
	// CENTER -----------------
	DefaultTableModel dtmSach;
	JTable tblSach;
	
	// SOUTH -----------------
	JButton btnThemSach;
	
	// ARRAY LIST SACH --> TABLE
	ArrayList<Sach> arrayListSach = null;
	
	
	// CONSTRUCTOR
	public SachUI(String title)
	{
		super(title);
		addControls();
		addEvents();
		
		showAllBook();
	}

	private void showAllBook() 
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
			vector.add(sach.getMaNXB());
			vector.add(sach.getSoTrang());
			vector.add(sach.getSoLuong());
			vector.add(sach.getTheLoai());
			dtmSach.addRow(vector);
		}
	}

	private void addEvents() 
	{
		// TIM KIEM SACH
		btnTimSachTheoMaTheLoai.addActionListener(new ActionListener() 
		{
					
					@Override
					public void actionPerformed(ActionEvent e) {
						timSachTheoMaTheLoai();
					}			
		});	
		
		btnTimSachTheoTen.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timSachTheoTen();
			}			
		});	
		
		btnTimSachTheoMaNXB.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timSachTheoMaNXB();
			}			
		});	
		
		// CHI TIET SACH
		
		tblSach.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	                    	
	            String tblMaSach = tblSach.getValueAt(tblSach.getSelectedRow(), 0).toString();
	            String tblTenSach = tblSach.getValueAt(tblSach.getSelectedRow(), 1).toString();
	            String tblMaNXB = tblSach.getValueAt(tblSach.getSelectedRow(), 2).toString();
	            String tblSoTrang = tblSach.getValueAt(tblSach.getSelectedRow(), 3).toString();
	            String tblSoLuong = tblSach.getValueAt(tblSach.getSelectedRow(), 4).toString();
	            String tblMaTheLoai = tblSach.getValueAt(tblSach.getSelectedRow(), 5).toString();
	            	       
	            
	            Sach sach = new Sach();
	            sach.setMa(tblMaSach);
	            sach.setMaNXB(tblMaNXB);
	            sach.setSoLuong(Integer.parseInt(tblSoLuong));
	            sach.setSoTrang(Integer.parseInt(tblSoTrang));
	            sach.setTen(tblTenSach);
	            sach.setTheLoai(tblMaTheLoai);
	            
	            SachChiTietUI sachChiTietUI = new SachChiTietUI("CHI TIET SACH");
	            sachChiTietUI.showWindow(sach);
	            
	        }
	    });
		
		/*
		 * tblClient.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    // chuyển sang JFrame mới
                    MyJFrame myJFrame = new MyJFrame ();
                    myJFrame .setVisible(true);

                   // đóng JFrame hiện tại
                    setVisible(false);
                   
                }
            });
		 * 
		 */
		
		// THEM SACH
		
		btnThemSach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ThemSachUI themSachUI = new ThemSachUI("Thêm mới sách");
				themSachUI.showWindow();
			}
		});
		
	}
	
	protected void showDialog(String tenSach) 
	{
		// create a jframe
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        JOptionPane.showMessageDialog(frame,
                "Vừa click vào element :" + tenSach,
                "Title Example",
                JOptionPane.INFORMATION_MESSAGE);
        
        
		
	}

	private void timSachTheoMaTheLoai() 
	{		
		SachService sachService = new SachService();
		arrayListSach = sachService.getSachByMaTheLoai(txtTimSachTheoMaTheLoai.getText());
		// SHOW THE DATA INTO THE TABLE
		dtmSach.setRowCount(0);
		for(Sach sach : arrayListSach)
		{
			Vector<Object> vector = new Vector<Object>();
			vector.add(sach.getMa());
			vector.add(sach.getTen());
			vector.add(sach.getMaNXB());
			vector.add(sach.getSoTrang());
			vector.add(sach.getSoLuong());
			vector.add(sach.getTheLoai());
			dtmSach.addRow(vector);
		}		
	}

	private void timSachTheoTen()
	{
		SachService sachService = new SachService();
		arrayListSach = sachService.getTheoTen(txtTimSachTheoTen.getText());
		// SHOW THE DATA INTO THE TABLE
		dtmSach.setRowCount(0);
		for(Sach sach : arrayListSach)
		{
			Vector<Object> vector = new Vector<Object>();
			vector.add(sach.getMa());
			vector.add(sach.getTen());
			vector.add(sach.getMaNXB());
			vector.add(sach.getSoTrang());
			vector.add(sach.getSoLuong());
			vector.add(sach.getTheLoai());
			dtmSach.addRow(vector);
		}		
	}
	
	private void timSachTheoMaNXB()
	{
		SachService sachService = new SachService();
		arrayListSach = sachService.getTheoMaNXB(txtTimSachTheoMaNXB.getText());
		// SHOW THE DATA INTO THE TABLE
		dtmSach.setRowCount(0);
		for(Sach sach : arrayListSach)
		{
			Vector<Object> vector = new Vector<Object>();
			vector.add(sach.getMa());
			vector.add(sach.getTen());
			vector.add(sach.getMaNXB());
			vector.add(sach.getSoTrang());
			vector.add(sach.getSoLuong());
			vector.add(sach.getTheLoai());
			dtmSach.addRow(vector);
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
		
		JPanel pnTimTheoMaTheLoai = new JPanel();
		JLabel lblTimSachTheoMaTheLoai = new JLabel("Tìm sách theo mã thể loại");
		txtTimSachTheoMaTheLoai = new JTextField(20);
		btnTimSachTheoMaTheLoai = new JButton("Tìm");
		pnTimTheoMaTheLoai.add(lblTimSachTheoMaTheLoai);
		pnTimTheoMaTheLoai.add(txtTimSachTheoMaTheLoai);
		pnTimTheoMaTheLoai.add(btnTimSachTheoMaTheLoai);
		pnNorth.add(pnTimTheoMaTheLoai);
		
		JPanel pnTimSachTheoTen = new JPanel();
		JLabel lblTimSachTheoTen = new JLabel("Tìm sách theo tên");
		txtTimSachTheoTen = new JTextField(20);
		btnTimSachTheoTen = new JButton("Tìm");
		pnTimSachTheoTen.add(lblTimSachTheoTen);
		pnTimSachTheoTen.add(txtTimSachTheoTen);
		pnTimSachTheoTen.add(btnTimSachTheoTen);
		pnNorth.add(pnTimSachTheoTen);
		
		JPanel pnTimSachTheoMaNXB = new JPanel();
		JLabel lblTimSachTheoMaNXB = new JLabel("Tìm sách theo mã nhà xuất bản");
		txtTimSachTheoMaNXB = new JTextField(20);
		btnTimSachTheoMaNXB = new JButton("Tìm");
		pnTimSachTheoMaNXB.add(lblTimSachTheoMaNXB);
		pnTimSachTheoMaNXB.add(txtTimSachTheoMaNXB);
		pnTimSachTheoMaNXB.add(btnTimSachTheoMaNXB);
		pnNorth.add(pnTimSachTheoMaNXB);
		
		
		// THE CENTER --> TABLE ----------------------------------------------------------
		pnCenter.setLayout(new BorderLayout());
		dtmSach = new DefaultTableModel();
		dtmSach.addColumn("Mã sách");
		dtmSach.addColumn("Tên sách");
		dtmSach.addColumn("Mã NXB");
		dtmSach.addColumn("Số trang");
		dtmSach.addColumn("Số lượng");
		dtmSach.addColumn("Mã thể loại");
		tblSach = new JTable(dtmSach);
		JScrollPane scTable = new JScrollPane(tblSach,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCenter.add(scTable, BorderLayout.CENTER);
		
		
		// THE S  ---> ---------------------------------------------------------------
		btnThemSach = new JButton("Thêm sách");
		pnSouth.add(btnThemSach);
		
		
		
		// DRAW BORDER FOR PN Center SITE
		TitledBorder borderOfNorth = new TitledBorder(
				BorderFactory.createLineBorder(
				Color.BLACK), "Tìm kiếm sách");
		pnNorth.setBorder(borderOfNorth);
		
		
		// DRAW BORDER FOR PN Center SITE
		TitledBorder borderOfCenter = new TitledBorder(
				BorderFactory.createLineBorder(
				Color.BLACK), "Tất cả sách");
		pnCenter.setBorder(borderOfCenter);
		
		// DRAW BORDER FOR PN South SITE
				TitledBorder borderOfSouth = new TitledBorder(
						BorderFactory.createLineBorder(
						Color.BLACK), "Thêm mới sách");
				pnSouth.setBorder(borderOfSouth);
	}
	
	
	public void showWindow() 
	{
		this.setSize(600, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
}
