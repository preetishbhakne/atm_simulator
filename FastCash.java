package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {
	JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
	String pinno;
	FastCash(String pinno){
		this.pinno=pinno;
		
		setLayout(null);
		
		
		ImageIcon atmicon= new ImageIcon(ClassLoader.getSystemResource("mainicons/atm.jpg"));
		Image atmimage=atmicon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon mainimage=new ImageIcon(atmimage);
		
		JLabel image=new JLabel(mainimage);
		image.setBounds(0,0,900,900);
		add(image);
		
		setLocation(300,0);
		setSize(900,900);
		setUndecorated(true);
		setVisible(true);
		
		
		JLabel text=new JLabel("Select Withdrawl Amount");
		text.setFont(new Font("Raleway",Font.BOLD,18));
		text.setForeground(Color.WHITE);
		text.setBounds(200,300,700,35);
		image.add(text);
		
		deposit=new JButton("Rs 100");
		deposit.setBounds(170, 420, 150, 25);
		deposit.setBackground(Color.WHITE);
		deposit.setForeground(Color.BLACK);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl=new JButton("Rs 500");
		withdrawl.setBounds(350, 420, 150, 25);
		withdrawl.setBackground(Color.WHITE);
		withdrawl.setForeground(Color.BLACK);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash=new JButton("Rs 1000");
		fastcash.setBounds(350, 455, 150, 25);
		fastcash.setBackground(Color.WHITE);
		fastcash.setForeground(Color.BLACK);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement=new JButton("Rs 2000");
		ministatement.setBounds(170, 455, 150, 25);
		ministatement.setBackground(Color.WHITE);
		ministatement.setForeground(Color.BLACK);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange=new JButton("Rs 5000");
		pinchange.setBounds(170, 490, 150, 25);
		pinchange.setBackground(Color.WHITE);
		pinchange.setForeground(Color.BLACK);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry=new JButton("Rs 10000");
		balanceenquiry.setBounds(350, 490, 150, 25);
		balanceenquiry.setBackground(Color.WHITE);
		balanceenquiry.setForeground(Color.BLACK);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		exit=new JButton("Back");
		exit.setBounds(350, 525, 150, 25);
		exit.setBackground(Color.WHITE);
		exit.setForeground(Color.BLACK);
		exit.addActionListener(this);
		image.add(exit);
		
		
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			setVisible(false);
			new Transaction(pinno).setVisible(true);
		}
		else {

			String amt=((JButton)ae.getSource()).getText().substring(3);
			Connection c=new Connection();
			
			try {
				ResultSet rs= c.s.executeQuery("select * from bank where pin_no='"+pinno+"'");
				int balance=0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance+=Integer.parseInt(rs.getString("amount"));
						
						
					}else {
						
						balance-=Integer.parseInt(rs.getString("amount"));
					}
					
				}
				if(ae.getSource()!=exit && balance < Integer.parseInt(amt)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				Date date=new Date();
				String query="insert into bank values('"+pinno+"','"+date+"','withdrawl','"+amt+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+amt+" debited successfully");
				setVisible(false);
				new Transaction(pinno).setVisible(true);
			}catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
	}
	

	public static void main(String[] args) {
		new FastCash("");
		// TODO Auto-generated method stub

	}

}
