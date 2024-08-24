package phucwork.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhucWindow extends JFrame {
	
	// SET TIEU DE CHO WINDOW
	public PhucWindow(String tieude)
	{
		super(tieude);
		addControls();
	}
	
	// FUNCTION CALL AND SHOW THE WINDOW
	public void showWindow()
	{
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // exit
		this.setLocationRelativeTo(null); // can giua
		this.setResizable(false);
		this.setVisible(true);
	}
	
	// ADDCONTROLS LEN WINDOW
	public void addControls()
	{
		Container con = getContentPane();
		
		
		JPanel pn = new JPanel();
		pn.setLayout(new FlowLayout());
		pn.setBackground(Color.blue);
		
		JButton btn1 = new JButton("Đăng nhập");
		JButton btn2 = new JButton("Đăng nhập");
		JButton btn3 = new JButton("Đăng nhập");
		JButton btn4 = new JButton("Đăng nhập");
		JButton btn5 = new JButton("Đăng nhập");
		
		
		pn.add(btn1);
		pn.add(btn2);
		pn.add(btn3);
		pn.add(btn4);
		pn.add(btn5);
		
		
		con.add(pn);
		
	}

}
