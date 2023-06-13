package bankmanagementsystem;
import java.awt.*;
import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class Signup3 extends JFrame implements ActionListener {
	JRadioButton sa,rd,ca,fd  ;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formno;
	Signup3(String formno){
		this.formno=formno;
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);	
		setSize(800,700);
		setLocation(350,10);
		setVisible(true);
		
		JLabel head=new JLabel("Page 3: Account Details" );
		head.setFont(new Font("Raleway",Font.BOLD,20));
		head.setBounds(300,30,300,30);
		add(head);
		
		JLabel type=new JLabel("Acount Type:" );
		type.setFont(new Font("Raleway",Font.BOLD,17));
		type.setBounds(60,80,150,30);
		add(type);
		sa=new JRadioButton("Savings Account");
		sa.setFont(new Font("Raleway",Font.BOLD,17));
		sa.setBounds(230,80,200,30);
		add(sa);
		fd=new JRadioButton("Fixed Deposit Account");
		fd.setFont(new Font("Raleway",Font.BOLD,17));
		fd.setBounds(480,80,280,30);
		add(fd);
		ca=new JRadioButton("Current Account");
		ca.setFont(new Font("Raleway",Font.BOLD,17));
		ca.setBounds(230,120,200,30);
		add(ca);
		rd=new JRadioButton("Recurring Deposit Account");
		rd.setFont(new Font("Raleway",Font.BOLD,17));
		rd.setBounds(480,120,280,30);
		add(rd);
		
		
		ButtonGroup typeacc=new ButtonGroup();
		typeacc.add(ca);
		typeacc.add(sa);
		typeacc.add(fd);
		typeacc.add(rd);
		
		JLabel card=new JLabel("Card Number:" );
		card.setFont(new Font("Raleway",Font.BOLD,17));
		card.setBounds(60,170,300,30);
		add(card);
		
		JLabel number=new JLabel("XXXX-XXXX-XXXX-2750" );
		number.setFont(new Font("Raleway",Font.BOLD,17));
		number.setBounds(230,170,300,30);
		add(number);
		JLabel carddetail=new JLabel("Your 16 digit card number" );
		carddetail.setFont(new Font("Raleway",Font.BOLD,15));
		carddetail.setBounds(230,195,300,20);
		add(carddetail);
		
		JLabel pin=new JLabel("Pin Number:" );
		pin.setFont(new Font("Raleway",Font.BOLD,17));
		pin.setBounds(60,250,300,30);
		add (pin);
		
		JLabel pnumber=new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway",Font.BOLD,17));
		pnumber.setBounds(230,250,300,30);
		add(pnumber);
		JLabel pindetail=new JLabel("Your 4 digit pin number" );
		pindetail.setFont(new Font("Raleway",Font.BOLD,15));
		pindetail.setBounds(230,275,300,20);
		add(pindetail);
		
		JLabel services=new JLabel("Services Required:" );
		services.setFont(new Font("Raleway",Font.BOLD,17));
		services.setBounds(60,300,300,30);
		add (services);
		
		c1= new JCheckBox("ATM Card");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway", Font.BOLD,15));
		c1.setBounds(230,300,200,30);
		add(c1);
		c2= new JCheckBox("Internet Banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway", Font.BOLD,15));
		c2.setBounds(440,300,200,30);
		add(c2);
		c3= new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway", Font.BOLD,15));
		c3.setBounds(230,340,200,30);
		add(c3);
		c4= new JCheckBox("Email Alerts");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway", Font.BOLD,15));
		c4.setBounds(440,340,200,30);
		add(c4);
		c5= new JCheckBox("Cheque Book");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway", Font.BOLD,15));
		c5.setBounds(230,380,200,30);
		add(c5);
		c6= new JCheckBox("E- Statements");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Raleway", Font.BOLD,15));
		c6.setBounds(440,380,200,30);
		add(c6);
		c7= new JCheckBox("I hereby declare that all the above entered details are correct to the best of my knowlwdge.");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Raleway", Font.BOLD,14));
		c7.setBounds(60,430,700,30);
		add(c7);
		
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(60, 480, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		
		submit=new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(600, 480, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		
		
 		
		
		
		
		
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==submit) {
			String acctype=null;
			if(sa.isSelected()) acctype="Savings Account";
			else if(ca.isSelected())acctype="Current Account";
			else if(rd.isSelected())acctype="Recurring Deposit Account";
			else if(fd.isSelected())acctype="Fixed Deposit Account";
			
			Random ran=new Random();
			String cardno= ""+Math.abs((ran.nextLong()%90000000L)+5040936000000000L);
			String pinno=""+ Math.abs((ran.nextLong()%9000L)+100L);
			String facility="";
			if(c1.isSelected())facility=facility+" ATM Card";
			else if(c2.isSelected())facility=facility+" Internet Banking";
			else if(c3.isSelected())facility=facility+" Mobile Banking";
			else if(c4.isSelected())facility=facility+" Email Alerts";
			else if(c5.isSelected())facility=facility+" Cheque Book";
			else if(c6.isSelected())facility=facility+" E- Statement";
			
			try {
				if(acctype.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is Required");
					
				}
				else {
					Connection c=new Connection();
					
					String query1="insert into signup3 values('"+formno+"','"+acctype+"','"+cardno+"',+'"+pinno+"','"+facility+"')";
					String query2="insert into login values('"+formno+"','"+cardno+"',+'"+pinno+"')";
					c.s.executeUpdate(query1);
					c.s.executeUpdate(query2);
					JOptionPane.showMessageDialog(null, "Card No: "+ cardno + "\n Pin no: "+pinno);
					setVisible(false);
					new Deposit(pinno).setVisible(false);
				
			
			}
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}else if(ae.getSource()==cancel) {
			setVisible(false);
			new Login().setVisible(true);
				
			}
}

	

	public static void main(String[] args) {
		new Signup3("");

	}

}
