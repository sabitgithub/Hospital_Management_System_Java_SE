package hospital.management.system;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.lang.*;
import java.util.Scanner; 
import java.io.*;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


class PasswordSysGui extends JFrame{ 

//MyFrame frame;

JLabel lbl1;
JLabel lbl2;
JLabel lbl3;
JLabel lbl4;
JLabel lbl5;


JTextField tf1;
JTextField tf2;
JTextField tf3;
JTextField tf4;
JTextField tf5;


JButton btn1;
JButton btn2;
JButton btn3;
JButton btn4;

AdminDash a;

JFrame forgetFrame;
JPanel forgetPanel;
JFrame backFrame;


	public PasswordSysGui() {

		//GUI process::
	
		this.setTitle("Login System");
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 12); // For text field
		Font  f3  = new Font(Font.DIALOG,  Font.BOLD, 10);     // For Button
		
		btn1 = new JButton("Login");
		btn1.setFont(f3);
		btn2 = new JButton("Forget Password");
		btn2.setFont(f3);
                
                btn3 = new JButton ("Save");
                btn4 = new JButton ("Login");
                
                
		
		lbl1 = new JLabel(" Username ");
		lbl1.setFont(f2);
                
		lbl2 = new JLabel(" Password ");
		lbl2.setFont(f2);
                
                lbl3 = new JLabel("Username");
                lbl4 = new JLabel("Email Address");
                lbl5 = new JLabel ("New Password");
                
                
		
		
		
		tf1 	= new JTextField();
		tf2 	= new JTextField();
                tf3     = new JTextField();
                tf4     = new JTextField();
                tf5     = new JTextField();
                
                
                
		
		JPanel panel = new JPanel();		
		panel.setLayout(null);
		panel.setBounds(0,0,800,800);
		
		
		lbl1.setBackground(new Color(25,200,155));
		lbl2.setBackground(new Color(25,200,155));
                lbl3.setBackground(new Color(25,200,155));
		lbl4.setBackground(new Color(25,200,155));
                lbl5.setBackground(new Color(25,200,155));
		
		panel.setBackground(new Color(60, 183, 0));
		btn1.setBackground(Color.CYAN);
		btn2.setBackground(Color.CYAN);
		
		lbl1.setBounds(410,45,100,30);
		lbl2.setBounds(410,100,100,30);
		lbl3.setBounds(20,45,200,50);
		lbl4.setBounds(20,100,200,50);
                lbl5.setBounds(20,155,200,50);
                
                
		
		tf1.setBounds(500,50,80,30);
		tf2.setBounds(500,100,80,30);
                tf3.setBounds(150,60,200,30);
		tf4.setBounds(150,110,200,30);
                tf5.setBounds(150,160,200,30);
                
		
		btn1.setBounds(450,160,125,30); // Login
		btn2.setBounds(450,200,125,30); // Forget Password
                btn3.setBounds(250,200,125,30); // Forget Password
                btn4.setBounds(400,200,125,30); // Forget Password
		
		panel.add(lbl1);
		panel.add(lbl2);
		
		panel.add(tf1);
		panel.add(tf2);
		
		panel.add(btn1);
		panel.add(btn2);
                
		String [] logarra = new String [7];
		
		
		ImageIcon background = new ImageIcon("Hi.PNG"); //IMG setup ...........
		JLabel lblImg = new JLabel();
		lblImg.setBounds(0,0,500,700);
		lblImg.setIcon(background);
		this.add(lblImg);		
		this.add(panel);
                
                
                
                
                
                
                
                
                                        
                  forgetPanel = new JPanel();		
                                        forgetPanel.setLayout(null);
                                        forgetPanel.setBounds(0,0,800,800);
                                        forgetPanel.setBackground(new Color(60, 183, 0));
                                        forgetPanel.add(lbl3);
                                        forgetPanel.add(lbl4);
                                       // forgetPanel.add(lbl5);
                                        
                                        forgetPanel.add(tf3);
                                        forgetPanel.add(tf4);
                                        //forgetPanel.add(tf5);
                                        forgetPanel.add(btn3);
                                        forgetPanel.add(btn4);
                
		btn1.addActionListener( new ActionListener(){		//Login
			
			
			public void actionPerformed(ActionEvent e){
				
					String UsernameHold = tf1.getText();
					String PasswordHold = tf2.getText();
					
					
					
                                     if(UsernameHold.equals ("") || PasswordHold.equals("") )   
                                     {
                                       JOptionPane.showMessageDialog(null,"invalid input");  
                                     }
				
                                     else { 
				String usernam = null;
				String pswd = null;
				int counteru = 0;
				int counterp = 0;
				String usernamHold= "nothng";
				String pswdHold= "";
				String usernmH = "nothng";
				String pass = "";
				boolean psflag = false;
				int rowCounter = 0;
				String loginID = null;
                                String  loginType = null;
                                
				
				try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmds","root","");
			Statement stmt = con.createStatement();
			//ResultSet rs = stmt.executeQuery("select * from loginsystem");
			
			ResultSet rs = stmt.executeQuery ("SELECT * FROM `loginsystem` WHERE `Username` = '" +UsernameHold+ "' and `Password` = '"+PasswordHold+"'" );
				
				while(rs.next())
				{
				loginID = rs.getString(4);
                                loginType = rs.getString(3);
				System.out.println(loginID);
					
				rowCounter++;
				}
				System.out.println("ROW: " +rowCounter);
				
				
				
				if (rowCounter > 0)
				{
                                    
				System.out.println("USER ID MATCH");
                                psflag = true;
                                }
                                
                                else
				{
				JOptionPane.showMessageDialog(null,"Invalid Data");
				}
                                
                                if (psflag){
                                if (loginType.equals("admin"))
                                        {
                                         dispose();   
                                   
                                        AdminDash a = new AdminDash(loginID);
                                       
                                        a.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                                        a.setVisible(true);
                                        }
                                else if (loginType.equals("patient"))
                                        {
                                          dispose(); 
                                        Patient p = new Patient(loginID);
                                        p.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                                        p.setVisible(true);
                                         //JOptionPane.showMessageDialog(null,"Patient frame");
                                        }
                                else if (loginType.equals("doctor"))
                                        {
                                         dispose(); 
                                        Doctor d = new Doctor(loginID);
                                        d.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                                        d.setVisible(true);
                                         //JOptionPane.showMessageDialog(null,"doctor frame");
                                        }
                                else if (loginType.equals("receptionist"))
                                        {
                                         dispose(); 
                                        Receptionist r = new Receptionist(loginID);
                                        r.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                                        r.setVisible(true);
                                        // JOptionPane.showMessageDialog(null,"Recptionst frame");
                                        }
                                else if (loginType.equals("accountant"))
                                        {
                                        dispose(); 
                                        Accountant ac = new Accountant(loginID);
                                        ac.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                                        ac.setVisible(true);
                                       //  JOptionPane.showMessageDialog(null,"accountant frame");
                                        }
                                }
              			con.close();
		
			}
			catch(Exception ex){
			System.out.println(ex);
			}
		 
			
                                     }
			}
			}			
			 );
			
		 btn2.addActionListener( new ActionListener(){		//forget password
			
			
			public void actionPerformed(ActionEvent e2){
					dispose();
				forgetFrame = new JFrame();
                                        forgetFrame.setTitle("Login System");
                                        forgetFrame.setSize(600,600);
                                        forgetFrame.setLocationRelativeTo(null);
                                        forgetFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        forgetFrame.setLayout(null);
                                        
                                        forgetFrame.add(forgetPanel);
                                        forgetFrame.setVisible(true);
                                        
                                        
                                        
                                        
					
				//JOptionPane.showMessageDialog(null,resultDouble);
			}
			
		}); 
                 
                 
                 btn3.addActionListener( new ActionListener(){		//Login
			
			
			public void actionPerformed(ActionEvent e){
                                        dispose();
					String UsernameHold = tf3.getText();
					String EmailHold = tf4.getText();
                                        String newPassHold = tf5.getText();
					
					
					
                                     if(UsernameHold.equals ("") || EmailHold.equals(""))   
                                     {
                                       JOptionPane.showMessageDialog(null,"invalid input");  
                                     }
				
                                     else { 
				String usernam = null;
				String email = null;
                                String newPass = null;
                                
				int counteru = 0;
				int counterp = 0;
				String usernamHold= "nothng";
				String pswdHold= "";
				String usernmH = "nothng";
				String pass = "";
				boolean psflag = false;
				int rowCounter = 0;
				String loginID = null;
                                String  loginType = null;
                                
				
				try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmds","root","");
			Statement stmt = con.createStatement();
			//ResultSet rs = stmt.executeQuery("select * from loginsystem");
			
			ResultSet rs = stmt.executeQuery ("SELECT * FROM `loginsystem` WHERE `Username` = '" +UsernameHold+ "' and `email` = '"+EmailHold+"'" );
				
				while(rs.next())
				{
				loginID = rs.getString(1);
                                loginType = rs.getString(2);
				System.out.println(loginID);
					
				rowCounter++;
				}
				System.out.println("ROW: " +rowCounter);
		
				if (rowCounter > 0)
				{
                                    
				System.out.println("USER ID MATCH");
                                psflag = true;
         
                                }
                                
                                else
				{
				JOptionPane.showMessageDialog(null,"Invalid Data");
				}
                                
                                


                                    //Random Class
                                
                                String alphabet= "abcdefghijklmnopqrstuvwxyz";
        String s = "";
        String s2 = "";
        String newRandomPassHold= " ";
        Random random = new Random();
        int randomLen = random.nextInt(5);
        int randomLen2 = random.nextInt(5);
        int randomInt = random.nextInt(5);
        int randomInt2 = random.nextInt(5);
        
        for (int i = 0; i < randomLen; i++) {
            char c = alphabet.charAt(random.nextInt(5));
            s+=c;
        }
        
        for (int i = 0; i < randomLen2; i++) {
            char c = alphabet.charAt(random.nextInt(5));
            s2+=c;
        }
        
       if (s.equals(s2))
       {
        for (int i = 0; i < randomLen; i++) {
            char c = alphabet.charAt(random.nextInt(5));
            s+=c;
        }
        
        for (int i = 0; i < randomLen2; i++) {
            char c = alphabet.charAt(random.nextInt(5));
            s2+=c;
        }   
       }
         newRandomPassHold =s+randomInt+s2+randomInt2;
        System.out.println("Output:"+newRandomPassHold);                                
                               
       
        
                //Mailer
                                
                                final String username = "sabit.asif17@gmail.com";
		final String password = "******";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() 
                  {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

                JOptionPane.showMessageDialog(null,"Please Wait!! New password will be sent to your valid email");
                
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("sabit.asif17@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(EmailHold));
                        
			message.setSubject("Forget Password of Hospital Managment Sys");
			message.setText("Dear "+UsernameHold
				+ "\n\n Your ID:" +loginID 
                        + "\n\n Your New Password is :" +newRandomPassHold
                         + "\n\n All rights reserved @HMS_2018.");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e11) {
			throw new RuntimeException(e11);
		}
                 if (psflag)
                                {
                                    System.out.println("Password update: "+newRandomPassHold );
                                    String sql= "UPDATE `loginsystem` SET `Password` = '"+newRandomPassHold+"' WHERE `loginsystem`.`email` = '"+EmailHold+"' ";
			int a = stmt.executeUpdate(sql);
			if (a!=0)
			{
				JOptionPane.showMessageDialog(null,"Successfully Updated!!");
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"Enter Valid info!!");
			}
                                }
                                else 
                                {
                                    JOptionPane.showMessageDialog(null,"Invalid Update");
                                }
                                
                               
              			con.close();
		
			}
			catch(final Exception ex){
			System.out.println(ex);
                        JOptionPane.showMessageDialog(null,"Failed to update check exceptions.");
			}
		 
			
                                     }
			}
			}			
			 );
                 
                  btn4.addActionListener( new ActionListener(){		//forget password
			
			
			public void actionPerformed(ActionEvent e2){
					dispose();
				backFrame = new JFrame();
                                        backFrame.setTitle("Login System");
                                        backFrame.setSize(600,600);
                                        backFrame.setLocationRelativeTo(null);
                                        backFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        backFrame.setLayout(null);
                                        
                                        backFrame.add(panel);
                                        backFrame.setVisible(true);
 	
				//JOptionPane.showMessageDialog(null,resultDouble);
			}
			
		}); 
          
                 
	}
         }