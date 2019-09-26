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
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.table.*;



class AdminDash extends JFrame{
	
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	JButton btn6;
	JButton btn7;
	JButton btn8;
	JButton btn9;
	JButton btn10;  //DepartmentList
	JButton btn11;  // Add department
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
        JButton btn27; //Update dpt
        JButton btn28; //Delect dot
        JButton btn29; //Update save dpt
        JButton btn30; // delect save dpt
	JButton btn31; // delect save dpt
	
	JLabel addDepartmentlbl;
	JLabel deptDescriptionlbl;
        JLabel upDepartmentlbl;
        JLabel upDescriptionlbl;
        JLabel nameDepartmentlbl;
        JLabel departmentDlctlbl;
        
        
        JTextField addDepartmenttf;
	JTextField deptDescriptiontf;
        JTextField upDepartmenttf;
	JTextField upDescriptiontf;
        JTextField nameDepartmenttf;
	JTextField departmentDlcttf;
        
	String addDepartmentHold=null;
	String deptDescriptionHold=null;
        String upDepartmentHold=null;
	String upDescriptionHold=null;
        String nameDepartmentHold =null;
        String dlctDptHold = null;
	
	JLabel doctIdlbl;
	JLabel docUsernamelbl;
	JLabel docNamelbl;
	JLabel docAddrslbl;
	JLabel docEmaillbl;
	JLabel docPhonelbl;
	JLabel docDptNamelbl;
	JLabel docGenderlbl;
	JLabel docAgelbl;

	JTextField doctIdtf;
	JTextField docUsernametf;
	JTextField docNametf;
	JTextField docAddrstf;
	JTextField docEmailtf;
	JTextField docPhonetf;
	JTextField docDptNametf;
	JTextField docGendertf;
	JTextField docAgetf;
	
	String doctIdHold=null;
	String docUsernameHold=null;
	String docNameHold=null;
	String docAddrsHold=null;
	String docEmailHold=null;
	String docPhoneHold=null;
	String docDptNameHold=null;
	String docGenderHold=null;
	String docAgeHold=null;
	
	JLabel acntIdlbl;
	JLabel acntUsernamelbl;
	JLabel acntNamelbl;
	JLabel acntPhonelbl;
	
	JTextField acntIdtf;
	JTextField acntUsernametf;
	JTextField acntNametf;
	JTextField acntPhonetf;
	
	String acntIdHold=null;
	String acntUsernameHold=null;
	String acntNameHold=null;
	String acntPhoneHold=null;
	
	JLabel rcptIdlbl;
	JLabel rcptUsernamelbl;
	JLabel rcptNamelbl;
	JLabel rcptPhonelbl;
	
	JTextField rcptIdtf;
	JTextField rcptUsernametf;
	JTextField rcptNametf;
	JTextField rcptPhonetf;
	
	String rcptIdHold=null;
	String rcptUsernameHold=null;
	String rcptNameHold=null;
	String rcptPhoneHold=null;
	
	
	
	
	
	JPanel departmentPanel;
	JPanel departmentAddPanel;
	JPanel doctorPanel;
	JPanel doctorAddPanel;
	JPanel patientPanel;
	JPanel employeePanel;
	JPanel accountantPanel;
	JPanel accountantAddPanel;
	JPanel receptionistAddPanel;
	JPanel receptionistPanel;
	JPanel roomPanel;
	JPanel profilePanel;
	JTable jt;
	JScrollPane sp;
	
	JTable table;
       	
	//static Object[][] departmentInfo;
	//static DefaultTableModel dptTableModel;
	
	
        static AdminDash a;
	static String loginID;
        JFrame departmentFrame;
	
	
	
	public AdminDash(String loginID){
		
                this.loginID = loginID;
		this.setTitle("Admin");
		this.setSize(750,508);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
                this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		System.out.println("Check ADMIN DASH" +loginID);
                addAdmincomponent(a);
        }
                
                
                public void addAdmincomponent(AdminDash a) {
                    this.a = a;
                btn1 = new JButton("Dashboard");
		btn2 = new JButton("Department");
		btn3 = new JButton("Doctor");
		btn4 = new JButton("Patient");
		btn6 = new JButton ("Accountant");
		btn7 = new JButton ("Receptionist");
		btn8 = new JButton ("Room");
		btn9 = new JButton ("Profile");
		btn10 = new JButton ("Department List");
		btn11 = new JButton ("Add Department");
		btn12 = new JButton ("Doctor List");
		btn13 = new JButton ("Add Doctor");
		btn14 = new JButton ("Patient List");
		btn17 = new JButton ("Accountant List");
		btn18 = new JButton ("Add Accountant");
		btn19 = new JButton ("Receptionist List");
		btn20 = new JButton ("Add Receptionist");
		btn21 = new JButton ("Room List");
                btn23 = new JButton ("Save");				//dpt save
		btn24 = new JButton ("Save");			//doc save
		btn25 = new JButton ("Save");			//accountant save
		btn26 = new JButton ("Save");			//receptionist save
                btn27 = new JButton ("Update Department");
                btn28 = new JButton ("Delect Department");
                btn29 = new JButton ("Save");			//accountant save
		btn30 = new JButton ("Delect");	
		btn31 = new JButton ("LOG OUT");	
		addDepartmentlbl = new JLabel("Name");
		deptDescriptionlbl =  new JLabel("Description");
		addDepartmenttf = new JTextField();
		deptDescriptiontf = new JTextField();
                
                upDepartmentlbl = new JLabel("Name");
		upDescriptionlbl =  new JLabel("Description");
		upDepartmenttf = new JTextField();
		upDescriptiontf = new JTextField();
                nameDepartmentlbl = new JLabel("Which Name");
                nameDepartmenttf = new JTextField();
                departmentDlctlbl = new JLabel("Dept. Name");
                departmentDlcttf = new  JTextField();
                
                
		
		doctIdlbl = new JLabel("ID");
		docUsernamelbl = new JLabel("UserName");
		docNamelbl = new JLabel("Name");
		docAddrslbl = new JLabel("Address");
		docEmaillbl = new JLabel("Email");
		docPhonelbl = new JLabel("Phone");
		docDptNamelbl = new JLabel("Department Name");
		docGenderlbl = new JLabel("Gender");
		docAgelbl  = new JLabel("Age");
		
		doctIdtf = new JTextField();
		docUsernametf = new JTextField();
		docNametf = new JTextField();
		docAddrstf = new JTextField();
		docEmailtf = new JTextField();
		docPhonetf = new JTextField();
		docDptNametf = new JTextField();
		docGendertf = new JTextField();
		docAgetf  = new JTextField();
		
		acntIdlbl = new JLabel("ID");
		acntUsernamelbl = new JLabel("UserName");
		acntNamelbl = new JLabel("Name");
		acntPhonelbl = new JLabel("Phone");
		
		acntIdtf = new JTextField();
		acntUsernametf = new JTextField();
		acntNametf = new JTextField();
		acntPhonetf = new JTextField();
		
		rcptIdlbl = new JLabel("ID");
		rcptUsernamelbl = new JLabel("UserName");
		rcptNamelbl = new JLabel("Name");
		rcptPhonelbl = new JLabel("Phone");
		
		rcptIdtf = new JTextField();
		rcptUsernametf = new JTextField();
		rcptNametf = new JTextField();
		rcptPhonetf = new JTextField();	
		
                JPanel mainPanel = new JPanel();		
		mainPanel.setLayout(null);
		mainPanel.setBounds(189,5,1300,1000);
		mainPanel.setBackground(new Color(60, 183, 0));
                
                 
                
                
                
		JPanel profilePanel = new JPanel();		
		profilePanel.setLayout(null);
		profilePanel.setBounds(189,5,1300,1000);
		profilePanel.setBackground(new Color(60, 183, 0));
		
		table = new JTable();
		//profilePanel = new JPanel();

		JPanel doctorPanel = new JPanel();		
		doctorPanel.setLayout(null);
		doctorPanel.setBounds(189,5,1300,1000);
		doctorPanel.setBackground(new Color(60, 183, 0));
                
                JPanel doctorListPanel = new JPanel();		
		doctorListPanel.setLayout(null);
		doctorListPanel.setBounds(189,5,1300,1000);
		doctorListPanel.setBackground(new Color(60, 183, 0));
                
		
		JPanel doctorAddPanel = new JPanel();		
		doctorAddPanel.setLayout(null);
		doctorAddPanel.setBounds(189,5,1300,1000);
		doctorAddPanel.setBackground(new Color(60, 183, 0));
		
		JPanel patientPanel = new JPanel();		
		patientPanel.setLayout(null);
		patientPanel.setBounds(189,5,1300,1000);
		patientPanel.setBackground(new Color(60, 183, 0));
                
                JPanel patientListPanel = new JPanel();		
		patientListPanel.setLayout(null);
		patientListPanel.setBounds(189,5,1300,1000);
		patientListPanel.setBackground(new Color(60, 183, 0));
		
		JPanel accountantPanel = new JPanel();		
		accountantPanel.setLayout(null);
		accountantPanel.setBounds(189,5,1300,1000);
		accountantPanel.setBackground(new Color(60, 183, 0));
                
		JPanel accountantListPanel = new JPanel();		
		accountantListPanel.setLayout(null);
		accountantListPanel.setBounds(189,5,1300,1000);
		accountantListPanel.setBackground(new Color(60, 183, 0));
                
		JPanel accountantAddPanel = new JPanel();		
		accountantAddPanel.setLayout(null);
		accountantAddPanel.setBounds(189,5,1300,1000);
		accountantAddPanel.setBackground(new Color(60, 183, 0));
		
		JPanel receptionistPanel = new JPanel();		
		receptionistPanel.setLayout(null);
		receptionistPanel.setBounds(189,5,1300,1000);
		receptionistPanel.setBackground(new Color(60, 183, 0));
                
                JPanel receptionistListPanel = new JPanel();		
		receptionistListPanel.setLayout(null);
		receptionistListPanel.setBounds(189,5,1300,1000);
		receptionistListPanel.setBackground(new Color(60, 183, 0));
                
		
		JPanel receptionistAddPanel = new JPanel();		
		receptionistAddPanel.setLayout(null);
		receptionistAddPanel.setBounds(189,5,1300,1000);
		receptionistAddPanel.setBackground(new Color(60, 183, 0));

		JPanel roomPanel = new JPanel();		
		roomPanel.setLayout(null);
		roomPanel.setBounds(189,5,1300,1000);
		roomPanel.setBackground(new Color(60, 183, 0));
		
		
		
		
		btn1.setBackground(new Color(157,217,245)); //dashbrd
		btn2.setBackground(new Color(157,217,245)); //
		btn3.setBackground(new Color(157,217,245));
		btn4.setBackground(new Color(157,217,245));
		btn6.setBackground(new Color(157,217,245));
		btn7.setBackground(new Color(157,217,245));
		btn8.setBackground(new Color(157,217,245));
		btn9.setBackground(new Color(157,217,245));
		btn10.setBackground(new Color(157,217,245));   		//Dept.panel button
		btn11.setBackground(new Color(157,217,245));		//Dept.panel button
		btn12.setBackground(new Color(157,217,245));   		//Doc.list button
		btn13.setBackground(new Color(157,217,245));		//add doctor button
		btn14.setBackground(new Color(157,217,245));		//Patient panel button
		btn17.setBackground(new Color(157,217,245));   		//accountant list.panel button
		btn18.setBackground(new Color(157,217,245));		//accountant add button
		btn19.setBackground(new Color(157,217,245));   		//receptionist list.panel button
		btn20.setBackground(new Color(157,217,245));		//receptionist add button
		btn21.setBackground(new Color(157,217,245));   		//roomPanel btn
		btn23.setBackground(new Color(157,217,245));		//add deptDescriptionHold
		btn24.setBackground(new Color(157,217,245));
		btn25.setBackground(new Color(157,217,245));
		btn26.setBackground(new Color(157,217,245));
		btn27.setBackground(new Color(157,217,245)); // updt dpt   
                btn28.setBackground(new Color(157,217,245)); //delect dpt
		btn29.setBackground(new Color(157,217,245)); // save updat dpt
		btn30.setBackground(new Color(157,217,245)); // save update dpt
		btn31.setBackground(new Color(157,217,245)); // save update dpt
                
                btn1.setBounds(5,10,180,55);
		btn2.setBounds(5,60,180,55);
		btn3.setBounds(5,110,180,55);
		btn4.setBounds(5,160,180,55);
		btn6.setBounds(5,210,180,55);
		btn7.setBounds(5,260,180,55);
		btn8.setBounds(5,310,180,55);
		btn9.setBounds(5,360,180,55);      //upto frm btn
		btn10.setBounds(13,10,180,55);		//
		btn11.setBounds(193,10,180,55);
		btn12.setBounds(13,10,180,55);
		btn13.setBounds(193,10,180,55);
		btn14.setBounds(13,10,180,55);
		btn17.setBounds(13,10,180,55);
		btn18.setBounds(193,10,180,55);
		btn19.setBounds(13,10,180,55);
		btn20.setBounds(193,10,180,55);
		btn21.setBounds(13,10,180,55);
		btn23.setBounds(230,250,80,50); //add dept
		btn24.setBounds(350,380,80,50); //add accountant`
		btn25.setBounds(230,250,80,50); //add doc
		btn26.setBounds(230,250,80,50); //add Receptionist
		btn27.setBounds(373,10,180,55);		//update dpt
		btn28.setBounds(553,10,180,55);         //dlct dpt
                btn29.setBounds(300,250,80,50);     //save update
                btn30.setBounds(200, 250, 80, 50);
                btn31.setBounds(5,410, 180, 50);
                
		addDepartmentlbl.setBounds(20,50,100,30);
		deptDescriptionlbl.setBounds(20,150,100,30);
		addDepartmenttf.setBounds(100,50,200,30);
		deptDescriptiontf.setBounds(100,150,200,50);
                
                nameDepartmentlbl.setBounds(20,50,100,30);
                upDepartmentlbl.setBounds(20,150,100,30);
		upDescriptionlbl.setBounds(20,250,100,30);
                departmentDlctlbl.setBounds(20,50,100,30);
               
                
		nameDepartmenttf.setBounds(100,50,200,30);
                upDepartmenttf.setBounds(100,150,200,50);
		upDescriptiontf.setBounds(100,250,200,50);
                departmentDlcttf.setBounds(120,50,200,30);
                
                
                
		
		doctIdlbl.setBounds(20,20,100,30); 
		docUsernamelbl.setBounds(20,70,100,30); 
		docNamelbl.setBounds(20,120,200,30); 
		docAddrslbl.setBounds(20,170,100,30); 
		docEmaillbl.setBounds(20,220,100,30); 
		docPhonelbl.setBounds(20,270,100,30); 
		docDptNamelbl.setBounds(20,320,100,30); 
		docGenderlbl.setBounds(20,370,100,30); 
		docAgelbl.setBounds(20,420,100,30);
		
		doctIdtf.setBounds(100,20,200,30);
		docUsernametf.setBounds(100,70,200,30); 
		docNametf.setBounds(100,120,200,30); 
		docAddrstf.setBounds(100,170,200,30); 
		docEmailtf.setBounds(100,220,200,30); 
		docPhonetf.setBounds(100,270,200,30); 
		docDptNametf.setBounds(100,320,200,30);
		docGendertf.setBounds(100,370,200,30); 
		docAgetf.setBounds(100,420,200,30);	
		
		acntIdlbl.setBounds(20,20,100,30); 
		acntUsernamelbl.setBounds(20,70,100,30); 
		acntNamelbl.setBounds(20,120,200,30);
		acntPhonelbl.setBounds(20,170,100,30);
		
		acntIdtf.setBounds(100,20,200,30);
		acntUsernametf.setBounds(100,70,200,30); 
		acntNametf.setBounds(100,120,200,30);
		acntPhonetf.setBounds(100,170,200,30); 
		
		rcptIdlbl.setBounds(20,20,100,30); 
		rcptUsernamelbl.setBounds(20,70,100,30); 
		rcptNamelbl.setBounds(20,120,200,30);
		rcptPhonelbl.setBounds(20,170,100,30);
		
		rcptIdtf.setBounds(100,20,200,30);
		rcptUsernametf.setBounds(100,70,200,30); 
		rcptNametf.setBounds(100,120,200,30);
		rcptPhonetf.setBounds(100,170,200,30);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn6);
		this.add(btn7);
		this.add(btn8);
		this.add(btn9);
                this.add(btn31);
		
		
		
                JPanel departmentPanel = new JPanel();		
                        departmentPanel.setLayout(null);
                        departmentPanel.setBounds(189,5,1300,1000);
                        departmentPanel.setBackground(new Color(60, 183, 0));
                        departmentPanel.add(btn10);
                        departmentPanel.add(btn11);
                        departmentPanel.add(btn27);
                        departmentPanel.add(btn28);
                        
                        
                JPanel departmentAddPanel = new JPanel();		
                       departmentAddPanel.setLayout(null);
                       departmentAddPanel.setBounds(189,5,1300,1000);
                       departmentAddPanel.setBackground(new Color(60, 183, 0));
                       departmentAddPanel.add(addDepartmentlbl);
                       departmentAddPanel.add(deptDescriptionlbl);
                       departmentAddPanel.add(addDepartmenttf);
                       departmentAddPanel.add(deptDescriptiontf);
                       departmentAddPanel.add(btn23);
                 
                JPanel departmentUpdatePanel = new JPanel();		
                       departmentUpdatePanel.setLayout(null);
                       departmentUpdatePanel.setBounds(189,5,1300,1000);
                        departmentUpdatePanel.setBackground(new Color(60, 183, 0));      
                       departmentUpdatePanel.add(upDepartmentlbl);
                       departmentUpdatePanel.add(upDescriptionlbl);
                       departmentUpdatePanel.add(upDepartmenttf);
                       departmentUpdatePanel.add(upDescriptiontf);
                       departmentUpdatePanel.add(nameDepartmentlbl);
                       departmentUpdatePanel.add(nameDepartmenttf);
                       departmentUpdatePanel.add(btn29);
                       
                JPanel departmentDelectPanel = new JPanel();		
                       departmentDelectPanel.setLayout(null);
                       departmentDelectPanel.setBounds(189,5,1300,1000);
                       departmentDelectPanel.setBackground(new Color(60, 183, 0));      
                       departmentDelectPanel.add(departmentDlctlbl);
                       departmentDelectPanel.add(departmentDlcttf);
                       departmentDelectPanel.add(btn30);
                       
                       
                
                
                        
                JPanel departmentListPanel = new JPanel();		
                        departmentListPanel.setLayout(null);
                        departmentListPanel.setBounds(189,5,1300,1000);
                        departmentListPanel.setBackground(new Color(60, 183, 0));
                        
                        
                        
                
		
		
		
		
		doctorAddPanel.add(doctIdlbl);
		doctorAddPanel.add(docUsernamelbl);
		doctorAddPanel.add(docNamelbl);
		doctorAddPanel.add(docAddrslbl);
		doctorAddPanel.add(docEmaillbl);
		doctorAddPanel.add(docPhonelbl);
		doctorAddPanel.add(docDptNamelbl);
		doctorAddPanel.add(docGenderlbl);
		doctorAddPanel.add(docAgelbl);
		doctorAddPanel.add(doctIdtf);
		doctorAddPanel.add(docUsernametf);
		doctorAddPanel.add(docNametf);
		doctorAddPanel.add(docAddrstf);
		doctorAddPanel.add(docEmailtf);
		doctorAddPanel.add(docPhonetf);
		doctorAddPanel.add(docDptNametf);
		doctorAddPanel.add(docGendertf);
		doctorAddPanel.add(docAgetf);
		doctorAddPanel.add(btn24);
		
		
		doctorPanel.add(btn12);
		doctorPanel.add(btn13);
		
		patientPanel.add(btn14);
               
		accountantPanel.add(btn17);
		accountantPanel.add(btn18);
		
		accountantAddPanel.add(acntIdlbl);
		accountantAddPanel.add(acntUsernamelbl);
		accountantAddPanel.add(acntNamelbl);
		accountantAddPanel.add(acntPhonelbl);
		accountantAddPanel.add(acntIdtf);
		accountantAddPanel.add(acntUsernametf);
		accountantAddPanel.add(acntNametf);
		accountantAddPanel.add(acntPhonetf);
		accountantAddPanel.add(btn25);
		
		receptionistPanel.add(btn19);
		receptionistPanel.add(btn20);
		
		receptionistAddPanel.add(rcptIdlbl);
		receptionistAddPanel.add(rcptUsernamelbl);
		receptionistAddPanel.add(rcptNamelbl);
		receptionistAddPanel.add(rcptPhonelbl);
		receptionistAddPanel.add(rcptIdtf);
		receptionistAddPanel.add(rcptUsernametf);
		receptionistAddPanel.add(rcptNametf);
		receptionistAddPanel.add(rcptPhonetf);
		receptionistAddPanel.add(btn26);
		roomPanel.add(btn21);				 
		 btn1.addActionListener( new ActionListener(){		//Dashboard btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);
			a.setVisible(true);		
			}
			
		});
		
		btn2.addActionListener( new ActionListener(){		//departmentPanel btn
			
		
			public void actionPerformed(ActionEvent e1){
                            dispose();
                        AdminDash a = new AdminDash(loginID);
                        a.add(departmentPanel);
                        a.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                        a.setVisible(true);
			}
			
		});
		
		btn3.addActionListener( new ActionListener(){		//Doctor btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);
			a.setVisible(true);
			a.add(doctorPanel);		
			}
			
		});
		
		btn4.addActionListener( new ActionListener(){		//Patient btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);
			a.setVisible(true);
			a.add(patientPanel);		
			}
			
		});	
		btn6.addActionListener( new ActionListener(){		//accountant btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);
			a.setVisible(true);
			a.add(accountantPanel);		
			}
			
		});
		
		btn7.addActionListener( new ActionListener(){		//accountant btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);
			a.setVisible(true);
			a.add(receptionistPanel);		
			}
			
		});
		
		btn8.addActionListener( new ActionListener(){		//room btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);
			a.setVisible(true);
			a.add(roomPanel);		
			}
			
		});
		
		btn9.addActionListener( new ActionListener(){		//profilePanel btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);
                        JTable table = new JTable();
                        JScrollPane sp = new JScrollPane(table);
                       // sp.setBounds(10,20,700,80);
			try {
			Connection dbcon = dbConnection.dbConnector(); 
			String query = "SELECT * FROM `loginsystem` WHERE `ID` = '"+loginID+"' ";
			PreparedStatement pt = dbcon.prepareStatement(query);
			ResultSet re = pt.executeQuery();
                        Color green =new Color(60, 183, 0);
                        table.setOpaque(false);
                        table.setBackground(green);
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
		
		 btn10.addActionListener( new ActionListener(){		//profilePanel btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);
                        JTable table = new JTable();
                        Color green =new Color(60, 183, 0);
                        table.setOpaque(false);
                        table.setBackground(green);
      
			try {
			Connection dbcon = dbConnection.dbConnector(); 
			String query = "SELECT * FROM `department`";
			PreparedStatement pt = dbcon.prepareStatement(query);
			ResultSet re = pt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(re));	
			
			
		} catch (Exception e) {

			System.out.println(e);
		}
                        table.setRowHeight(table.getRowHeight()+20);
			table.setAutoCreateRowSorter(true);
			TableColumnModel columnModel = table.getColumnModel();
                       //columnModel.getColumn(0).setPreferredWidth(50);
                       //columnModel.getColumn(1).setPreferredWidth(150);
                        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
                        table.getColumnModel().getColumn(0).setMinWidth(25);
                        table.getColumnModel().getColumn(1).setMinWidth(25);
                        table.getColumnModel().getColumn(0).setMaxWidth(Integer.MAX_VALUE);
                        
                      
                        
                        

                       departmentListPanel.add(table, BorderLayout.CENTER);
                        departmentListPanel.setLayout(new BoxLayout(departmentListPanel, BoxLayout.Y_AXIS));
                        a.add(departmentListPanel);
                        a.setVisible(true);
                       
                        
                        
			}
			
		});


		btn11.addActionListener( new ActionListener(){		//add department btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);	
			a.add(departmentAddPanel);
			a.setVisible(true);
			}
			});
                
                 btn12.addActionListener( new ActionListener(){		//doctor list
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);
                        JTable table = new JTable();
                        //JScrollPane sp = new JScrollPane(table);
                       // sp.setBounds(10,20,700,80);
			try {
			Connection dbcon = dbConnection.dbConnector(); 
			String query = "SELECT * FROM `doctor`";
			PreparedStatement pt = dbcon.prepareStatement(query);
			ResultSet re = pt.executeQuery();
                        
                        Color green =new Color(60, 183, 0);
                        table.setOpaque(false);
                        table.setBackground(green);
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
                 
                  btn14.addActionListener( new ActionListener(){		//doctor list
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);
                        JTable table = new JTable();
                       // JScrollPane sp = new JScrollPane(table);
                       // sp.setBounds(10,20,700,80);
			try {
			Connection dbcon = dbConnection.dbConnector(); 
			String query = "SELECT * FROM `patient`";
			PreparedStatement pt = dbcon.prepareStatement(query);
			ResultSet re = pt.executeQuery();
                        Color green =new Color(60, 183, 0);
                        table.setOpaque(false);
                        table.setBackground(green);
			table.setModel(DbUtils.resultSetToTableModel(re));	
			
			
		} catch (Exception e) {

			System.out.println(e);
		}
                       
                        table.setRowHeight(table.getRowHeight()+20);
			table.setAutoCreateRowSorter(true); 
                        
                        patientListPanel.add(table, BorderLayout.CENTER);
                        patientListPanel.setLayout(new BoxLayout(patientListPanel, BoxLayout.Y_AXIS));
                        a.add(patientListPanel);
                        a.setVisible(true);

			}
			
		});
                  
                  btn19.addActionListener( new ActionListener(){		//doctor list
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);
                        JTable table = new JTable();
                        JScrollPane sp = new JScrollPane(table);
                       // sp.setBounds(10,20,700,80);
			try {
			Connection dbcon = dbConnection.dbConnector(); 
			String query = "SELECT * FROM `receptionist`";
			PreparedStatement pt = dbcon.prepareStatement(query);
			ResultSet re = pt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(re));
                        Color green =new Color(60, 183, 0);
                        table.setOpaque(false);
                        table.setBackground(green);
			
			
		} catch (Exception e) {

			System.out.println(e);
		}
                       
                        table.setRowHeight(table.getRowHeight()+20);
			table.setAutoCreateRowSorter(true); 
                        
                        receptionistListPanel.add(table, BorderLayout.CENTER);
                        receptionistListPanel.setLayout(new BoxLayout(receptionistListPanel, BoxLayout.Y_AXIS));
                        a.add(receptionistListPanel);
                        a.setVisible(true);
                    
			}
			
		});
                  
                   btn17.addActionListener( new ActionListener(){		//doctor list
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);
                        JTable table = new JTable();
                        JScrollPane sp = new JScrollPane(table);
                       // sp.setBounds(10,20,700,80);
			try {
			Connection dbcon = dbConnection.dbConnector(); 
			String query = "SELECT * FROM `accountant`";
			PreparedStatement pt = dbcon.prepareStatement(query);
			ResultSet re = pt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(re));
                        Color green =new Color(60, 183, 0);
                        table.setOpaque(false);
                        table.setBackground(green);
			
			
		} catch (Exception e) {

			System.out.println(e);
		}
                        table.setRowHeight(table.getRowHeight()+20);
			table.setAutoCreateRowSorter(true); 
                        
                        accountantListPanel.add(table, BorderLayout.CENTER);
                        accountantListPanel.setLayout(new BoxLayout(accountantListPanel, BoxLayout.Y_AXIS));
                        a.add(accountantListPanel);
                        a.setVisible(true);
                    
			}
			
		});
                 
                    btn21.addActionListener( new ActionListener(){		//doctor list
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);
                        JTable table = new JTable();
                        JScrollPane sp = new JScrollPane(table);
                       // sp.setBounds(10,20,700,80);
			try {
			Connection dbcon = dbConnection.dbConnector(); 
			String query = "SELECT * FROM `room`";
			PreparedStatement pt = dbcon.prepareStatement(query);
			ResultSet re = pt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(re));
                        Color green =new Color(60, 183, 0);
                        table.setOpaque(false);
                        table.setBackground(green);
			
			
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
                 
                
                
                
                
                
		btn23.addActionListener( new ActionListener(){		//add department btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			
			addDepartmentHold = addDepartmenttf.getText();
			deptDescriptionHold = deptDescriptiontf.getText();
			System.out.println("Check value of addDepartmentHold" +addDepartmentHold);
			if((addDepartmentHold.equals("") )||(deptDescriptionHold.equals("")))
			{
				JOptionPane.showMessageDialog(null,"Invalid Input!!");
			}
			else  {
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmds","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from department");
			String sql= "INSERT INTO `department` (`DepartmentName`, `DepartmentDescription`) VALUES ('"+addDepartmentHold+"', '"+deptDescriptionHold+"')";
			int a = stmt.executeUpdate(sql);
			if (a!=0)
			{
				JOptionPane.showMessageDialog(null,"Successfully Inserted!!");
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"Failed!!");
			}
			
			while(rs.next())
			{
			System.out.println(rs.getString(1)); //+"  "+rs.getInt(2)+"  "+rs.getString(3));
			}
			con.close();
			}
			catch(Exception e)
			{
			System.out.println(e);
			}
			
			}
			}
			
		});
		
			btn13.addActionListener( new ActionListener(){		//add department btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);	
			a.add(doctorAddPanel);
                        a.setExtendedState(JFrame.MAXIMIZED_BOTH);
			a.setVisible(true);
			}
			});
			
			
			
			btn24.addActionListener( new ActionListener(){		//add department btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
						
			doctIdHold = doctIdtf.getText(); 
			docUsernameHold = docUsernametf.getText();
			docNameHold = docNametf.getText(); 
			docAddrsHold = docAddrstf.getText(); 
			docEmailHold = docEmailtf.getText(); 
			docPhoneHold = docPhonetf.getText(); 
			docDptNameHold = docDptNametf.getText(); 
			docGenderHold = docGendertf.getText();
			docAgeHold = docAgetf.getText();
			
			
			//System.out.println("Check value of addDepartmentHold" +addDepartmentHold);
			if((doctIdHold.equals("") )||(docUsernameHold.equals("")))
			{
				JOptionPane.showMessageDialog(null,"Invalid Input!!");
			}
			else  {
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmds","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from doctor");
			String sql= "INSERT INTO `doctor` (`ID`, `Username`, `DoctorName`, `DoctorAddress`, `DoctorEmail`, `DoctorPhone`, `DoctorDepartmentName`, `DoctorGender`, `DoctorAge`) VALUES ('"+doctIdHold+"', '"+docUsernameHold+"', '"+docNameHold+"', '"+docAddrsHold+"', '"+docEmailHold+"', '"+docPhoneHold+"', '"+docDptNameHold+"', '"+docGenderHold+"', '"+docAgeHold+"')";
			int a = stmt.executeUpdate(sql);
			if (a!=0)
			{
				JOptionPane.showMessageDialog(null,"Successfully Inserted!!");
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"Failed!!");
			}
			
			while(rs.next())
			{
			System.out.println(rs.getString(1)); //+"  "+rs.getInt(2)+"  "+rs.getString(3));
			}
			con.close();
			}
			catch(Exception e)
			{
			System.out.println(e);
			}
			
			}
			}
		});
		
		btn18.addActionListener( new ActionListener(){		//add department btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);	
			a.add(accountantAddPanel);
                        a.setExtendedState(JFrame.MAXIMIZED_BOTH);
			a.setVisible(true);
			}
			});
		
		btn25.addActionListener( new ActionListener(){		//add acntnt btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			
			
			acntIdHold = acntIdtf.getText(); 
			acntUsernameHold = acntUsernametf.getText();
			acntNameHold = acntNametf.getText(); 
			acntPhoneHold = acntPhonetf.getText(); 
			
			
			//System.out.println("Check value of addDepartmentHold" +addDepartmentHold);
			if((acntIdHold.equals("") )||(acntUsernameHold.equals("")))
			{
				JOptionPane.showMessageDialog(null,"Invalid Input!!");
			}
			else  {
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmds","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from doctor");
			String sql= "INSERT INTO `accountant` (`ID`, `Username`, `AccountantName`, `AccountantPhone`) VALUES ('"+acntIdHold+"', '"+acntUsernameHold+"', '"+acntNameHold+"', '"+acntPhoneHold+"')";
			int a = stmt.executeUpdate(sql);
			if (a!=0)
			{
				JOptionPane.showMessageDialog(null,"Successfully Inserted!!");
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"Failed!!");
			}
			
			while(rs.next())
			{
			System.out.println(rs.getString(1)); //+"  "+rs.getInt(2)+"  "+rs.getString(3));
			}
			con.close();
			}
			catch(Exception e)
			{
			System.out.println(e);
			}
			
			}
			}
		});
		
		btn20.addActionListener( new ActionListener(){		//add department btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);	
			a.add(receptionistAddPanel);
                        a.setExtendedState(JFrame.MAXIMIZED_BOTH);
			a.setVisible(true);
			}
			});
			
			btn26.addActionListener( new ActionListener(){		//add acntnt btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			
			
			rcptIdHold = rcptIdtf.getText(); 
			rcptUsernameHold = rcptUsernametf.getText();
			rcptNameHold = rcptNametf.getText(); 
			rcptPhoneHold = rcptPhonetf.getText(); 
			
			
			//System.out.println("Check value of addDepartmentHold" +addDepartmentHold);
			if((rcptIdHold.equals("") )||(rcptUsernameHold.equals("")))
			{
				JOptionPane.showMessageDialog(null,"Invalid Input!!");
			}
			else  {
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmds","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" select * from receptionist ");
			String sql= "INSERT INTO `receptionist` (`ID`, `Username`, `ReceptionistName`, `ReceptionistPhone`) VALUES ('"+rcptIdHold+"', '"+rcptUsernameHold+"', '"+rcptNameHold+"', '"+rcptPhoneHold+"')";
			int a = stmt.executeUpdate(sql);
			if (a!=0)
			{
				JOptionPane.showMessageDialog(null,"Successfully Inserted!!");
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"Failed!!");
			}
			
			while(rs.next())
			{
			System.out.println(rs.getString(1)); //+"  "+rs.getInt(2)+"  "+rs.getString(3));
			}
			con.close();
			}
			catch(Exception e)
			{
			System.out.println(e);
			}
			
			}
			}
		});
                        
                        btn27.addActionListener( new ActionListener(){		//add department btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);	
			a.add(departmentUpdatePanel);
                        a.setExtendedState(JFrame.MAXIMIZED_BOTH);
			a.setVisible(true);
			}
			});
                        
                        btn28.addActionListener( new ActionListener(){		//add department btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			AdminDash a = new AdminDash(loginID);
                         
                         String dptname = null;
                                             
			a.add(departmentDelectPanel);
                        a.setExtendedState(JFrame.MAXIMIZED_BOTH);
			a.setVisible(true);
			}
			});

                        btn29.addActionListener( new ActionListener(){		//add department btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			
			upDepartmentHold = upDepartmenttf.getText();
			upDescriptionHold = upDescriptiontf.getText();
                        nameDepartmentHold = nameDepartmenttf.getText();
                        
			System.out.println("Check value of addDepartmentHold" +upDepartmentHold);
			
                        
                        if((upDepartmentHold.equals("") ) || (upDescriptionHold.equals("")) || (nameDepartmentHold.equals("") ))
			{
				JOptionPane.showMessageDialog(null,"Invalid Input!!");
	                }
                        
                                                        
			else  {
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmds","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from department");
			String sql= "UPDATE `department` SET `DepartmentName` = '"+upDepartmentHold+"', `DepartmentDescription` = '"+upDescriptionHold+" ' WHERE `department`.`DepartmentName` = '"+nameDepartmentHold+"';";
			int a = stmt.executeUpdate(sql);
			if (a!=0)
			{
				JOptionPane.showMessageDialog(null,"Successfully Updated!!");
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"Inter Valid Department Name!!");
			}
			
			while(rs.next())
			{
			System.out.println(rs.getString(1)); //+"  "+rs.getInt(2)+"  "+rs.getString(3));
			}
			con.close();
			}
			catch(Exception e)
			{
			System.out.println(e);
			}
			
			}
			}
			
		});
                        
                         btn30.addActionListener( new ActionListener(){		//add department btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			
			dlctDptHold = departmentDlcttf.getText();
                        
			System.out.println("Check value of addDepartmentHold" +upDepartmentHold);
			
                        
                        
                        
                        
                        if(dlctDptHold.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Invalid Input!!");
	                }
                        
                                                        
			else  {
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmds","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from department");
			String sql= "DELETE FROM `department` WHERE `department`.`DepartmentName` = '"+dlctDptHold+"'";
			int a = stmt.executeUpdate(sql);
			if (a!=0)
			{
				JOptionPane.showMessageDialog(null,"Successfully Updated!!");
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"Inter Valid Department Name!!");
			}
			
			while(rs.next())
			{
			System.out.println(rs.getString(1)); //+"  "+rs.getInt(2)+"  "+rs.getString(3));
			}
			con.close();
			}
			catch(Exception e)
			{
			System.out.println(e);
			}
			
			}
			}
			
		});
                         
                         
                         btn31.addActionListener( new ActionListener(){		//Dashboard btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			PasswordSysGui a = new PasswordSysGui();
                                        a.setVisible(true);		
			}
			
		});
		
      
		   }
                
                
}
       /*
        public static void main(String [] args)
        {
		AdminDash b = new AdminDash(loginID);
		b.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//a.setUndecorated(true);
		b.setVisible(true);
		}
*/
