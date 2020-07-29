package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class AddEmployee extends JFrame implements ActionListener{
	
	JTextField t1,t2,t3,t4,t5,t6;
	JRadioButton r1,r2;
	JComboBox<String> c1;
	JButton b1,b2;
	Font f = new Font("Serif",Font.BOLD,16);
	AddEmployee(){
		setLayout(null);
		setBounds(570,200,900,600);
		this.setTitle("Add Employee");
		JLabel name = new JLabel("NAME");
		name.setBounds(60,30,120,30);
		name.setFont(new Font("Seirf",Font.BOLD,17));
		add(name);
		
		t1 = new JTextField();
		t1.setBounds(190,30,150,30);
		t1.setFont(f);
		add(t1);
		
		JLabel age = new JLabel("AGE");
		age.setBounds(60,80,120,30);
		age.setFont(new Font("Seirf",Font.BOLD,17));
		add(age);
		
		t2 = new JTextField();
		t2.setBounds(190,80,150,30);
		t2.setFont(f);
		add(t2);
		
		JLabel gender = new JLabel("GENDER");
		gender.setBounds(60,130,120,30);
		gender.setFont(new Font("Seirf",Font.BOLD,17));
		add(gender);
		
		ButtonGroup grp = new ButtonGroup();
		
		r1 = new JRadioButton("Male");
		r1.setBounds(190,130,70,30);
		r1.setFont(new Font("Serif",Font.BOLD,17));
		r1.setBackground(Color.WHITE);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBounds(280,130,100,30);
		r2.setFont(new Font("Serif",Font.BOLD,17));
		r2.setBackground(Color.WHITE);
		add(r2);
		grp.add(r1);
		grp.add(r2);
		
		JLabel job = new JLabel("JOB");
		job.setBounds(60,180,120,30);
		job.setFont(new Font("Seirf",Font.BOLD,17));
		add(job);
		
		String str[] = {"Front Desk Clerks","Porters","HouseKeeping","Kitchen Staff","Room Servcie","Waiter/Waitress","Manager","Accountant","Chef"};
		c1 = new JComboBox<String>(str);
		c1.setBounds(190,180,180,30);
		c1.setFont(new Font("Serif",Font.BOLD,17));
		c1.setBackground(Color.WHITE);
		add(c1);
		
		
		JLabel salary = new JLabel("SALARY");
		salary.setBounds(60,230,120,30);
		salary.setFont(new Font("Seirf",Font.BOLD,17));
		add(salary);
		
		t3 = new JTextField();
		t3.setBounds(190,230,150,30);
		t3.setFont(f);
		add(t3);
		
		JLabel phone = new JLabel("PHONE");
		phone.setBounds(60,280,120,30);
		phone.setFont(new Font("Seirf",Font.BOLD,17));
		add(phone);
		
		t4 = new JTextField();
		t4.setBounds(190,280,150,30);
		t4.setFont(f);
		add(t4);
		
		JLabel aadhar = new JLabel("AADHAR");
		aadhar.setBounds(60,330,120,30);
		aadhar.setFont(new Font("Seirf",Font.BOLD,17));
		add(aadhar);
		
		t5 = new JTextField();
		t5.setBounds(190,330,150,30);
		t5.setFont(f);
		add(t5);
		
		JLabel email = new JLabel("EMAIL");
		email.setBounds(60,380,120,30);
		email.setFont(new Font("Seirf",Font.BOLD,17));
		add(email);
		
		t6 = new JTextField();
		t6.setBounds(190,380,150,30);
		t6.setFont(f);
		add(t6);
		
		
		b1 = new JButton("SUBMIT");
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		b1.setBounds(80,450,100,30);
		b1.addActionListener(this);
		add(b1);
		
		
		b2 = new JButton("CANCEL");
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		b2.setBounds(210,450,100,30);
		b2.addActionListener(this);
		add(b2);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/tenth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(480, 600, Image.SCALE_DEFAULT);
		i1 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i1);
		l1.setBounds(400,100,450,450);
		add(l1);
		
		
		JLabel l2  = new JLabel("ADD EMPLOYEE DETAILS");
		l2.setForeground(Color.BLUE);
		l2.setFont(new Font("Serif",Font.BOLD,30));
		l2.setBounds(420,30,400,40);
		add(l2);
		
	
		
		this.getContentPane().setBackground(Color.WHITE);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddEmployee().setVisible(true);;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			// TODO Auto-generated method stub
			String name = t1.getText();
			String age = t2.getText();
			String salary = t3.getText();
			String phone = t4.getText();
			String aadhar = t5.getText();
			String email = t6.getText();
			
			String gender = null;
			if(r1.isSelected()) {
				gender = "Male";
			}
			else if(r2.isSelected()) {
				gender = "Female";
			}
			
			String job = (String)c1.getSelectedItem();
			
			conn c = new conn();
			String str = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
			try {
				 c.s.executeUpdate(str);
				 JOptionPane.showMessageDialog(null, "New Employee Added");
				 this.setVisible(false);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(ae.getSource()==b2) {
			
//			new Dashboard().setVisible(true);
			this.setVisible(false);
		}
		
	}

}
