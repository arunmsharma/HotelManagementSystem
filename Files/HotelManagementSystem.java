package hotel.management.system;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
public class HotelManagementSystem extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	HotelManagementSystem(){
		setLayout(null);
		setBounds(200,200,1366,565);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/firstImage.jpg"));
		
		JLabel l1 = new JLabel(i1);
		l1.setBounds(0,0,1366,565);
		add(l1);
		
		JLabel l2 = new JLabel("Hotel Management System");
		l2.setBounds(20,430,1000,90);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("serif",Font.PLAIN,70));
		l1.add(l2);
		
		JButton b1 = new JButton("Next");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(1150,450,110,30);
		Border noborder = new LineBorder(Color.WHITE,0);
		b1.setFont(new Font("Serif",Font.BOLD,30));
		b1.setBorder(noborder);
		b1.addActionListener(this);
		
		l1.add(b1);
		
	
		setVisible(true);
		
		while(true) {
			l2.setVisible(false);
			
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			l2.setVisible(true);
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
			
	}
	
	public static void main(String[] args) {
		new HotelManagementSystem();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new Login().setVisible(true);
		this.setVisible(false);
		
	}

}
