package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.lang.*;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentEvent;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



class Accountant extends JFrame{
	
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	JButton btn6;
	JButton btn7;
	JButton btn8;
	JButton btn9;
	JButton btn10;  //Transction
	JButton btn11;  // pdf generate
	JButton btn12;
	JButton btn13;
	JButton btn14;
	JButton btn15; //employee list
	JButton btn16; //add employee
	JButton btn17; //accountant list
	JButton btn18; //add accountant 
	JButton btn19; //receptionist list
	JButton btn20; //add receptionist 
	JButton btn21; //room list
	JButton btn23; //add dpt
	JButton btn24; //add doctor
	JButton btn25; //add accountant
	JButton btn26; //add accountant
        JButton btn31;
	
        JLabel docNamelbl;
        JLabel patientNamelbl;
        JLabel medicineNamelbl;
        
        JTextField docNametf;
        JTextField patientNametf;
        JTextField medicineNametf;
        
        
        
        
        
	
	Accountant a;
	
	
	JPanel doctorPanel;
	JPanel roomPanel;
	JPanel profilePanel;
	JTable jt;
	JScrollPane sp;
	
	JTable table;
        JFrame f;
	
	//static Object[][] departmentInfo;
	//static DefaultTableModel dptTableModel;
	
	
	
	static String loginID;
	
	
	
	public Accountant(String loginID){
		
                this.loginID = loginID;
		this.setTitle("Accountant");
		this.setSize(750,508);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
                this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		System.out.println("Check ADMIN DASH"+loginID);
		
	
		btn1 = new JButton("Dashboard");
		
		btn3 = new JButton("Doctor");
		btn8 = new JButton ("Room");
		btn9 = new JButton ("Profile");
		btn10 = new JButton ("Transaction");
                btn31 = new JButton("LOG OUT");
                btn11 = new JButton("Print");
		
		btn12 = new JButton ("Doctor List");

		btn21 = new JButton ("Room List");
	
                docNamelbl = new JLabel("Doctor Name");
                patientNamelbl = new JLabel ("Patient");
                medicineNamelbl = new JLabel("Medicine Name");
                
                docNametf = new JTextField();
                patientNametf  = new JTextField();
                medicineNametf = new JTextField();
                
                
                
                
                
                docNamelbl.setBounds(20,20,100,30); 
		patientNamelbl.setBounds(20,70,100,30); 
		medicineNamelbl.setBounds(20,120,200,30); 
		
		
		docNametf.setBounds(200,20,200,30);
		patientNametf.setBounds(200,70,200,30); 
		medicineNametf.setBounds(200,120,200,30); 
                
                
                
                JPanel transactionPanel = new JPanel();		
		transactionPanel.setLayout(null);
		transactionPanel.setBounds(189,5,1300,1000);
		transactionPanel.setBackground(new Color(190,141,216));
                
                
		
                
		JPanel profilePanel = new JPanel();		
		profilePanel.setLayout(null);
		profilePanel.setBounds(189,5,1300,1000);
		profilePanel.setBackground(new Color(190,141,216));
		
		table = new JTable();
		//profilePanel = new JPanel();
		
		JPanel doctorPanel = new JPanel();		
		doctorPanel.setLayout(null);
		doctorPanel.setBounds(189,5,1300,1000);
		doctorPanel.setBackground(new Color(190,141,216));
                
                JPanel doctorListPanel = new JPanel();		
		doctorListPanel.setLayout(null);
		doctorListPanel.setBounds(189,5,1300,1000);
		doctorListPanel.setBackground(new Color(190,141,216));
                
		JPanel roomPanel = new JPanel();		
		roomPanel.setLayout(null);
		roomPanel.setBounds(189,5,1300,1000);
		roomPanel.setBackground(new Color(190,141,216));
                
                
                
                
                
		btn1.setBackground(new Color(157,217,245)); //dashbrd
		
		btn3.setBackground(new Color(157,217,245));
		
		
		btn8.setBackground(new Color(157,217,245));
		btn9.setBackground(new Color(157,217,245));
                btn10.setBackground(new Color(157,217,245));
                btn31.setBackground(new Color(157,217,245));
		btn12.setBackground(new Color(157,217,245));   		//Doc.list button
		
		btn21.setBackground(new Color(157,217,245));   		//roomPanel btn
		
		
		btn1.setBounds(5,10,180,55);
		
		btn3.setBounds(5,60,180,55);
		
		
		btn8.setBounds(5,110,180,55);
		btn9.setBounds(5,210,180,55);
                btn10.setBounds(5,160,180,55);
                btn31.setBounds(5,260,180,55);
                btn11.setBounds(180,200,180,55);
		btn12.setBounds(13,10,180,55);
		btn21.setBounds(13,10,180,55);
		
		
                transactionPanel.add(docNamelbl);
                transactionPanel.add(patientNamelbl);
                transactionPanel.add(medicineNamelbl);
                transactionPanel.add(docNametf);
                transactionPanel.add(patientNametf);
                transactionPanel.add(medicineNametf);
                transactionPanel.add(btn11);
                
                
		this.add(btn1);
		this.add(btn3);
		this.add(btn8);
		this.add(btn9);
                this.add(btn10);
                this.add(btn31);

		
		doctorPanel.add(btn12);
		roomPanel.add(btn21);				 
		 btn1.addActionListener( new ActionListener(){		//Dashboard btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			Accountant a = new Accountant(loginID);
			a.setVisible(true);		
			}
			
		});
		
		btn3.addActionListener( new ActionListener(){		//Accountant btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			Accountant a = new Accountant(loginID);
			a.setVisible(true);
			a.add(doctorPanel);		
			}
			
		});
		
		
		btn8.addActionListener( new ActionListener(){		//room btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			Accountant a = new Accountant(loginID);
			a.add(roomPanel);
                        a.setVisible(true);
			}
			
		});
			
		btn9.addActionListener( new ActionListener(){		//profilePanel btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			Accountant a = new Accountant(loginID);
                        JTable table = new JTable();
                        //JScrollPane sp = new JScrollPane(table);
                       // sp.setBounds(10,20,700,80);
                       Color cl1 =new Color(190,141,216);
                        table.setOpaque(false);
                        table.setBackground(cl1);
                       
                       
			try {
			Connection dbcon = dbConnection.dbConnector(); 
			String query = "SELECT * FROM `loginsystem` WHERE `ID` = '"+loginID+"' ";
			PreparedStatement pt = dbcon.prepareStatement(query);
			ResultSet re = pt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(re));	
			
			
		} catch (Exception e) {

			System.out.println(e);
		}
                        table.setRowHeight(table.getRowHeight()+20);
			table.setAutoCreateRowSorter(true); 
                        
                        profilePanel.add(table, BorderLayout.CENTER);
                        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));
                        a.add(profilePanel);
                        a.setVisible(true);
                       
                       
			}
			
		});
                
                 btn12.addActionListener( new ActionListener(){		//doctor list
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			Accountant a = new Accountant(loginID);
                        JTable table = new JTable();
                        //JScrollPane sp = new JScrollPane(table);
                       // sp.setBounds(10,20,700,80);
                       
                        Color cl1 =new Color(190,141,216);
                        table.setOpaque(false);
                        table.setBackground(cl1);
                                
			try {
			Connection dbcon = dbConnection.dbConnector(); 
			String query = "SELECT * FROM `doctor`";
			PreparedStatement pt = dbcon.prepareStatement(query);
			ResultSet re = pt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(re));	
			
			
		} catch (Exception e) {

			System.out.println(e);
		}
                        
                        table.setRowHeight(table.getRowHeight()+20);
			table.setAutoCreateRowSorter(true); 
                        
                        doctorListPanel.add(table, BorderLayout.CENTER);
                        doctorListPanel.setLayout(new BoxLayout(doctorListPanel, BoxLayout.Y_AXIS));
                        a.add(doctorListPanel);
                        a.setVisible(true);
                        
                        
			}
			
		});
                 
                  btn21.addActionListener( new ActionListener(){		//doctor list
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			Accountant a = new Accountant(loginID);
                        JTable table = new JTable();
                        //JScrollPane sp = new JScrollPane(table);
                        
                        // sp.setBounds(10,20,700,80);
                         Color cl1 =new Color(190,141,216);
                        table.setOpaque(false);
                        table.setBackground(cl1);
			try {
			Connection dbcon = dbConnection.dbConnector(); 
			String query = "SELECT * FROM `room`";
			PreparedStatement pt = dbcon.prepareStatement(query);
			ResultSet re = pt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(re));	
			
			
		} catch (Exception e) {

			System.out.println(e);
		}
                        table.setRowHeight(table.getRowHeight()+20);
			table.setAutoCreateRowSorter(true); 
                        
                        roomPanel.add(table, BorderLayout.CENTER);
                        roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.Y_AXIS));
                        a.add(roomPanel);
                        a.setVisible(true);
                        
                        }
			
		});
                  
                  
                  btn10.addActionListener( new ActionListener(){		//room btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			Accountant a = new Accountant(loginID);
			a.add(transactionPanel);		
                        a.setVisible(true);
			}
			
		});
                  
                  
                  
                  btn11.addActionListener( new ActionListener(){		//Login
			
			
			public void actionPerformed(ActionEvent e){
				dispose();
					String docnameHold = docNametf.getText();
					String patientNameHold = patientNametf.getText();
                                        String medicineNameHold = medicineNametf.getText();
					
					
					
                                     if(docnameHold.equals ("") || patientNameHold.equals("") || medicineNameHold.equals("") )   
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
				boolean psflag1 = false;
                                boolean psflag2 = false;
                                boolean psflag3 = false;
				int rowCounter1 = 0;
                                int rowCounter2 = 0;
                                int rowCounter3 = 0;
				int docSalary = 0;
                                int docFee = 0;
                                int patientBal = 0;
                                int medicineFee = 0;
                                int totalpaid= 0;
				
				try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmds","root","");
			Statement stmt = con.createStatement();
                        
                        Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmds","root","");
			Statement stmt2 = con2.createStatement();
                        
                        Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmds","root","");
			Statement stmt3 = con3.createStatement();
                        
			//ResultSet rs = stmt.executeQuery("select * from loginsystem");
			
			ResultSet rs1 = stmt.executeQuery ("SELECT * FROM `doctor` WHERE `DoctorName` = '"+docnameHold+"'" );
			ResultSet rs2 = stmt2.executeQuery ("SELECT * FROM `patient` WHERE `PatientName` = '"+patientNameHold+"'" );
                        ResultSet rs3 = stmt3.executeQuery ("SELECT * FROM `medicine` WHERE `MedicineName` = '"+medicineNameHold+"'" );
                        
				while(rs1.next())
				{
				docSalary = rs1.getInt(10);
                                docFee = rs1.getInt(11);
				System.out.println("DOCTOR SALARY"+docSalary);
                                System.out.println("DOCTOR SALARY"+docFee);
					
				rowCounter1++;
				}
				System.out.println("Doctor ROW: " +rowCounter1);
		
				if (rowCounter1 > 0)
				{
                                    
				System.out.println("Docotor MATCH");
                                psflag1 = true;
         
                                }
                                
                                else
				{
				JOptionPane.showMessageDialog(null,"Invalid Doctor");
				}
                                
                                
                                
                                while(rs2.next())           //patient info
				{
				patientBal = rs2.getInt(13);
                                
                                System.out.println("Patient bal"+patientBal);
					
				rowCounter2++;
				}
				System.out.println("Patient ROW: " +rowCounter2);
		
				if (rowCounter2 > 0)
				{
                                    
				System.out.println("Patient MATCH");
                                psflag2 = true;
         
                                }
                                
                                else
				{
				JOptionPane.showMessageDialog(null,"Invalid Patient");
				}
                                
                                
                                
                                while(rs3.next())
				{
				medicineFee = rs3.getInt(3);
                                
                                System.out.println("Medicine Fee"+medicineFee);
					
				rowCounter3++;
				}
				System.out.println("ROW Medicine: " +rowCounter3);
		
				if (rowCounter3 > 0)
				{
                                    
				System.out.println("Medicine  MATCH");
                                psflag3 = true;
         
                                }
                                
                                else
				{
				JOptionPane.showMessageDialog(null,"Invalid Medicine");
				}
                                
                                totalpaid=docFee+medicineFee;
                                
                                if (psflag1 && psflag2 && psflag3)
                                {
                                    
                                    String sql1= "UPDATE `patient` SET `Balance` = Balance - "+docFee+" - "+medicineFee+"  WHERE `patient`.`PatientName` = '"+patientNameHold+"'";
                                    String sql2= "UPDATE `doctor` SET `Salary` = Salary + "+docFee+"  WHERE `doctor`.`DoctorName` = '"+docnameHold+"' ";
                                    int a = stmt.executeUpdate(sql1);
                                    int b = stmt.executeUpdate(sql2);
                                    
                                    if (a!=0 || b!=0)
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
                con2.close();
                con3.close();
		
			}
			catch(Exception ex){
			System.out.println(ex);
			}
		 //PRINTING:::::::::::::::::::::::::::::::::
                 Document document = new Document();
       try {
           
          PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Invoice of "+patientNameHold+".pdf"));
           document.open();
          
           document.add(new Paragraph("Pabna Alfa Medical Care"));
           document.add(new Paragraph(""));
           document.add(new Paragraph(""));
           document.add(new Paragraph(""));
           
           //PdfPTable table = new PdfPTable(3);
           //table.setWidthPercentage(105);
           //table.setSpacingBefore(11f);
           //table.setSpacingAfter(11f);
           
           //float [] colWidth = {2f,2f,2f};
          // table.setWidths(colWidth);
           
            document.add(new Paragraph("Patient Name: "+patientNameHold));
           document.add(new Paragraph(""));
           document.add(new Paragraph(""));
           document.add(new Paragraph(""));
           document.add(new Paragraph(""));
           document.add(new Paragraph(""));
           document.add(new Paragraph(""));
           
           document.add(new Paragraph(""));
           document.add(new Paragraph(""));
           document.add(new Paragraph(""));
           
          // PdfPCell c1 = new PdfPCell(new Paragraph("Doctor Name"));
           //PdfPCell c2 = new PdfPCell (new Paragraph("Doctor Fee"));
           //PdfPCell c3 = new PdfPCell (new Paragraph("Medicine Name"));
           //PdfPCell c4 = new PdfPCell (new Paragraph("Medicine Fee"));
           
           
           
           
           
           
           
          // table.addCell(c1);
           //table.addCell(c2);
           //table.addCell(c3);
           //table.addCell(c4);
           
           //document.add(table);
           
           
           document.add(new Paragraph("Doctor Name: "+docnameHold));
           document.add(new Paragraph("Doctor Fee: "+docFee));
          document.add(new Paragraph("Medicine Name: "+medicineNameHold));
          document.add(new Paragraph("Medicine Fee"+medicineFee));
           
          document.add(new Paragraph(""));
           document.add(new Paragraph(""));
           document.add(new Paragraph(""));
           
           
           document.add(new Paragraph(""));
           document.add(new Paragraph(""));
           document.add(new Paragraph(""));
           document.add(new Paragraph("Total Paid: "+totalpaid));
           
           
           document.close();
           writer.close();
       }
       catch (Exception e1)
       {
           System.out.println(e1);
       }
			
             
                                     }
			}
			}			
			 );
                  
                  
                  btn31.addActionListener( new ActionListener(){		//Dashboard btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			PasswordSysGui a = new PasswordSysGui();
                                        a.setVisible(true);		
			}
			
		});
                  
                  

		   }	}	 
      /*  public static void main(String [] args)
        {
		Accountant a = new Accountant(loginID);
		a.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//a.setUndecorated(true);
		a.setVisible(true);
		}  
    */

