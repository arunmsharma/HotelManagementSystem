package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class AddCustomer extends JFrame implements ActionListener{
	Font f = new Font("Serif",Font.BOLD,14);
	Font f1 = new Font("Serif",Font.BOLD,16);
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2;
	JComboBox c1;
	JRadioButton r1,r2;
	Choice c2;
	
	public AddCustomer() {
		setLayout(null);
		setBounds(600,200,800,550);
		this.setTitle("Add Customer");
		
		JLabel l1 = new JLabel("NEW CUSTOMER FORM");
		l1.setFont(new Font("Serif",Font.BOLD,18));
		l1.setBounds(100,20,240,30);
		l1.setForeground(Color.BLUE);
		add(l1);
		
		
		JLabel l2 = new JLabel("ID");
		l2.setBounds(35,80,100,20);
		l2.setFont(f);
		add(l2);
		
		c1 = new JComboBox<String>(new String[] {"PASSPORT","VOTER ID","DL","AADHAR"});
		c1.setBounds(200,80,150,20);
		c1.setFont(f);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		JLabel l3 = new JLabel("NUMBER");
		l3.setBounds(35,120,100,20);
		l3.setFont(f);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(200,120,150,25);
		t1.setFont(f1);
		add(t1);
		
		JLabel l4 = new JLabel("NAME");
		l4.setBounds(35,160,100,20);
		l4.setFont(f);
		add(l4);
		
		t2 = new JTextField();
		t2.setBounds(200,160,150,25);
		t2.setFont(f1);
		add(t2);
		
		
		
		JLabel l5 = new JLabel("GENDER");
		l5.setBounds(35,200,100,20);
		l5.setFont(f);
		add(l5);
		
		ButtonGroup btn = new ButtonGroup();
		
		r1 = new JRadioButton("MALE");
		r1.setBounds(200,200,80,25);
		r1.setBackground(Color.WHITE);
		r1.setFont(f);
		add(r1);
		btn.add(r1);
		
		r2 = new JRadioButton("FEMALE");
		r2.setBounds(280,200,80,25);
		r2.setBackground(Color.WHITE);
		r2.setFont(f);
		add(r2);
		btn.add(r2);
		
		
		JLabel l6 = new JLabel("COUNTRY");
		l6.setBounds(35,240,100,20);
		l6.setFont(f);
		add(l6);
		
		t3 = new JTextField();
		t3.setBounds(200,240,150,25);
		t3.setFont(f1);
		add(t3);
		
		JLabel l7 = new JLabel("ALLOCATED ROOM NO");
		l7.setBounds(35,280,160,20);
		l7.setFont(f);
		add(l7);
		
		c2 = new Choice();
		try {
			conn c = new conn();
			String str = "select * from room";
			ResultSet rs = c.s.executeQuery(str);
			while(rs.next()) {
				c2.add(rs.getString("room_number"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		c2.setBounds(200,280,150,25);
		c2.setFont(f);
		add(c2);
		
		JLabel l8 = new JLabel("CHECKED IN");
		l8.setBounds(35,320,100,20);
		l8.setFont(f);
		add(l8);
		
		t4 = new JTextField();
		t4.setBounds(200,320,150,25);
		t4.setFont(f1);
		add(t4);
		
		JLabel l9 = new JLabel("DEPOSIT");
		l9.setBounds(35,360,100,20);
		l9.setFont(f);
		add(l9);
		
		t5 = new JTextField();
		t5.setBounds(200,360,150,25);
		t5.setFont(f1);
		add(t5);
		
		b1 = new JButton("ADD CUSTOMER");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(35,410,130,35);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("BACK");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(220,410,130,35);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/fifth.png"));
		Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		i1 = new ImageIcon(i2);
		JLabel l10 = new JLabel(i1);
		l10.setBounds(400,50,300,400);
		add(l10);
		
		this.getContentPane().setBackground(Color.WHITE);
		
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddCustomer().setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
			String id = (String)c1.getSelectedItem();
			String number = t1.getText();
			String name = t2.getText();
			String gender = null;
			if(r1.isSelected()) {
				gender = "MALE";
			}
			else if(r2.isSelected()) {
				gender = "FEMALE";
			}
			
			String country = t3.getText();
			String room = c2.getSelectedItem();
			String status = t4.getText();
			String deposit = t5.getText();
			
			String str = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
			String str2 = "update room set available ='OCCUPIED' where room_number = '"+room+"'";
			try {
				conn c = new conn();
				c.s.executeUpdate(str);
				c.s.executeUpdate(str2);
				JOptionPane.showMessageDialog(null, "New Cutomer Added");
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
