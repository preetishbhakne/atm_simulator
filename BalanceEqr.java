package bankmanagementsystem;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class BalanceEqr extends JFrame implements ActionListener{
	JButton back;
	String pinno;
	
	BalanceEqr(String pinno){
		this.pinno=pinno;
		
		setLayout(null);
		ImageIcon atmicon= new ImageIcon(ClassLoader.getSystemResource("mainicons/atm.jpg"));
		Image atmimage=atmicon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon mainimage=new ImageIcon(atmimage);
		
		JLabel image=new JLabel(mainimage);
		image.setBounds(0,0,900,900);
		add(image);
		
		
		back=new JButton("Back");
		back.setBounds(400, 500, 100, 30);
		back.addActionListener(this);
		image.add(back);
		
		Connection c=new Connection();
		int balance=0;
		
		try {
			ResultSet rs= c.s.executeQuery("select * from bank where pin_no='"+pinno+"'");
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance+=Integer.parseInt(rs.getString("amount"));
					
					
				}else {
					balance-=Integer.parseInt(rs.getString("amount"));
				}
				
			}
			}catch (Exception e) {
				System.out.println(e);
			}
		
		JLabel text=new JLabel("Your current account balance is Rs "+balance);
		text.setForeground(Color.WHITE);
		text.setBounds(170, 300, 400, 30);
		image.add(text);
		
		
		
		setLocation(300,0);
		setSize(900,900);
		//setUndecorated(true);
		setVisible(true);
		
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transaction(pinno).setVisible(true);
		
	}
	public static void main(String[] args) {
		new BalanceEqr("");

	}

}
