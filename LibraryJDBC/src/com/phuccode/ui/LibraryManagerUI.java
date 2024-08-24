package com.phuccode.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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

import com.phuccode.connect.NhaXuatBanService;
import com.phuccode.model.NhaXuatBan;

public class LibraryManagerUI extends JFrame
{
	// CENTER SITE
	DefaultTableModel dtmNXB;
	JTable tblNXB;
	
		
	// LEFT SITE
	JTextField txtMaNXB, txtTenNXB, txtDiaChiNXB, txtPhoneNXB;
	JButton btnNext, btnPrevious;
	JLabel lblStep;
	
	// RIGHT SITE
	JButton btnAdd, btnSave, btnEdit, btnDelete;
	
	// SOUTH SITE
	JButton btnSearch;
	
	// ARRAY LIST DANH SACH NHA XUAT BAN TO SHOW ON THE AIN TABLE
	ArrayList<NhaXuatBan> arrayListNhaXuatBan = null;
	
	
	//CONSTRUCTOR
	public LibraryManagerUI(String title) 
	{
		super(title);
		addControls();
		addEvents();
		
		showListNhaXuatBan();
	}

	private void showListNhaXuatBan() 
	{
		// TODO Auto-generated method stub
		NhaXuatBanService nhaXuatBanService = new NhaXuatBanService();
		arrayListNhaXuatBan = nhaXuatBanService.getAllNhaXuatBan();
		
		// SHOW DATA TO MAIN TABLE
		dtmNXB.setRowCount(0);
		for(NhaXuatBan nhaXuatBan : arrayListNhaXuatBan)
		{
			Vector<Object> vector = new Vector<Object>();
			vector.add(nhaXuatBan.getMaNhaXuatBan());
			vector.add(nhaXuatBan.getTenNhaXuatBan());
			vector.add(nhaXuatBan.getDiaChi());
			vector.add(nhaXuatBan.getDienThoai());
			dtmNXB.addRow(vector);
		}
	}

	private void addEvents() 
	{
		
		
	}

	private void addControls() 
	{
		// CHOOSE "BORDER LAYOUT" FOR CONTAINER
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		// Border Layout --> Top Mid Bot
		JPanel pnNorth = new JPanel();
		JPanel pnCenter = new JPanel();
		JPanel pnSouth = new JPanel();
		
		
		container.add(pnNorth, BorderLayout.NORTH);
		container.add(pnCenter, BorderLayout.CENTER);
		container.add(pnSouth, BorderLayout.SOUTH);
		
		
		
		// SETUP THE NORTH PART --> BorderLayout --> Center + West
		pnNorth.setLayout(new BorderLayout());
		JPanel pnNorthLeft = new JPanel(); // LEFT PANEL --> WEST
		JPanel pnNorthRight = new JPanel(); // RIGHT PANEL --> EAST
		pnNorth.add(pnNorthLeft, BorderLayout.CENTER);
		pnNorth.add(pnNorthRight, BorderLayout.EAST);
		
		// SET PN NORTH LEFT --> BOX LAYOUT --> ROW
		pnNorthLeft.setLayout(new BoxLayout(pnNorthLeft, BoxLayout.Y_AXIS));
		
		// Panel title
		JPanel pnNXB = new JPanel();
		JLabel lblNXB = new JLabel("PUBLISHER");
		lblNXB.setForeground(Color.BLUE);
		Font fPublisher = new Font("arial", Font.BOLD, 18);
		lblNXB.setFont(fPublisher);
		pnNXB.add(lblNXB);
		pnNorthLeft.add(pnNXB);
		
		//Panel Ma NXB
		JPanel pnMaNXB = new JPanel();
		JLabel lblMaNXB = new JLabel("Publisher Code");
		txtMaNXB = new JTextField(25);
		pnMaNXB.add(lblMaNXB);
		pnMaNXB.add(txtMaNXB);
		pnNorthLeft.add(pnMaNXB);
		
		//Panel Ten NXB
		JPanel pnTenNXB = new JPanel();
		JLabel lblTenNXB = new JLabel("Publisher Name");
		txtTenNXB = new JTextField(25);
		pnTenNXB.add(lblTenNXB);
		pnTenNXB.add(txtTenNXB);
		pnNorthLeft.add(pnTenNXB);
		
		//Panel Dia Chi NXB
		JPanel pnDiaChiNXB = new JPanel();
		JLabel lblDiaChiNXB = new JLabel("Publisher Address");
		txtDiaChiNXB = new JTextField(25);
		pnDiaChiNXB.add(lblDiaChiNXB);
		pnDiaChiNXB.add(txtDiaChiNXB);
		pnNorthLeft.add(pnDiaChiNXB);
		
		//Panel SDT NXB
		JPanel pnPhoneNXB = new JPanel();
		JLabel lblPhoneNXB = new JLabel("Publisher Phone        ");
		txtPhoneNXB = new JTextField(25);
		pnPhoneNXB.add(lblPhoneNXB);
		pnPhoneNXB.add(txtPhoneNXB);
		pnNorthLeft.add(pnPhoneNXB);
		
		// BTN
		JPanel pnBtn = new JPanel();
		btnPrevious = new JButton("Previous");
		btnNext = new JButton("Next");
		lblStep = new JLabel("1/10");
		pnBtn.add(btnPrevious);
		pnBtn.add(lblStep);
		pnBtn.add(btnNext);
		pnNorthLeft.add(pnBtn);
		
		
		// PN NORTH RIGHT
		pnNorthRight.setLayout(new BoxLayout(pnNorthRight,
				BoxLayout.Y_AXIS));
		
		
		JPanel pnBtnAdd = new JPanel();
		btnAdd = new JButton();
		pnBtnAdd.add(btnAdd);
		pnNorthRight.add(pnBtnAdd);
		
		JPanel pnBtnSave = new JPanel();
		btnSave = new JButton();
		pnBtnSave.add(btnSave);
		pnNorthRight.add(pnBtnSave);
		
		JPanel pnBtnEdit = new JPanel();
		btnEdit = new JButton();
		pnBtnEdit.add(btnEdit);
		pnNorthRight.add(pnBtnEdit);
		
		JPanel pnBtnDelete = new JPanel();
		btnDelete = new JButton();
		pnBtnDelete.add(btnDelete);
		pnNorthRight.add(pnBtnDelete);
		
		
		// PN CENTER
		pnCenter.setLayout(new BorderLayout());
		dtmNXB = new DefaultTableModel();
		dtmNXB.addColumn("NXB Code");
		dtmNXB.addColumn("NXB Name");
		dtmNXB.addColumn("NXB Address");
		dtmNXB.addColumn("NXB Phone");
		tblNXB = new JTable(dtmNXB);
		JScrollPane scTable = new JScrollPane(tblNXB,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCenter.add(scTable, BorderLayout.CENTER);
		
		
		// PN SOUTH
		JPanel pnBtnSouth = new JPanel();		
		btnSearch = new JButton("Search");
		pnBtnSouth.add(btnSearch);
		pnSouth.add(pnBtnSouth);
		
		
		// DRAW BORDER FOR PN NORTH LEFT SITE
		TitledBorder borderOfNorthLeft = new TitledBorder(
				BorderFactory.createLineBorder(
				Color.BLUE), "Publisher Detail");
		pnNorthLeft.setBorder(borderOfNorthLeft);
		
		// DRAW BORDER FOR PN NORTH Right SITE
		TitledBorder borderOfNorthRight = new TitledBorder(
				BorderFactory.createLineBorder(
				Color.BLUE), "Action");
		pnNorthRight.setBorder(borderOfNorthRight);
		
		// DRAW BORDER FOR PN Center SITE
		TitledBorder borderOfCenter = new TitledBorder(
				BorderFactory.createLineBorder(
				Color.BLUE), "NXB Table");
		pnCenter.setBorder(borderOfCenter);
		
		// DRAW BORDER FOR PN South SITE
				TitledBorder borderOfSouth = new TitledBorder(
						BorderFactory.createLineBorder(
						Color.BLUE), "Search");
				pnSouth.setBorder(borderOfSouth);	
				
		// SET ALL IN PUT == Phone ON PN NORTH LEFT
		lblMaNXB.setPreferredSize(lblPhoneNXB.getPreferredSize());
		lblTenNXB.setPreferredSize(lblPhoneNXB.getPreferredSize());
		lblDiaChiNXB.setPreferredSize(lblPhoneNXB.getPreferredSize());
		
		
		// SET IMAGE FOR ICON
		btnAdd.setIcon(new ImageIcon("Images/add.png"));
		btnDelete.setIcon(new ImageIcon("Images/delete.png"));
		btnEdit.setIcon(new ImageIcon("Images/edit.png"));
		btnSave.setIcon(new ImageIcon("Images/save.png"));
		
		btnNext.setIcon(new ImageIcon("Images/next.png"));
		btnPrevious.setIcon(new ImageIcon("Images/previous.png"));
		btnSearch.setIcon(new ImageIcon("Images/search.png"));
	}
	
	public void showWindow() 
	{
		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
}
