package bankmanagementsystem;

import java.awt.Color;
import java.sql.*;
import com.toedter.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
	
	JTextField pannotf,aadharnotf;;
	JButton next;
	JComboBox religioncb,occupationcb,qualificationcb,catagorycb,incomecb;
	JRadioButton eno,eyes;
	JDateChooser dc;
	String formno;
	
	Signup2(String formno){
		this.formno=formno;
		setLayout(null);
		setTitle("New Account Application Page 2");
		
	getContentPane().setBackground(Color.WHITE);	
	setSize(500,600);
	setLocation(350,10);
	setVisible(true);
	
	
	//System.out.print(appno);
	
	
	
	JLabel additionaldetails=new JLabel("Additional Details" );
	additionaldetails.setFont(new Font("Raleway",Font.BOLD,15));
	additionaldetails.setBounds(150, 50, 500, 30);
	add(additionaldetails);
	
	JLabel religion=new JLabel("Religion: " );
	religion.setFont(new Font("Raleway",Font.BOLD,15));
	religion.setBounds(50, 90, 150,30);
	add(religion);
	
	String valReligion[]= {"Hindu","Muslim","Sikh","Christian","Other"};
	religioncb =new JComboBox(valReligion);
	religioncb.setBounds(200, 90, 150,30);
	religioncb.setBackground(Color.WHITE);
	add(religioncb);
	
	JLabel catagory=new JLabel("Catagory: " );
	catagory.setFont(new Font("Raleway",Font.BOLD,15));
	catagory.setBounds(50, 130, 150,30);
	add(catagory);
	
	String valCatagory[]= {"GENERAL","OBC","SC","ST ","Other"};
	catagorycb =new JComboBox(valCatagory);
	catagorycb.setBounds(200, 130, 150,30);
	catagorycb.setBackground(Color.WHITE);
	add(catagorycb);
	
	
	JLabel income=new JLabel("Income: " );
	income.setFont(new Font("Raleway",Font.BOLD,15));
	income.setBounds(50, 170, 150, 30);
	add(income);
	
	String valIncome[]= {"NULL","<1,50,000","<2,50,0000","<5,00,000","Upto 10,00,000",">10,00,000"};
	incomecb =new JComboBox(valIncome);
	incomecb.setBounds(200, 170, 150,30);
	incomecb.setBackground(Color.WHITE);
	add(incomecb);
	
	
	
	JLabel qualification =new JLabel("Qualification: " );
	qualification.setFont(new Font("Raleway",Font.BOLD,15));
	qualification.setBounds(50, 210, 150, 30);
	add(qualification);
	
	String valqualification[]= {"Non- Graduate","Graduate","Post- Graduate","Doctrate","Others"};
	qualificationcb =new JComboBox(valqualification);
	qualificationcb.setBounds(200, 210, 150,30);
	qualificationcb.setBackground(Color.WHITE);
	add(qualificationcb);
	
	JLabel occupation=new JLabel("Occupation: " );
	occupation.setFont(new Font("Raleway",Font.BOLD,15));
	occupation.setBounds(50, 250, 150, 30);
	add(occupation);
	
	String valoccupation[]= {"Salaried","Self- Employee","Bussiness","Student","Others"};
	occupationcb =new JComboBox(valoccupation);
	occupationcb.setBounds(200, 250, 150,30);
	occupationcb.setBackground(Color.WHITE);
	add(occupationcb);
	
	JLabel panno=new JLabel("Pan No: " );
	panno.setFont(new Font("Raleway",Font.BOLD,15));
	panno.setBounds(50, 290, 150, 30);
	add(panno);
	
	pannotf=new JTextField();
	pannotf.setFont(new Font("Raleway",Font.BOLD,15));
	pannotf.setBounds(200,290, 150, 30);
	add(pannotf);
	
	JLabel aadharno=new JLabel("Aadhar No: " );
	aadharno.setFont(new Font("Raleway",Font.BOLD,15));
	aadharno.setBounds(50, 330, 150, 30);
	add(aadharno);
	
	aadharnotf=new JTextField();
	aadharnotf.setFont(new Font("Raleway",Font.BOLD,15));
	aadharnotf.setBounds(200,330, 150, 30);
	add(aadharnotf);
	
	JLabel usertype=new JLabel("Existing User: " );
	usertype.setFont(new Font("Raleway",Font.BOLD,15));
	usertype.setBounds(50, 370, 150, 30);
	add(usertype);
	
	eyes=new JRadioButton("Yes");
	eyes.setFont(new Font("Raleway",Font.BOLD,15));
	eyes.setBounds(200,370, 60, 30);
	add(eyes);
	
	eno=new JRadioButton("No");
	eno.setFont(new Font("Raleway",Font.BOLD,15));
	eno.setBounds(275,370, 60, 30);
	add(eno);
	
	ButtonGroup user=new ButtonGroup();
	user.add(eno);
	user.add(eyes);
	
	
	next=new JButton("Next");
	next.setBackground(Color.BLACK);
	next.setForeground(Color.WHITE);
	next.setBounds(280, 450, 70, 25);
	next.setFont(new Font("Raleway",Font.BOLD,14));
	next.addActionListener(this);
	add(next);
	
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String religion= (String)religioncb.getSelectedItem();
		String catagory=(String)catagorycb.getSelectedItem();
		String income= (String)incomecb.getSelectedItem();
		String qualification= (String)qualificationcb.getSelectedItem();
		String occupation= (String)occupationcb.getSelectedItem();
		String panno=pannotf.getText();
		String aadharno=aadharnotf.getText();
		String user=null;
		if(eyes.isSelected())user="Existing User";
		else if(eno.isSelected())user="New User";
		
		
		
		try {
			if(panno.equals("")) {
				JOptionPane.showMessageDialog(null, "Pan no is required");
			}
			else {
			
				Connection c= new Connection();
				
				String query="insert into signup2  values('"+formno+"','"+religion+"','"+catagory+"',+'"+income+"','"+qualification+"','"+occupation+"','"+panno+"','"+aadharno+"','"+user+"')";
				c.s.executeUpdate(query);
				setVisible(false);
				new Signup3(formno).setVisible(true);
			}
		} catch (Exception e) {
			System.out.println(e);  
		}
	}
		
		
		
public static void main(String[] args) {
	new Signup2("");
//		// TODO Auto-generated method stub
//
	}
//
}

