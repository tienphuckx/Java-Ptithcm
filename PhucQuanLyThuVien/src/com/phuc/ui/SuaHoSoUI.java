package com.phuc.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

import com.phuc.service.HoSoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class SuaHoSoUI extends JFrame 
{

	
		// BTN
		JButton btnThem;
		
		// JTEXT FIELD
		JTextField txtMatv, txtMaSach, txtMaNXB, txtMaTheLoai;
		JDateChooser Ngaymuonsach;
		JLabel lblMatv_empty, lblMaSach_empty, lblDate_empty;
		String iMaThanhvien, iMaSach;
		Date iNgaymuon;
		int iTinhtrang;
	
		//CONSTRUCTOR
		public SuaHoSoUI(String title, String _MaThanhvien, String _iMaSach, Date _Ngaymuon, int _Tinhtrang)
		{		
			super(title);
			iMaThanhvien = _MaThanhvien;
			iMaSach = _iMaSach;
			iNgaymuon = _Ngaymuon;
			iTinhtrang = _Tinhtrang;
			setSize(new Dimension(600, 210));
			setResizable(false);
			addControls();
			addEvents();
		}

		
		
		private void btnThem_ActionPerformed(ActionEvent e)
		{
			 boolean flag = true;     
		        if(txtMatv.getText().isEmpty())
		        {
		        	lblMatv_empty.setVisible(true);
		            flag = false;
		        }
		        if(txtMaSach.getText().isEmpty())
		        {
		        	lblMaSach_empty.setVisible(true);
		            flag = false;
		        }
		        if(Ngaymuonsach.getDate() == null)
		        {
		        	lblDate_empty.setVisible(true);
		            flag = false;
		        }		        
		        if(flag)
		        {
		            try {
		                String Matv = txtMatv.getText();
		                String MaSach = txtMaSach.getText();
		                Date ngaynhansachA = Ngaymuonsach.getDate();
	
		                java.sql.Date ngaynhansachA_sqlStartDate = new java.sql.Date(ngaynhansachA.getTime());
		                HoSoService hssv = new HoSoService();
		                int check = hssv.Checkexist(Matv,MaSach);
		                if(check != 1)
		                	hssv.svThemHoSo(Matv, MaSach, ngaynhansachA_sqlStartDate, 1);
		                else if(check == 1)
		                    JOptionPane.showMessageDialog(null, "Đã tồn tại!", "Thông Báo",1);
		                
		            } catch (Exception ex) {
		                System.out.println("Da xay ra loi!"+ex);
		            }
		        }
		}	
		
		private void addEvents() {

			btnThem.addActionListener(new ActionListener() 
			{
						
						@Override
						public void actionPerformed(ActionEvent e) {
							btnThem_ActionPerformed(e);
						}			
			});	
			
			txtMatv.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					lblMatv_empty.setVisible(false);
				}
			});
			txtMaSach.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					lblMaSach_empty.setVisible(false);
				}
			});
			Ngaymuonsach.getCalendarButton().addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					lblDate_empty.setVisible(false);
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
						
									
						container.add(pnNorth, BorderLayout.NORTH);
						container.add(pnCenter, BorderLayout.CENTER);
						
						// NORTH
						pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));
						
						// PN MA THANH VIEN
						JPanel pnMatv = new JPanel();
						FlowLayout fl_pnMatv = (FlowLayout) pnMatv.getLayout();
						fl_pnMatv.setAlignment(FlowLayout.LEFT);
						JLabel lblMatv = new JLabel("Nhập mã thành viên");
						txtMatv = new JTextField(30);
						
						pnMatv.add(lblMatv);
						pnMatv.add(txtMatv);
						pnNorth.add(pnMatv);
						txtMatv.setText(iMaThanhvien);
						
						lblMatv_empty = new JLabel("Không được bỏ trống");
						lblMatv_empty.setForeground(Color.RED);
						lblMatv_empty.setVisible(false);
						pnMatv.add(lblMatv_empty);
						
						
						// PN MA SACH
						JPanel pnMaSach = new JPanel();
						FlowLayout fl_pnMaSach = (FlowLayout) pnMaSach.getLayout();
						fl_pnMaSach.setAlignment(FlowLayout.LEFT);
						JLabel lblMaSach = new JLabel("Nhập mã sách");
						txtMaSach = new JTextField(30);
						pnMaSach.add(lblMaSach);
						pnMaSach.add(txtMaSach);
						pnNorth.add(pnMaSach);
						txtMaSach.setText(iMaSach);
						
						lblMaSach_empty = new JLabel("Không được bỏ trống");
						lblMaSach_empty.setVisible(false);
						lblMaSach_empty.setForeground(Color.RED);
						pnMaSach.add(lblMaSach_empty);
						
					
						
						
						
						// CENTER
						btnThem = new JButton("Thêm hồ sơ");
						
						pnCenter.add(btnThem);
						
						
						// =============== BEGIN ADD BORDER
						TitledBorder north = new TitledBorder(
								BorderFactory.createLineBorder(
								Color.BLUE), "Tạo các thông tin cho hồ sơ");
						pnNorth.setBorder(north);
						
						JPanel pnDate = new JPanel();
						FlowLayout fl_pnDate = (FlowLayout) pnDate.getLayout();
						fl_pnDate.setAlignment(FlowLayout.LEFT);
						pnNorth.add(pnDate);
						
						JLabel lblNgaymuon = new JLabel("Ngày mượn sách");
						pnDate.add(lblNgaymuon);
						
						Ngaymuonsach = new JDateChooser();						
						pnDate.add(Ngaymuonsach);
						Ngaymuonsach.setDate(iNgaymuon);
						
						
						lblDate_empty = new JLabel("Không được bỏ trống");
						lblDate_empty.setVisible(false);
						lblDate_empty.setForeground(Color.RED);
						pnDate.add(lblDate_empty);
						
						JLabel lblTinhTrang = new JLabel("Tình trạng");				
						pnDate.add(lblTinhTrang);

						JComboBox comboBox = new JComboBox();
						comboBox.setModel(new DefaultComboBoxModel(new String[] {"Đang mượn", "Đã trả"}));
						comboBox.setSelectedIndex(-1);
						if(iTinhtrang == 1)
							comboBox.setSelectedIndex(0);
						else if(iTinhtrang == 0)
							comboBox.setSelectedIndex(1);
						pnDate.add(comboBox);

						TitledBorder center = new TitledBorder(
								BorderFactory.createLineBorder(
								Color.BLUE), "Thêm hồ sơ");
						pnCenter.setBorder(center);
						// =============== END ADD BORDER
			
		}
		public void showWindow() 
		{;
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			
		}
}
