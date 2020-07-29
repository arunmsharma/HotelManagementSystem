package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
	
	JLabel l1,l2;
	JTextField tf1;
	JPasswordField t2;
	JButton b1,b2;
	public Login() {
		setLayout(null);
		
		l1 = new JLabel("Username");
		l1.setFont(new Font("serif",Font.BOLD,20));
		l1.setBounds(40,20,100,30);
		add(l1);
		
		l2 = new JLabel("Password");
		l2.setFont(new Font("serif",Font.BOLD,20));
		l2.setBounds(40,70,100,30);
		add(l2);
		
		tf1 = new JTextField();
		tf1.setBounds(150,20,150,30);
		add(tf1);
		
		t2 = new JPasswordField();
		t2.setBounds(150,70,150,30);
		
		add(t2);
		
		b1 = new JButton("Login");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(40,150,120,30);
		b1.addActionListener(this);
		
		b2 = new JButton("Cancel");
		b2.setBounds(180,150,120,30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		add(b1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel l3 = new JLabel(i3);
		
		l3.setBounds(350,10,180,200);
		add(l3);
		
		this.getContentPane().setBackground(Color.WHITE);
	
		setBounds(600,300,600,300);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
			String username=tf1.getText();
			@SuppressWarnings("deprecation")
			String password = t2.getText();
			conn c = new conn();
			
			String str = "select * from login where username = '"+username+"' and password = '"+password+"'";
			try {
				ResultSet rs = c.s.executeQuery(str);
				if(rs.next()) {
					new Dashboard().setVisible(true);
					this.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Username and Password");
					this.setVisible(false);
				}
			}
			catch(Exception e){
				
			}
		}
		else if(ae.getSource()==b2) {
			System.exit(0);
		}
		
	}

	
}
