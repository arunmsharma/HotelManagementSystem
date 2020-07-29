package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {
	
	JTable t1;
	JButton b1,b2;
	
	Font f = new Font("Serif",Font.BOLD,14);
	public Room(){
		setLayout(null);
		setBounds(450,200,1100,600);
		this.getContentPane().setBackground(Color.WHITE);
		this.setTitle("ROOMS DATA");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/eight.jpg"));
		Image i2 = i1.getImage().getScaledInstance(550,600,Image.SCALE_DEFAULT);
		i1 = new ImageIcon(i2);
		JLabel icon = new JLabel(i1);
		icon.setBounds(490,10,600,600);
		add(icon);
		
		JLabel l1 = new JLabel("ROOM NO");
		l1.setBounds(15,10,100,20);
		l1.setFont(f);
		l1.setForeground(Color.RED);
		add(l1);
		
		JLabel l2 = new JLabel("AVAILABLE");
		l2.setBounds(108,10,100,20);
		l2.setFont(f);
		l2.setForeground(Color.RED);
		add(l2);
		
		JLabel l3 = new JLabel("STATUS");
		l3.setBounds(230,10,100,20);
		l3.setFont(f);
		l3.setForeground(Color.RED);
		add(l3);
		
		JLabel l4 = new JLabel("PRICE(RS/-)");
		l4.setBounds(310,10,100,20);
		l4.setFont(f);
		l4.setForeground(Color.RED);
		add(l4);
		
		JLabel l5 = new JLabel("BED TYPE");
		l5.setBounds(410,10,100,20);
		l5.setFont(f);
		l5.setForeground(Color.RED);
		add(l5);
		
		
		t1 = new JTable();
		t1.setBounds(0,40,500,400);
		t1.setFont(f);
		add(t1);
		
		b1 = new JButton("LOAD DATA");
		b1.setBounds(100,460,120,30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("BACK");
		b2.setBounds(260,460,120,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Room().setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
			try {
				conn c = new conn();
				String str = "select * from room";
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
