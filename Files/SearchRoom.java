package hotel.management.system;
import java.awt.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.ResultSet;
public class SearchRoom extends JFrame implements ActionListener{

	JComboBox c1;
	JCheckBox c2;
	JButton b1,b2;
	
	JTable t1;
	public SearchRoom() {
		setLayout(null);
		setBounds(500,200,1000,650);
		this.getContentPane().setBackground(Color.WHITE);
		this.setTitle("Search Room");
		
		JLabel l1 = new JLabel("SEARCH FOR ROOM");
		l1.setFont(new Font("Serif",Font.BOLD,20));
		l1.setForeground(Color.BLUE);
		l1.setBounds(400,30,200,20);
		add(l1);
		
		
		JLabel l2 = new JLabel("ROOM BED TYPE");
		l2.setBounds(50,100,200,20);
		l2.setFont(new Font("Serif",Font.BOLD,16));
		add(l2);
		
		
		c1 = new JComboBox<String>(new String[] {"SINGLE","DOUBLE"});
		c1.setBounds(220,100,150,25);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		c2 = new JCheckBox("ONLY DISPLAY AVAILABLE");
		c2.setBounds(500,100,220,25);
		c2.setFont(new Font("Serif",Font.BOLD,14));
		c2.setBackground(Color.WHITE);
		c2.setForeground(Color.RED);
		add(c2);
		
		

		JLabel l3 = new JLabel("ROOM NUMBER");
		l3.setBounds(40,160,200,20);
		l3.setFont(new Font("Serif",Font.BOLD,16));
		add(l3);
		

		JLabel l4 = new JLabel("AVAILABILITY");
		l4.setBounds(240,160,200,20);
		l4.setFont(new Font("Serif",Font.BOLD,16));
		add(l4);
		

		JLabel l5 = new JLabel("CLEANING STATUS");
		l5.setBounds(420,160,200,20);
		l5.setFont(new Font("Serif",Font.BOLD,16));
		add(l5);
		

		JLabel l6 = new JLabel("PRICE");
		l6.setBounds(680,160,200,20);
		l6.setFont(new Font("Serif",Font.BOLD,16));
		add(l6);
		

		JLabel l7 = new JLabel("BED TYPE");
		l7.setBounds(820,160,200,20);
		l7.setFont(new Font("Serif",Font.BOLD,16));
		add(l7);
		
		
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
		new SearchRoom().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				String str = "select * from room where bed_type = '"+c1.getSelectedItem()+"'";
				String str2 = "select * from room where available = 'AVAILABLE' AND bed_type= '"+c1.getSelectedItem()+"'";
				conn c= new conn();
				
				ResultSet rs;
				if(c2.isSelected()) {
					rs = c.s.executeQuery(str2);
					t1.setModel(DbUtils.resultSetToTableModel(rs));
				}
				else {
					rs = c.s.executeQuery(str);
					t1.setModel(DbUtils.resultSetToTableModel(rs));
				}
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
