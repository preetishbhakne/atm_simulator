package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Transaction extends JFrame implements ActionListener {
	JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
	String pinno;
	Transaction(String pinno){
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
		//setUndecorated(true);
		setVisible(true);
		
		
		JLabel text=new JLabel("Please select your transaction");
		text.setFont(new Font("Raleway",Font.BOLD,18));
		text.setForeground(Color.WHITE);
		text.setBounds(200,300,700,35);
		image.add(text);
		
		deposit=new JButton("Deposit");
		deposit.setBounds(170, 420, 150, 25);
		deposit.setBackground(Color.WHITE);
		deposit.setForeground(Color.BLACK);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl=new JButton("Cash Withdrawl");
		withdrawl.setBounds(350, 420, 150, 25);
		withdrawl.setBackground(Color.WHITE);
		withdrawl.setForeground(Color.BLACK);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash=new JButton("Fast Cash");
		fastcash.setBounds(350, 455, 150, 25);
		fastcash.setBackground(Color.WHITE);
		fastcash.setForeground(Color.BLACK);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement=new JButton("Mini Statement");
		ministatement.setBounds(170, 455, 150, 25);
		ministatement.setBackground(Color.WHITE);
		ministatement.setForeground(Color.BLACK);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange=new JButton("Pin Change");
		pinchange.setBounds(170, 490, 150, 25);
		pinchange.setBackground(Color.WHITE);
		pinchange.setForeground(Color.BLACK);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry=new JButton("Balance Enquiry");
		balanceenquiry.setBounds(350, 490, 150, 25);
		balanceenquiry.setBackground(Color.WHITE);
		balanceenquiry.setForeground(Color.BLACK);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		exit=new JButton("Exit");
		exit.setBounds(350, 525, 150, 25);
		exit.setBackground(Color.WHITE);
		exit.setForeground(Color.BLACK);
		exit.addActionListener(this);
		image.add(exit);
		
		
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			System.exit(0);
		}
		else if(ae.getSource()==deposit) {
			setVisible(false);
			new Deposit(pinno).setVisible(true);
		}else if(ae.getSource()==withdrawl) {
			setVisible(false);
			new Withdrawl(pinno).setVisible(true);
		}else if(ae.getSource()==fastcash) {
			setVisible(false); 
			new FastCash(pinno).setVisible(true);
		}else if(ae.getSource()==pinchange) {
			setVisible(false);
			new PinChange(pinno).setVisible(true);
		}else if(ae.getSource()==balanceenquiry) {
			setVisible(false);
			new BalanceEqr(pinno).setVisible(true);
		}else if(ae.getSource()==ministatement) {
			
			new MiniStatement(pinno).setVisible(true);
		}
	}
	

	public static void main(String[] args) {
		new Transaction("");
		// TODO Auto-generated method stub

	}

}
