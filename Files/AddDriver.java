package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{
	
	
	JTextField t1,t2,t3,t4,t5;
	JComboBox c1,c2;
	Font f = new Font("Serif",Font.BOLD,16);
	
	JButton b1,b2;
	public AddDriver() {
		setLayout(null);
		setBounds(500,200,980,500);
		
		JLabel title = new JLabel("ADD DRIVERS");
		title.setBounds(150,10,150,30);
		title.setFont(new Font("Serif",Font.BOLD,18));
		add(title);
		

		JLabel name = new JLabel("NAME");
		name.setBounds(60,70,100,30);
		name.setFont(new Font("Serif",Font.BOLD,15));
		add(name);
		
		t1 = new JTextField();
		t1.setBounds(200,70,150,30);
		t1.setFont(f);
		add(t1);
		
		
		JLabel age = new JLabel("AGE");
		age.setBounds(60,110,100,30);
		age.setFont(new Font("Serif",Font.BOLD,15));
		add(age);
		
		t2 = new JTextField();
		t2.setBounds(200,110,150,30);
		t2.setFont(f);
		add(t2);
		
		JLabel gender= new JLabel("GENDER");
		gender.setBounds(60,150,100,30);
		gender.setFont(new Font("Serif",Font.BOLD,15));
		add(gender);
		
		c1 = new JComboBox<String>(new String[] {"MALE","FEMALE"});
		c1.setBounds(200,150,100,30);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		JLabel car = new JLabel("CAR COMPANY");
		car.setBounds(60,190,120,30);
		car.setFont(new Font("Serif",Font.BOLD,15));
		add(car);
		
		t3 = new JTextField();
		t3.setBounds(200,190,150,30);
		t3.setFont(f);
		add(t3);
		
		JLabel model = new JLabel("MODEL");
		model.setBounds(60,230,100,30);
		model.setFont(new Font("Serif",Font.BOLD,15));
		add(model);
		
		t4 = new JTextField();
		t4.setBounds(200,230,150,30);
		t4.setFont(f);
		add(t4);
		
		JLabel available = new JLabel("AVAILABLE");
		available.setBounds(60,270,100,30);
		available.setFont(new Font("Serif",Font.BOLD,15));
		add(available);
		
		c2 = new JComboBox<String>(new String[] {"AVAILABLE","BUSY"});
		c2.setBackground(Color.WHITE);
		c2.setBounds(200,270,100,30);
		add(c2);
		
		
		JLabel location = new JLabel("LOCATION");
		location.setBounds(60,310,100,30);
		location.setFont(new Font("Serif",Font.BOLD,15));
		add(location);
		
		t5 = new JTextField();
		t5.setBounds(200,310,150,30);
		t5.setFont(f);
		add(t5);
		
		b1 = new JButton("ADD DRIVER");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(60,370,130,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("CANCEL");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(210,370,130,30);
		b2.addActionListener(this);
		add(b2);
		
		this.getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/eleven.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
		i1 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i1);
		
		l1.setBounds(400,20,500,400);
		
		add(l1);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddDriver().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			
			String name = t1.getText();
			String age = t2.getText();
			String gender = (String) c1.getSelectedItem();
			String company = t3.getText();
			String brand = t4.getText();
			String available = (String)c2.getSelectedItem();
			String location = t5.getText();
			
			String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
			
			conn c = new conn();
			try {
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Driver added");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(ae.getSource()==b2) {
			setVisible(false);
		}
	}

}
