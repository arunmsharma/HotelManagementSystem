package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckOut extends JFrame implements ActionListener {
	
	Font f = new Font("Serif",Font.BOLD,14);
	Choice c1;
	JTextField t1;
	JButton b1,b2,b3;
	public CheckOut() {
		setLayout(null);
		setBounds(500,200,850,300);
		setTitle("Check Out");
		this.getContentPane().setBackground(Color.WHITE);
		
		
		
		JLabel l1 = new JLabel("CHECK OUT");
		l1.setFont(new Font("serif",Font.BOLD,20));
		l1.setBounds(100,20,150,30);
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel l2 = new JLabel("CUSTOMER ID");
		l2.setFont(f);
		l2.setBounds(30,80,100,30);
		add(l2);
		
		c1 = new Choice();
		try {
			conn c= new conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()) {
				c1.add(rs.getString("number"));
			}
		}
		catch(Exception e) {
			
		}
		c1.setBounds(200,80,150,30);
		c1.setFont(f);
		add(c1);
		JLabel l3 = new JLabel("ROOM NUMBER");
		l3.setFont(f);
		l3.setBounds(30,140,120,30);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(200,140,150,30);
		t1.setFont(new Font("serif",Font.BOLD,20));
		add(t1);
		
		b1 = new JButton("CHECKOUT");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(30,200,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("BACK");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(170,200,120,30);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/tick.png"));
		Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		i1 = new ImageIcon(i2);
		
		b3 = new JButton(i1);
		b3.setBounds(360,82,20,20);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/sixth.jpg"));
		Image i5 = i4.getImage().getScaledInstance(400, 230, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel l4 = new JLabel(i6);
		l4.setBounds(400,20,400,220);
		add(l4);
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckOut().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			
			String id = c1.getSelectedItem();
			String room = t1.getText();
			String str = "delete from customer where number = '"+id+"'";
			String str2 = "update room set available = 'AVAILABLE' where room_number = '"+room+"'";
			
			conn c = new conn();
			try {
				c.s.executeUpdate(str);
				c.s.executeUpdate(str2);
				JOptionPane.showMessageDialog(null, "CheckOut Done");
				new Reception().setVisible(true);
				this.setVisible(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==b3) {
			conn c = new conn();
			String id = c1.getSelectedItem();
			try {
				ResultSet rs = c.s.executeQuery("select * from customer where number = '"+id+"'");
				while(rs.next()) {
					t1.setText(rs.getString("room"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
