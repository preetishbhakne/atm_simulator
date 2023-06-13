package bankmanagementsystem;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.*;

public class MiniStatement extends JFrame {
	
	
	MiniStatement(String pinno) {
		setTitle("Mini Statement");
		
		setLayout(null);
		
		
		JLabel mini= new JLabel();
		
		add(mini);
		
		JLabel bankname=new JLabel("SBI");
		bankname.setFont(new Font("Raleway",Font.BOLD,25));
		bankname.setBounds(170, 20, 100, 30);
		add(bankname);
		
		JLabel ms=new JLabel("MINI STATEMENT");
		ms.setFont(new Font("Raleway",Font.BOLD,20));
		ms.setBounds(110, 60, 200, 30);
		add(ms);
		JLabel cn=new JLabel();
		cn.setFont(new Font("Raleway",Font.BOLD,20));
		cn.setBounds(60, 100, 350, 30);
		add(cn);
		JLabel balance=new JLabel();
		balance.setBounds(20, 140, 400, 200);
		 
		try {
			
			Connection c=new Connection();
			
			ResultSet rs=c.s.executeQuery("select * from login where pin_no='"+pinno+"'");
			while(rs.next()) {
				cn.setText("Card No: "+ rs.getString("card_no").substring(0,4)+"XXXXXXXX"+rs.getString("card_no").substring(12));
				
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			Connection c= new Connection();
			int bal=0;
			ResultSet rs=c.s.executeQuery("select * from bank where pin_no='"+pinno+"'");
			while(rs.next()) {
				mini.setText(mini.getText()+"<html>" +rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br>");
				if(rs.getString("type").equals("Deposit")) {
					bal+=Integer.parseInt(rs.getString("amount"));
					
					
				}else {
					bal-=Integer.parseInt(rs.getString("amount"));
				}	
			}
			mini.setText("Your current acc balance is Rs " +bal);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		mini.setBounds(20,140,400,200);
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new MiniStatement("");
		// TODO Auto-generated method stub

	}

}
