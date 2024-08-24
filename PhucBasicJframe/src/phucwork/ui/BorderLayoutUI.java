package phucwork.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutUI extends JFrame
{
	
		public BorderLayoutUI(String tieude)
		{
			super(tieude);
			addControls();
		}
		
		private void addControls() 
		{
			Container con = getContentPane();
			
			JPanel pnBorderLayout = new JPanel();
			pnBorderLayout.setLayout(new BorderLayout());
			
			JPanel pnNorth = new JPanel();
			pnNorth.setBackground(Color.BLUE);
			pnNorth.setPreferredSize(new Dimension(0, 100));
			pnBorderLayout.add(pnNorth, BorderLayout.NORTH);
			
			
			JPanel pnSouth = new JPanel();
			pnSouth.setBackground(Color.RED);
			pnSouth.setPreferredSize(new Dimension(0, 100));
			pnBorderLayout.add(pnSouth, BorderLayout.SOUTH);
			
			JPanel pnWest = new JPanel();
			pnWest.setBackground(Color.PINK);
			pnWest.setPreferredSize(new Dimension(50, 0));
			pnBorderLayout.add(pnWest, BorderLayout.WEST);
			
			JPanel pnEast = new JPanel();
			pnEast.setBackground(Color.BLACK);
			pnEast.setPreferredSize(new Dimension(50, 0));
			pnBorderLayout.add(pnEast, BorderLayout.EAST);
			
			JPanel pnCenter = new JPanel();
			pnCenter.setBackground(Color.YELLOW);
			pnBorderLayout.add(pnCenter, BorderLayout.CENTER);
			
			con.add(pnBorderLayout);
			
		}

		public void showWindow()
		{
			this.setSize(500, 400);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE); // exit
			this.setLocationRelativeTo(null); // can giua
			this.setResizable(false);
			this.setVisible(true);
		}

}
