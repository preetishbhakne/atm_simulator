package bankmanagementsystem;
import java.awt.*;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener {
		JButton login,clear,signup;
		JTextField cardnofield;
		JPasswordField pinfield;
	Login(){
		
		
		
		setTitle("ATM");
		setLayout(null);
		
		//image:
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("mainicons/logo.jpg"));
		Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel label=new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);
		
		//atm details:
		JLabel text= new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(300, 10, 500, 100);
		add(text);
		
		JLabel cardno= new JLabel("Enter Card Number:");
		cardno.setFont(new Font("Osward",Font.BOLD,25));
		cardno.setBounds(150, 120, 500, 75);
		add(cardno);
		
		 cardnofield=new JTextField();
		cardnofield.setBounds(430,135,250,40);
		cardnofield.setFont(new Font("Aeriel",Font.BOLD,14));
		add(cardnofield);
		
		JLabel pin= new JLabel("Enter Pin:");
		pin.setFont(new Font("Osward",Font.BOLD,25));
		pin.setBounds(150, 180, 500, 50);
		add(pin);
		
		 pinfield=new JPasswordField();
		pinfield.setBounds(430,190,250,40);
		add(pinfield);
		
		
		// buttons:
		 login= new JButton("Sign in");
		login.setBounds(300, 300, 80, 30);
		login.addActionListener(this);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		add(login);
		
		 clear= new JButton("Clear");
		clear.setBounds(400, 300, 80, 30);
		clear.addActionListener(this);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		add(clear);
		
		
		 signup= new JButton("Sign Up");
		signup.addActionListener(this);
		signup.setBounds(500, 300, 80, 30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		add(signup);
		
		
		
		//bg color:
		getContentPane().setBackground(Color.WHITE);
		
		
		//frame details:
		setSize(800,480);
		setVisible(true);
		setLocation (350,200);
		
		
		
		
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==clear) {
			cardnofield.setText("");
			pinfield.setText("");
			
		}
		else if(ae.getSource()==login) {
			Connection c=new Connection();
			String cardno=cardnofield.getText();
			String pinno=pinfield.getText();
			String query="select *from login where card_no='"+cardno+"' and pin_no='"+pinno+"'";
			try {
				ResultSet rs=c.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transaction(pinno).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Card No and/or Pin");
				}
				
			}catch (Exception e) {
				System.out.println(e);
			}
			
			
		}
		else if(ae.getSource()==signup) {
			setVisible(false);
			new Signup1().setVisible(true);
			
			
		}
		
		
	}
	 
	public static void main(String[] args) {
		new Login();
		
		
		
	}

 

}
