package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.Date;


public class Withdrawl extends JFrame implements ActionListener{
	JButton back,withdraw;
	JTextField amt;
	String pinno;
	Withdrawl(String pinno){
		this.pinno=pinno;
		setLayout(null); 
		
		
		ImageIcon atmicon= new ImageIcon(ClassLoader.getSystemResource("mainicons/atm.jpg"));
		Image atmimage=atmicon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon mainimage=new ImageIcon(atmimage);
		
		JLabel image=new JLabel(mainimage);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text=new JLabel("Enter the amount you want to withdraw");
		text.setFont(new Font("Raleway",Font.BOLD,18));
		text.setForeground(Color.WHITE);
		text.setBounds(170,320,700,35);
		image.add(text);
		
		amt=new JTextField();
		amt.setBounds(240, 400, 200, 30);
		amt.setFont(new Font("Raleway",Font.BOLD,15));
		amt.setBackground(Color.WHITE);
		amt.setForeground(Color.BLACK);
		image.add(amt);
		
		withdraw=new JButton("Withdraw");
		withdraw.setBounds(350, 500, 150, 30);
		withdraw.setFont(new Font("Raleway",Font.BOLD,15));
		withdraw.setBackground(Color.WHITE);
		withdraw.setForeground(Color.BLACK);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back=new JButton("Back");
		back.setFont(new Font("Raleway",Font.BOLD,15));
		back.setBackground(Color.WHITE);
		back.setBounds(180, 500, 100, 30);
		back.setForeground(Color.BLACK);
		back.addActionListener(this);
		image.add(back);
		
		
		
		 
		
		
		
		setLocation(300,0);
		setSize(900,900);
	  //setUnd.ecorated(true);
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==back) {
			setVisible(false);
			new Transaction(pinno).setVisible(true);
			
		}
		else if(ae.getSource()==withdraw) {
			
			
			
			String withdrawamt=amt.getText();
			
			Date date=new Date();
			if(withdrawamt.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
				
			}
			else {
				try {
				Connection c=new Connection();
				
				String query="insert into bank values ('"+pinno+"', '"+date+"', 'Withdraw','"+withdrawamt+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Rs"+withdrawamt+" withdrawn successfully" );
				setVisible(false);
				new Transaction(pinno).setVisible(true);
				} catch(Exception e) {
					System.out.println(e);
				}
			}
			
		}
	}

	public static void main(String[] args) {
		new Withdrawl("");
		
		

	}
	
	

}
