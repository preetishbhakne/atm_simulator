package bankmanagementsystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class PinChange extends JFrame implements ActionListener{
		JPasswordField repintf,pintf;
		JButton back,change;
		String pinno;
	PinChange(String pinno){
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
		
		JLabel text= new JLabel("Change Your Pin");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway",Font.BOLD,20));
		text.setBounds(265, 330, 700, 35);
		image.add(text);
		
		JLabel pintext=new JLabel("New pin: ");
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("Raleway",Font.BOLD,17));
		pintext.setBounds(200, 400, 100, 35);
		image.add(pintext);
		
		pintf=new JPasswordField();
		pintf.setForeground(Color.BLACK);
		pintf.setFont(new Font("Raleway",Font.BOLD,15));
		pintf.setBounds(410,400, 65, 35);
		image.add(pintf);
		
		JLabel repintext=new JLabel("Re- enter new pin: ");
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("Raleway",Font.BOLD,17));
		repintext.setBounds(200, 450, 150, 35);
		image.add(repintext);
		
		repintf=new JPasswordField();
		repintf.setFont(new Font("Raleway",Font.BOLD,15));
		repintf.setForeground(Color.BLACK);
		repintf.setBounds(410,450, 65, 35);
		image.add(repintf);
		
		change=new JButton("Change");
		change.setBounds(400, 500, 100, 30);
		change.addActionListener(this);
		image.add(change);
		
		back=new JButton("Back");
		back.setBounds(200, 500, 100, 30);
		back.addActionListener(this);
		image.add(back);
		
	
	
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==change) {
		try {
			String epin=pintf.getText();
			String rpin=repintf.getText();
			
			if(!(epin.equals(rpin))) {JOptionPane.showMessageDialog(null, "The two entered pins do not match");
			return;
			}
			if(epin.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter valid pin");
				return;
			}
			if(rpin.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter new pin");
				return;
				
			}
			Connection c=new Connection();
			String q1= "update bank set pin_no ='"+rpin+"' where pin_no='"+pinno+"'";
			String q2= "update login set pin_no ='"+rpin+"' where pin_no='"+pinno+"'";
			String q3= "update signup3 set pin_no ='"+rpin+"' where pin_no='"+pinno+"'";
			
			c.s.executeUpdate(q1);
			c.s.executeUpdate(q2);
			c.s.executeUpdate(q3);
			JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
			setVisible(false);
			new Transaction(rpin).setVisible(true);
		
		
		} catch (Exception e) {
			System.out.println(e);
		}
		}
		else {
			setVisible(false);
			new Transaction(pinno).setVisible(true);
			
		}
		
		
	}
	public static void main(String[] args) {
		new PinChange("").setVisible(true);
		// TODO Auto-generated method stub

	}

}
