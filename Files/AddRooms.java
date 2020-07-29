package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddRooms extends JFrame implements ActionListener{
	
	JTextField t1,t2;
	JComboBox c1,c2,c3;
	JButton b1,b2;
	Font f = new Font("Serif",Font.BOLD,16);
	public AddRooms(){
		setLayout(null);
		setBounds(510,200,940,500);
		this.getContentPane().setBackground(Color.WHITE);
		
		JLabel l1  = new JLabel("ADD ROOMS");
		l1.setBounds(400,10,200,20);
		l1.setForeground(Color.RED);
		l1.setFont(new Font("Serif",Font.BOLD,20));
		add(l1);
		
		JLabel room = new JLabel("ROOM NUMBER");
		room.setBounds(40,60,150,30);
		room.setFont(new Font("Serif",Font.BOLD,16));
		add(room);
		
		t1 = new JTextField();
		t1.setBounds(220,60,150,30);
		t1.setFont(f);
		add(t1);
		

		JLabel available = new JLabel("AVAILABLE");
		available.setBounds(40,120,150,30);
		available.setFont(new Font("Serif",Font.BOLD,16));
		add(available);
		
		c1 = new JComboBox<String>(new String[]{"AVAILABLE","OCCUPIED"});
		c1.setBounds(220,120,150,30);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		JLabel status = new JLabel("CLEANING STATUS");
		status.setBounds(40,180,150,30);
		status.setFont(new Font("Serif",Font.BOLD,16));
		add(status);
		
		c2 = new JComboBox<String>(new String[]{"CLEAN","DIRTY"});
		c2.setBounds(220,180,150,30);
		c2.setBackground(Color.WHITE);
		add(c2);
		
		JLabel price = new JLabel("PRICE");
		price.setBounds(40,230,150,30);
		price.setFont(new Font("Serif",Font.BOLD,16));
		add(price);
		
		t2 = new JTextField();
		t2.setBounds(220,230,150,30);
		t2.setFont(f);
		add(t2);
		
		JLabel type = new JLabel("BED TYPE");
		type.setBounds(40,280,150,30);
		type.setFont(new Font("Serif",Font.BOLD,16));
		add(type);
		
		c3 = new JComboBox<String>(new String[]{"SINGLE","DOUBLE"});
		c3.setBounds(220,280,150,30);
		c3.setBackground(Color.WHITE);
		add(c3);
		
		b1 = new JButton("ADD ROOM");
		b1.setBounds(40,350,150,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("CANCEL");
		b2.setBounds(220,350,150,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/twelve.jpg"));
		JLabel l5 = new JLabel(i1);
		l5.setBounds(400,50,500,350);
		add(l5);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new AddRooms().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		if(ae.getSource()==b1) {
			String room = t1.getText();
			String available = (String)c1.getSelectedItem();
			String status =  (String)c2.getSelectedItem();
			String price = t2.getText();
			String type = (String) c3.getSelectedItem();
			
			conn c= new conn();
			try {
				String str = "insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
				c.s.executeUpdate(str);
				
				JOptionPane.showMessageDialog(null, "New Room Added");
				this.setVisible(false);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(ae.getSource()==b2) {
			this.setVisible(false);
		}
		
	}

}
