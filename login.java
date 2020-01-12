package MainPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import sqlCon.Validation;

//import SkyForce.Main1;
import MainPage.frame;

public class Login extends JFrame{
   JFrame frame = new JFrame("Game Login");
   static JTextField username = new JTextField();
   
	 Login(){
		 //font
		 Font f = new Font("Serif",Font.BOLD,30);
		 //header
		 JPanel heading;
		 heading = new JPanel();
		 heading.setBackground(new Color(0,0,0,50));
		 heading.setBounds(150,0,200,40);
		 JLabel name = new JLabel ("GAME LOGIN");
		 name.setBounds(150,0,200,40);
		 name.setForeground(Color.WHITE);
		 name.setFont(f);
		 heading.add(name);
		 
		//login panel
		 JPanel login = new JPanel();
		 login.setLayout(null);
		 login.setSize(300,250);
		 login.setBackground(new Color(204, 204, 204,30));
		 //login.setBackground(Color.WHITE);
		 login.setBounds(0,40,500,335);
		 
		 
		 JLabel uname = new JLabel("Username :");
		 uname.setBounds(55,30,130,30);
		 username.setBounds(50,52,130,30);
		 username.setBackground(new Color(0,0,0,50));
		 username.setForeground(Color.WHITE);
		 uname.setForeground(Color.WHITE);
		 uname.setBackground(new Color(0,0,0,50));
		 login.add(uname);
		 login.add(username);
		 
		 JPasswordField pass = new JPasswordField();
		 JLabel pas = new JLabel("Password :");
		 pas.setBounds(260,29,130,30);
		 pass.setBounds(260,50,130,30);
		 pass.setBackground(new Color(0,0,0,50));
		 pas.setBackground(new Color(0,0,0,50));
		 
		 pas.setForeground(Color.WHITE);
		 pass.setForeground(Color.WHITE);
		 login.add(pass);
		 login.add(pas);
		 
		 JButton signup = new JButton("Sign Up");
		 signup.setBounds(270,200,100,40);
		 signup.setBackground(new Color(0,0,0,50));
		 signup.setForeground(Color.WHITE);
		 login.add(signup);
		 
		 signup.addActionListener(new ActionListener() {

				
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					SignUp sign = new SignUp();
					//sign.setVisible(true);
				}
				
			});
		 
		 JButton Login = new JButton("Login In");
		 Login.setBounds(130,200,100,40);
		 Login.setBackground(new Color(0,0,0,50));
		 Login.setForeground(Color.WHITE);
		 login.add(Login);
		 
		Login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Validation val = new Validation();
				String password = val.Login(username.getText());
				@SuppressWarnings("deprecation")
				String upass = pass.getText();
				if(pass.getText() == null ||pass.getText().isEmpty()|| username.getText()== null|| username.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Username and Password !");
				}
				else if (password==null || !(password.equalsIgnoreCase(upass))) {
					JOptionPane.showMessageDialog(null, "Invalid Login");
					
				}
				else {
					frame.dispose(); 
					 new frame();
					
				}
				
				
				
			}
		
			
		});
		 
		 
		 //create frame&BG
		 JLabel background ;
		 frame.setSize(500,375);
		 frame.setLayout(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setLocationRelativeTo(null);
		 frame.setResizable(false);
		 ImageIcon img = new ImageIcon("loginBG.gif");
		 background = new JLabel("",img,JLabel.CENTER);
		 background.add(heading);
		 background.add(login);
		 background.setBounds(0,0,500,375);
		 frame.add(background);
		 
		 
		 frame.setVisible(true);
		 
	 }
	 
	 public static String getUsername() {
		return username.getText();
		 
	 }
	 
	 public static void main(String args[]) {
		 new Login();
	 }
}
