package bankmanagementsystem;

import java.awt.Color;
import java.sql.*;
import com.toedter.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Signup1 extends JFrame implements ActionListener{
	int appno;
	JTextField nametf,fnametf,emailtf,addtf,citytf,statetf,pintf;
	JButton next;
	JRadioButton male,female;
	JDateChooser dc;
	Signup1(){
		setLayout(null);
		
	getContentPane().setBackground(Color.WHITE);	
	setSize(500,600);
	setLocation(350,10);
	setVisible(true);
	
	Random ran=new Random();
	
	 appno=ran.nextInt(1000,9999);
	//System.out.print(appno);
	
	JLabel formno=new JLabel("Application Form No: " +appno );
	formno.setFont(new Font("Raleway",Font.BOLD,20));
	formno.setBounds(120, 10, 800, 30);
	add(formno);
	
	JLabel personaldetails=new JLabel("Page1: Personal Details" );
	personaldetails.setFont(new Font("Raleway",Font.BOLD,15));
	personaldetails.setBounds(150, 50, 500, 30);
	add(personaldetails);
	
	JLabel name=new JLabel("Name: " );
	name.setFont(new Font("Raleway",Font.BOLD,15));
	name.setBounds(50, 90, 150,30);
	add(name);
	
	nametf=new JTextField();
	nametf.setFont(new Font("Raleway",Font.BOLD,15));
	nametf.setBounds(200, 90, 150, 30);
	add(nametf);
	
	JLabel fname=new JLabel("Father's Name: " );
	fname.setFont(new Font("Raleway",Font.BOLD,15));
	fname.setBounds(50, 130, 150,30);
	add(fname);
	
	fnametf=new JTextField();
	fnametf.setFont(new Font("Raleway",Font.BOLD,15));
	fnametf.setBounds(200,130, 150, 30);
	add(fnametf);
	
	JLabel dob=new JLabel("DOB: " );
	dob.setFont(new Font("Raleway",Font.BOLD,15));
	dob.setBounds(50, 170, 150, 30);
	add(dob);
	
	dc=new JDateChooser();
	dc.setBounds(200,170,150,30);
	dc.setForeground(new Color(105,105,105 ));
	add(dc);
	
	JLabel gender=new JLabel("Gender: " );
	gender.setFont(new Font("Raleway",Font.BOLD,15));
	gender.setBounds(50, 210, 150, 30);
	add(gender);
	
	male=new JRadioButton("Male");
	male.setBounds(200, 210, 60, 30);
	add(male);
	
	
	female=new JRadioButton("Female");
	female.setBounds(275, 210, 80, 30);
	add(female);
	
	ButtonGroup gendergroup=new ButtonGroup();
	gendergroup.add(male);
	gendergroup.add(female);
	
	
	JLabel email=new JLabel("Email ID: " );
	email.setFont(new Font("Raleway",Font.BOLD,15));
	email.setBounds(50, 250, 150, 30);
	add(email);
	
	 emailtf=new JTextField();
	emailtf.setFont(new Font("Raleway",Font.BOLD,15));
	emailtf.setBounds(200,250, 150, 30);
	add(emailtf);
	
	JLabel address=new JLabel("Address: " );
	address.setFont(new Font("Raleway",Font.BOLD,15));
	address.setBounds(50, 290, 150, 30);
	add(address);
	
	 addtf=new JTextField();
	addtf.setFont(new Font("Raleway",Font.BOLD,15));
	addtf.setBounds(200,290, 150, 30);
	add(addtf);
	
	JLabel city=new JLabel("City: " );
	city.setFont(new Font("Raleway",Font.BOLD,15));
	city.setBounds(50, 330, 150, 30);
	add(city);
	
	citytf=new JTextField();
	citytf.setFont(new Font("Raleway",Font.BOLD,15));
	citytf.setBounds(200,330, 150, 30);
	add(citytf);
	
	JLabel state=new JLabel("State: " );
	state.setFont(new Font("Raleway",Font.BOLD,15));
	state.setBounds(50, 370, 150, 30);
	add(state);
	
	statetf=new JTextField();
	statetf.setFont(new Font("Raleway",Font.BOLD,15));
	statetf.setBounds(200,370, 150, 30);
	add(statetf);
	
	JLabel pincode=new JLabel("Pin Code: " );
	pincode.setFont(new Font("Raleway",Font.BOLD,15));
	pincode.setBounds(50, 410, 150, 30);
	add(pincode);
	
	pintf=new JTextField();
	pintf.setFont(new Font("Raleway",Font.BOLD,15));
	pintf.setBounds(200,410, 150, 30);
	add(pintf);
	
	
	next=new JButton("Next");
	next.setBackground(Color.BLACK);
	next.setForeground(Color.WHITE);
	next.setBounds(280, 450, 70, 25);
	next.setFont(new Font("Raleway",Font.BOLD,14));
	next.addActionListener(this);
	add(next);
	
	}
	
	public void actionPerformed(ActionEvent ae) {
		String formno=""+appno;
		String name= nametf.getText();
		String fname=fnametf.getText();
		String dob= ((JTextField)dc.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(male.isSelected()) {
			gender="Male";
		}
		else if (female.isSelected())gender="Female";
		String email=emailtf.getText();
		String address=addtf.getText();
		String city=citytf.getText();
		String state=statetf.getText();
		String pincode=pintf.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is required");
			}
			else {
				Connection c= new Connection();
				
				String query="insert into signup values('"+formno+"','"+name+"','"+fname+"',+'"+dob+"','"+gender+"','"+email+"','"+address+"','"+city+"','"+state+"', '"+pincode+"')";
				c.s.executeUpdate(query);
				setVisible(false);
				new Signup2(formno).setVisible(true);
				
			}
		} catch (Exception e) {
			System.out.println(e);  
		}
		
		
		}
	public static void main(String[] args) {
		new Signup1();
		// TODO Auto-generated method stub

	}

}
