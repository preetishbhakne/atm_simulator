package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;



public class Deposit extends JFrame implements ActionListener{
	JButton back,dep;
	JTextField amt;
	String pinno;
	Deposit(String pinno){
		this.pinno=pinno;
		setLayout(null); 
		
		
		ImageIcon atmicon= new ImageIcon(ClassLoader.getSystemResource("mainicons/atm.jpg"));
		Image atmimage=atmicon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon mainimage=new ImageIcon(atmimage);
		
		JLabel image=new JLabel(mainimage);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text=new JLabel("Enter the amount you want to deposit");
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
		
		 dep=new JButton("Deposit");
		dep.setBounds(400, 500, 100, 30);
		dep.setFont(new Font("Raleway",Font.BOLD,15));
		dep.setBackground(Color.WHITE);
		dep.setForeground(Color.BLACK);
		dep.addActionListener(this);
		image.add(dep);
		
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
		else if(ae.getSource()==dep) {
			String depositamt=amt.getText();
			Date date=new Date();
			if(depositamt.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
				
			}
			else {
				try {
				Connection c=new Connection();
				
				String query="insert into bank values ('"+pinno+"', '"+date+"', 'Deposit','"+depositamt+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Rs"+depositamt+" deposited successfully" );
				setVisible(false);
				new Transaction(pinno).setVisible(true);
				} catch(Exception e) {
					System.out.println(e);
				}
			}
			
		}
	}

	public static void main(String[] args) {
		new Deposit("");
		
		

	}
	
	

}
