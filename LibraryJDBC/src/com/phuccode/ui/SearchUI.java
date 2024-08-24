package com.phuccode.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.phuccode.connect.SachService;
import com.phuccode.model.Sach;

public class SearchUI extends JFrame
{
	JTextField txtSearch;
	JButton btnSearch;
	
	DefaultTableModel dtmResult;
	JTable tblResult;
	
	//ARRAY LIST TO SHOW SACH
	ArrayList<Sach> arrayListSach = null;
	
	//CONSTRUCTOR
	public SearchUI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}

	private void addEvents() 
	{
		// TODO Auto-generated method stub
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				doSearch();
			}

			
		});
	}
	
	private void doSearch() 
	{
		// GET ALL SACH BY USE SACH SERVICE CLASS
		SachService sachService = new SachService();
		arrayListSach = sachService.getSachByMaNhaXuatBan(txtSearch.getText());
		
		// SHOW THE DATA INTO THE TABLE
		dtmResult.setRowCount(0);
		for(Sach sach : arrayListSach)
		{
			Vector<Object> vector = new Vector<Object>();
			vector.add(sach.getMaSach());
			vector.add(sach.getTenSach());
			vector.add(sach.getMaNhaXuatBan());
			vector.add(sach.getSoTrang());
			dtmResult.addRow(vector);
		}
		
	}

	private void addControls() 
	{
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		//NORTH
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblInput = new JLabel("Input   ");
		txtSearch = new JTextField(20);
		btnSearch = new JButton("Search");
		pnNorth.add(lblInput);
		pnNorth.add(txtSearch);
		pnNorth.add(btnSearch);
		container.add(pnNorth, BorderLayout.NORTH); // container set this to NORTH
		
		//CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout());
		dtmResult = new DefaultTableModel();
		dtmResult.addColumn("Book code");
		dtmResult.addColumn("Book name");
		dtmResult.addColumn("Number of pages");
		dtmResult.addColumn("NXB");
		tblResult = new JTable(dtmResult);
		JScrollPane scTable = new JScrollPane(tblResult,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCenter.add(scTable, BorderLayout.CENTER);
		container.add(pnCenter, BorderLayout.CENTER);
	}
	
	public void showWindow()
	{
		this.setSize(500, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
