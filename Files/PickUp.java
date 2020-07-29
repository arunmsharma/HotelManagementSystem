package hotel.management.system;
import java.awt.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.ResultSet;
public class PickUp extends JFrame implements ActionListener{

	Choice c1;
	JButton b1,b2;
	
	JTable t1;
	public PickUp() {
		setLayout(null);
		setBounds(500,200,1000,650);
		this.getContentPane().setBackground(Color.WHITE);
		this.setTitle("Search Room");
		
		JLabel l1 = new JLabel("PICK-UP SERVICE");
		l1.setFont(new Font("Serif",Font.BOLD,20));
		l1.setForeground(Color.BLUE);
		l1.setBounds(400,30,200,20);
		add(l1);
		
		
		JLabel l2 = new JLabel("TYPE OF CAR");
		l2.setBounds(50,100,150,20);
		l2.setFont(new Font("Serif",Font.BOLD,16));
		add(l2);
		
		
		c1 = new Choice();
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from driver");
			while(rs.next()) {
				c1.add(rs.getString("brand"));
			}
		}
		catch(Exception e){
			
		}
		
		c1.setBounds(200,100,200,25);
		c1.setFont(new Font("Serif",Font.BOLD,16));
		add(c1);
		
		
	
		
		

		JLabel l3 = new JLabel("NAME");
		l3.setBounds(40,160,200,20);
		l3.setFont(new Font("Serif",Font.BOLD,16));
		add(l3);
		

		JLabel l4 = new JLabel("AGE");
		l4.setBounds(180,160,200,20);
		l4.setFont(new Font("Serif",Font.BOLD,16));
		add(l4);
		

		JLabel l5 = new JLabel("GENDER");
		l5.setBounds(320,160,200,20);
		l5.setFont(new Font("Serif",Font.BOLD,16));
		add(l5);
		

		JLabel l6 = new JLabel("COMPANY");
		l6.setBounds(460,160,200,20);
		l6.setFont(new Font("Serif",Font.BOLD,16));
		add(l6);
		

		JLabel l7 = new JLabel("BRAND");
		l7.setBounds(610,160,200,20);
		l7.setFont(new Font("Serif",Font.BOLD,16));
		add(l7);
		
		JLabel l8 = new JLabel("AVAILABLITY");
		l8.setBounds(740,160,200,20);
		l8.setFont(new Font("Serif",Font.BOLD,16));
		add(l8);
		
		JLabel l9 = new JLabel("LOCATION");
		l9.setBounds(890,160,200,20);
		l9.setFont(new Font("Serif",Font.BOLD,16));
		add(l9);
		
		
		t1 = new JTable();
		t1.setBounds(0,220,1000,250);
		t1.setFont(new Font("Serif",Font.BOLD,14));
		add(t1);
		
		b1 = new JButton("SUBMIT");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(350,520,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("BACK");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(550,520,120,30);
		b2.addActionListener(this);
		add(b2);
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PickUp().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				String str = "select * from driver where brand = '"+c1.getSelectedItem()+"'";
				conn c= new conn();
				
				ResultSet rs = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
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
