package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UpdateRoom extends JFrame implements ActionListener {
	Choice c1;
	JTextField t1,t2,t3;
	
	JButton b1,b2,b3;
	
	UpdateRoom(){
		setLayout(null);
		setBounds(550,200,1000,450);
		this.setTitle("Update Room Status");
		this.getContentPane().setBackground(Color.WHITE);
		
		JLabel l1 = new JLabel("UPDATE ROOM STATUS");
		l1.setFont(new Font("Serif",Font.BOLD,21));
		l1.setBounds(20,20,250,50);
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel l2 = new JLabel("GUEST ID");
		l2.setFont(new Font("Serif",Font.BOLD,18));
		l2.setBounds(30,80,120,20);
		add(l2);
		
		c1 = new Choice();
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()) {
				c1.add(rs.getString("number"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		c1.setBounds(200,80,150,35);
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Serif",Font.BOLD,14));
		add(c1);
		
		JLabel l3 = new JLabel("ROOM NUMBER");
		l3.setFont(new Font("Serif",Font.BOLD,16));
		l3.setBounds(30,120,140,20);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(200,120,150,25);
		t1.setFont(new Font("Serif",Font.BOLD,16));
		add(t1);
		
		JLabel l4 = new JLabel("AVAILABLITY");
		l4.setFont(new Font("Serif",Font.BOLD,16));
		l4.setBounds(30,160,120,20);
		add(l4);
		
		t2 = new JTextField();
		t2.setBounds(200,160,150,25);
		t2.setFont(new Font("Serif",Font.BOLD,16));
		add(t2);
		
		JLabel l5 = new JLabel("CLEAN STATUS");
		l5.setFont(new Font("Serif",Font.BOLD,16));
		l5.setBounds(30,200,120,20);
		add(l5);
		
		t3 = new JTextField();
		t3.setBounds(200,200,150,25);
		t3.setFont(new Font("Serif",Font.BOLD,16));
		add(t3);
		
		
		b1 = new JButton("CHECK");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(130,300,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("BACK");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(40,350,120,30);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("UPDATE");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(220,350,120,30);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/seventh.jpg"));
		Image i2 = i1.getImage().getScaledInstance(550, 430, Image.SCALE_DEFAULT);
		i1 = new ImageIcon(i2);
		JLabel l6 = new JLabel(i1);
		l6.setBounds(400,20,550,350);
		add(l6);
		
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UpdateRoom().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
			String r1=null;
			String s1 = c1.getSelectedItem();
			conn c = new conn();
			try {
				ResultSet rs = c.s.executeQuery("select *from customer where number = '"+s1+"'");
				while(rs.next()) {
					t1.setText(rs.getString("room"));
					r1 = rs.getString("room");
				}
				ResultSet rs2 = c.s.executeQuery("select *from room where room_number = '"+r1+"'");
				while(rs2.next()) {
					t2.setText(rs2.getString("available"));
					t3.setText(rs2.getString("status"));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(ae.getSource()==b3) {
			try {
				conn c = new conn();
				String room = t1.getText();
				String available = t2.getText();
				String status = t3.getText();
				
				String str = "update room set available = '"+available+"',status = '"+status+"'where room_number = '"+room+"'";
				try {
					c.s.executeUpdate(str);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Room Updated Successfuly");
				new Reception().setVisible(true);
				this.setVisible(false);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}

}
