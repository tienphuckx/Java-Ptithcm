package phucwork.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.*;

public class PhuongTrinhBacMotUI extends JFrame
{
	
	JTextField txtA;
	JTextField txtB;
	JTextField txtKQ;
	JButton btnCong;
	JButton btnTru;
	JButton btnNhan;
	JButton btnChia;
	
	
	public PhuongTrinhBacMotUI(String title)
	{
		super(title);
		addControls();
	}
	
	private void addControls() 
	{
		Container con = getContentPane();
		
		JPanel pnMain = new JPanel();
		
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS) );
		
		con.add(pnMain);
		
		// ROW 1 --> TITLE
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		
		JLabel lblTieuDe = new JLabel();
		lblTieuDe.setText("GIAI PHUONG TRINH BAC 1");
		lblTieuDe.setForeground(Color.red);
		Font fontTieuDe = new Font("arial", Font.BOLD, 15);
		lblTieuDe.setFont(fontTieuDe);
		
		pnTitle.add(lblTieuDe);
		
		pnMain.add(pnTitle);
		
		//ROW 2 --> HE SO A
		JPanel pnA = new JPanel();
		pnA.setLayout(new FlowLayout());
		JLabel lblA = new JLabel("Hệ số A");
		txtA = new JTextField(15);
		pnA.add(lblA);
		pnA.add(txtA);
		pnMain.add(pnA);
		
		//ROW 3 --> HE SO B
		JPanel pnB = new JPanel();
		pnB.setLayout(new FlowLayout());
		
		JLabel lblB = new JLabel("Hệ số B");
		txtB = new JTextField(15);
		
		pnB.add(lblB);
		pnB.add(txtB);
		
		pnMain.add(pnB);
		
		//ROW 4 --> BUTTON + - * /
		JPanel pnBtn = new JPanel();
		pnBtn.setLayout(new FlowLayout());
		
		btnCong = new JButton("Cộng");
		btnTru = new JButton("Trừ");
		btnNhan = new JButton("Nhân");
		btnChia = new JButton("Chia");
		
		pnBtn.add(btnCong);
		pnBtn.add(btnTru);
		pnBtn.add(btnNhan);
		pnBtn.add(btnChia);
		
		pnMain.add(pnBtn);
		
		//ROW 5 --> SHOW KET QUA
		JPanel pnKQ = new JPanel();
		pnKQ.setLayout(new FlowLayout());
		
		JLabel lblKQ = new JLabel("Kết quả");
		txtKQ = new JTextField(20);
		
		pnKQ.add(lblKQ);
		pnKQ.add(txtKQ);
		
		pnMain.add(pnKQ);
	}

	
	public void showWindow()
	{
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // exit
		this.setLocationRelativeTo(null); // can giua
		this.setResizable(false);
		this.setBackground(Color.BLACK);
		this.setVisible(true);
	}

}
