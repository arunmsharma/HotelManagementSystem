package hotel.management.system;
import java.awt.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.sql.ResultSet;
public class Department extends JFrame implements ActionListener{

	
	JButton b1,b2;
	JTable t1;
	public Department() {
		setLayout(null);
		setBounds(500,50,1000,700);
		
		this.getContentPane().setBackground(Color.WHITE);
		this.setTitle("Department");
		

		JLabel l3 = new JLabel("DEPARTMENT NAME");
		l3.setBounds(100,10,200,20);
		l3.setFont(new Font("Serif",Font.BOLD,16));
		add(l3);
		

		JLabel l4 = new JLabel("BUDGET");
		l4.setBounds(700,10,200,20);
		l4.setFont(new Font("Serif",Font.BOLD,16));
		add(l4);
		

		
		b1 = new JButton("SUBMIT");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(340,500,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("BACK");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(540,500,120,30);
		b2.addActionListener(this);
		add(b2);
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Department().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				String str = "select * from department";
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
