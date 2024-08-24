package phucwork.ui;

import java.awt.Button;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxLayoutUI extends JFrame
{
	public BoxLayoutUI( String tieude) 
	{
		super(tieude);
		addControls();
		
	}
	
	private void addControls() 
	{
		Container con = getContentPane();
		
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));
		
		Button btn1 = new Button("BTN 1");
		Button btn2 = new Button("BTN 1");
		Button btn3 = new Button("BTN 1");
		
		pnBox.add(btn1);
		pnBox.add(btn2);
		pnBox.add(btn3);
		
		con.add(pnBox);
	}

	public void showWindow()
	{
		this.setSize(600, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
