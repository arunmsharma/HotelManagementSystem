package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
	
	JTable t1;
	JButton b1,b2;
	Font f = new Font("Serif",Font.BOLD,18);
	public CustomerInfo() {
		setLayout(null);
		setBounds(450,200,1100,650);
		this.getContentPane().setBackground(Color.WHITE);
		this.setTitle("Customer Info");
		
		t1 = new JTable();
		t1.setBounds(0,40,1100,500);
		t1.setFont(f);
		add(t1);
		
		JLabel l1 = new JLabel("DOC TYPE");
		l1.setBounds(10,10,100,20);
		l1.setFont(f);
		add(l1);
		
		JLabel l2 = new JLabel("NUMBER");
		l2.setBounds(170,10,100,20);
		l2.setFont(f);
		add(l2);
		
		JLabel l3 = new JLabel("NAME");
		l3.setBounds(310,10,100,20);
		l3.setFont(f);
		add(l3);
		
		JLabel l4 = new JLabel("GENDER");
		l4.setBounds(435,10,130,20);
		l4.setFont(f);
		add(l4);
		
		JLabel l5 = new JLabel("COUNTRY");
		l5.setBounds(580,10,100,20);
		l5.setFont(f);
		add(l5);
		
		JLabel l6 = new JLabel("ROOM NO");
		l6.setBounds(710,10,100,20);
		l6.setFont(f);
		add(l6);
		

		JLabel l7 = new JLabel("STATUS");
		l7.setBounds(850,10,100,20);
		l7.setFont(f);
		add(l7);
		
		JLabel l8 = new JLabel("DEPOSIT");
		l8.setBounds(980,10,100,20);
		l8.setFont(f);
		add(l8);
		
		b1 = new JButton("LOAD DATA");
		b1.setBounds(350, 560,120,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		
		add(b1);
		
		b2 = new JButton("BACK");
		b2.setBounds(530,560,120,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		setVisible(true);
	
	}
	public static void main(String[] args) {
		new CustomerInfo().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				conn c = new conn();
				String str = "select * from customer";
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
