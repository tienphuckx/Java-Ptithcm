package com.phuc.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.phuc.model.Sach;
import com.phuc.service.SachService;

public class ThemSachUI extends JFrame 
{
	
	// HOLD THE VALUE
	private String maSach;
	private String tenSach;
	private String maNXB;
	private int soLuong;
	private int soTrang;
	private String maTheThoai;
	
	
		// RADIO BTN
		JRadioButton radKimDong, radGiaoDuc, radThanhNien, radHaNoi, radHCM;
		ButtonGroup bgTheLoai;
	
		
		// CHECK BOX
		JCheckBox chkTrinhTham, chkVanHoc, chkNgonTinh, chkTieuThuyet, chkPhatPhap, chkVienTuong;
		
		// BTN
		JButton btnThem;
		
		// JTEXT FIELD
		JTextField txtMa, txtTen, txtMaNXB, txtSoLuong, txtSoTrang, txtMaTheLoai;
	
		//CONSTRUCTOR
		public ThemSachUI(String title)
		{
			super(title);
			addControls();
			addEvents();
		}

		private void addEvents() {
			btnThem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					themSach();
				}
			});
		}

		protected void themSach() 
		{
			String maSach = txtMa.getText();
			String tenSach = txtTen.getText();

			int soTrang = Integer.parseInt(txtSoTrang.getText());
			int soLuong = Integer.parseInt(txtSoLuong.getText());
			
			
			// GET NOI DUNG MA NHA XUAT BAN
			String maNXB = "";
			
			if(radGiaoDuc.isSelected())
			{
				maNXB += "giaoduc";
			}
			if(radHaNoi.isSelected())
			{
				maNXB += "hanoi";
			}
			if(radHCM.isSelected())
			{
				maNXB += "hcm";
			}
			if(radKimDong.isSelected())
			{
				maNXB += "kimdong";
			}
			if(radThanhNien.isSelected())
			{
				maNXB += "thanhnien";
			}
			
			// GET NOI DUNG MA THE LOAI 
			String maTheLoai = "";
			if(chkNgonTinh.isSelected())
			{
				maTheLoai += "ngontinh";
			}
			if(chkPhatPhap.isSelected())
			{
				maTheLoai += "phatphap";
			}
			if(chkTieuThuyet.isSelected())
			{
				maTheLoai += "tieuthuyet";
			}
			if(chkTrinhTham.isSelected())
			{
				maTheLoai += "trinhtham";
			}
			if(chkVanHoc.isSelected())
			{
				maTheLoai += "vanhoc";
			}
			if(chkVienTuong.isSelected())
			{
				maTheLoai += "vientuong";
			}
			
			
			// ĐÃ GET XONG 6 thông tin
			// LUU THONG TIN VAO BIEN SACH
			Sach sach = new Sach();
			sach.setMa(maSach);
			sach.setMaNXB(maNXB);
			sach.setSoLuong(soLuong);
			sach.setSoTrang(soTrang);
			sach.setTen(tenSach);
			sach.setTheLoai(maTheLoai);
			
			SachService sachService = new SachService();
			sachService.themSach(sach);
			
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
			
			// PN MA SACH
			JPanel pnMa = new JPanel();
			JLabel lblMa = new JLabel("Nhập mã sách");
			txtMa = new JTextField(30);
			pnMa.add(lblMa);
			pnMa.add(txtMa);
			pnNorth.add(pnMa);
			
			
			// PN TEN SACH
			JPanel pnTen = new JPanel();
			JLabel lblTen = new JLabel("Nhập tên sách");
			txtTen = new JTextField(30);
			pnTen.add(lblTen);
			pnTen.add(txtTen);
			pnNorth.add(pnTen);
			
			// PN SO TRANG
						JPanel pnSoTrang = new JPanel();
						JLabel lblSoTrang = new JLabel("Nhập số trang");
						txtSoTrang = new JTextField(30);
						pnSoTrang.add(lblSoTrang);
						pnSoTrang.add(txtSoTrang);
						pnNorth.add(pnSoTrang);
						
						// PN SO LUONG
						JPanel pnSoLuong = new JPanel();
						JLabel lblSoLuong = new JLabel("Nhập Số lượng");
						txtSoLuong = new JTextField(30);
						pnSoLuong.add(lblSoLuong);
						pnSoLuong.add(txtSoLuong);
						pnNorth.add(pnSoLuong);
				
						
			// PN MA NHA XUAT BAN --> RADIO BUTTON
						
			JPanel pnMaNSX = new JPanel();
			Border borderMaNSX = BorderFactory.createEtchedBorder(Color.BLUE,
					Color.RED);
			TitledBorder titledBorderMaNSX = new TitledBorder(borderMaNSX, "Chọn mã NSX");
			pnMaNSX.setBorder(titledBorderMaNSX);
			JLabel lblNSX = new JLabel("Nhập NSX sách");
			
			radKimDong = new JRadioButton("NXB Kim đồng");
			radGiaoDuc = new JRadioButton("NXB Giáo dục");
			radThanhNien = new JRadioButton("NXB Thanh niên");
			radHaNoi = new JRadioButton("NXB Hà nội");
			radHCM = new JRadioButton("NXB Hồ Chí Minh");
			
			radKimDong.setBounds(50, 60, 170, 30);
			radGiaoDuc.setBounds(50, 60, 170, 30);
			radThanhNien.setBounds(50, 60, 170, 30);
			radHaNoi.setBounds(50, 60, 170, 30);
			radHCM.setBounds(50, 60, 170, 30);
			
			bgTheLoai = new ButtonGroup();
			bgTheLoai.add(radKimDong);
			bgTheLoai.add(radGiaoDuc);
			bgTheLoai.add(radThanhNien);
			bgTheLoai.add(radHaNoi);
			bgTheLoai.add(radHCM);
					
			pnMaNSX.add(radKimDong);
			pnMaNSX.add(radGiaoDuc);
			pnMaNSX.add(radThanhNien);
			pnMaNSX.add(radHaNoi);
			pnMaNSX.add(radHCM);
			pnNorth.add(pnMaNSX);

			// CODE CHECK HERE
			
			// PN MA THE LOAI --> CHEC BOX
			JPanel pnMaTheLoai = new JPanel();
			pnMaTheLoai.setLayout(new GridLayout(2, 3));
			Border borderMaTheLoai = BorderFactory.createEtchedBorder(Color.BLUE,
					Color.RED);
			TitledBorder titledBorderMaTheLoai = new TitledBorder(borderMaTheLoai, "Chọn thể loại sách");
			pnMaTheLoai.setBorder(titledBorderMaTheLoai);
			
			chkTrinhTham = new JCheckBox("Trinh thám");
			chkVanHoc = new JCheckBox("Văn học");
			chkNgonTinh = new JCheckBox("Ngôn tình");
			chkTieuThuyet = new JCheckBox("Tiểu thuyết");
			chkPhatPhap = new JCheckBox("Phật pháp");
			chkVienTuong = new JCheckBox("Viễn tưởng");
			
			pnMaTheLoai.add(chkVienTuong);
			pnMaTheLoai.add(chkPhatPhap);
			pnMaTheLoai.add(chkTieuThuyet);
			pnMaTheLoai.add(chkNgonTinh);
			pnMaTheLoai.add(chkVanHoc);
			pnMaTheLoai.add(chkTrinhTham);
			
			pnNorth.add(pnMaTheLoai);
			
			if(chkTrinhTham.isSelected())
			{
				
			}
			if(chkVanHoc.isSelected())
			{
				
			}
			if(chkNgonTinh.isSelected())
			{
				
			}
			if(chkTieuThuyet.isSelected())
			{
				
			}
			if(chkPhatPhap.isSelected())
			{
				
			}
			if(chkVienTuong.isSelected())
			{
				
			}
			
			
			// CENTER
			btnThem = new JButton("Thêm sách");
			pnCenter.add(btnThem);
			
			
			// =============== BEGIN ADD BORDER
			TitledBorder north = new TitledBorder(
					BorderFactory.createLineBorder(
					Color.BLUE), "Tạo các thông tin cho sách");
			pnNorth.setBorder(north);

			TitledBorder center = new TitledBorder(
					BorderFactory.createLineBorder(
					Color.BLUE), "Thêm sách");
			pnCenter.setBorder(center);
			// =============== END ADD BORDER
		}
		public void showWindow() 
		{
			this.setSize(650, 400);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			
		}
}
