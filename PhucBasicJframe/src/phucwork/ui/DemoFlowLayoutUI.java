package phucwork.ui;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoFlowLayoutUI extends JFrame
{
	public DemoFlowLayoutUI( String tieude) 
	{
		super(tieude);
		addControls();
		
	}
	
	public void addControls()
	{
		Container con = getContentPane();
		
		JPanel pnFlowLayout = new JPanel();
		pnFlowLayout.setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("BUTTON 1");
		JButton btn2 = new JButton("BUTTON 1");
		JButton btn3 = new JButton("BUTTON 1");
		JButton btn4 = new JButton("BUTTON 1");
		
		pnFlowLayout.add(btn1);
		pnFlowLayout.add(btn2);
		pnFlowLayout.add(btn3);
		pnFlowLayout.add(btn4);
		
		con.add(pnFlowLayout);
	}
	
	public void showWindow()
	{
		this.setSize(600, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
