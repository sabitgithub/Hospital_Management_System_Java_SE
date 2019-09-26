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



class Receptionist extends JFrame{
	
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
        JButton btn31;
	
	
	Receptionist a;
	
	
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
	
	
	
	public Receptionist(String loginID){
		
                this.loginID = loginID;
		this.setTitle("Receptionist");
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
                btn31 = new JButton ("Log OUT");
		
		
		btn12 = new JButton ("Doctor List");

		btn21 = new JButton ("Room List");
	
		
                
		JPanel profilePanel = new JPanel();		
		profilePanel.setLayout(null);
		profilePanel.setBounds(189,5,1300,1000);
		profilePanel.setBackground(new Color(0,0,111));
		
		table = new JTable();
		//profilePanel = new JPanel();
		
		JPanel doctorPanel = new JPanel();		
		doctorPanel.setLayout(null);
		doctorPanel.setBounds(189,5,1300,1000);
		doctorPanel.setBackground(new Color(0,0,111));
                
                JPanel doctorListPanel = new JPanel();		
		doctorListPanel.setLayout(null);
		doctorListPanel.setBounds(189,5,1300,1000);
		doctorListPanel.setBackground(new Color(0,0,111));
                
		JPanel roomPanel = new JPanel();		
		roomPanel.setLayout(null);
		roomPanel.setBounds(189,5,1300,1000);
		roomPanel.setBackground(new Color(0,0,111));
                
		btn1.setBackground(new Color(157,217,245)); //dashbrd
		
		btn3.setBackground(new Color(157,217,245));
		
		
		btn8.setBackground(new Color(157,217,245));
		btn9.setBackground(new Color(157,217,245));
                btn31.setBackground(new Color(157,217,245));
		btn12.setBackground(new Color(157,217,245));   		//Doc.list button
		
		btn21.setBackground(new Color(157,217,245));   		//roomPanel btn
		
		
		btn1.setBounds(5,10,180,55);
		
		btn3.setBounds(5,60,180,55);
		
		
		btn8.setBounds(5,110,180,55);
		btn9.setBounds(5,160,180,55);
                btn31.setBounds(5,210,180,55);
		btn12.setBounds(5,5,180,55);
		btn21.setBounds(5,5,180,55);
		
		
		this.add(btn1);
		this.add(btn3);
		this.add(btn8);
		this.add(btn9);
                this.add(btn31);
		
		doctorPanel.add(btn12);
		roomPanel.add(btn21);				 
		 btn1.addActionListener( new ActionListener(){		//Dashboard btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			Receptionist a = new Receptionist(loginID);
			a.setVisible(true);		
			}
			
		});
		
		btn3.addActionListener( new ActionListener(){		//Receptionist btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			Receptionist a = new Receptionist(loginID);
			a.setVisible(true);
			a.add(doctorPanel);		
			}
			
		});
		
		
		btn8.addActionListener( new ActionListener(){		//room btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			Receptionist a = new Receptionist(loginID);
			a.setVisible(true);
			a.add(roomPanel);		
			}
			
		});
			
		btn9.addActionListener( new ActionListener(){		//profilePanel btn
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			Receptionist a = new Receptionist(loginID);
                        JTable table = new JTable();
                        JScrollPane sp = new JScrollPane(table);
                       // sp.setBounds(10,20,700,80);
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
                        a.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        a.setVisible(true);
			}
			
		});
                
                 btn12.addActionListener( new ActionListener(){		//doctor list
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			Receptionist a = new Receptionist(loginID);
                        JTable table = new JTable();
                        JScrollPane sp = new JScrollPane(table);
                       // sp.setBounds(10,20,700,80);
			try {
			Connection dbcon = dbConnection.dbConnector(); 
			String query = "SELECT * FROM `doctor`";
			PreparedStatement pt = dbcon.prepareStatement(query);
			ResultSet re = pt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(re));	
			
			
		} catch (Exception e) {

			System.out.println(e);
		}
                        doctorListPanel.add(sp);
                        doctorListPanel.setLayout(new BoxLayout(doctorListPanel, BoxLayout.Y_AXIS));
                        a.add(doctorListPanel);
                        a.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        a.setVisible(true);
                        dispose();
			}
			
		});
                 
                  btn21.addActionListener( new ActionListener(){		//doctor list
			
			
			public void actionPerformed(ActionEvent e1){
			dispose();
			Receptionist a = new Receptionist(loginID);
                        JTable table = new JTable();
                        JScrollPane sp = new JScrollPane(table);
                       // sp.setBounds(10,20,700,80);
			try {
			Connection dbcon = dbConnection.dbConnector(); 
			String query = "SELECT * FROM `room`";
			PreparedStatement pt = dbcon.prepareStatement(query);
			ResultSet re = pt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(re));	
			
			
		} catch (Exception e) {

			System.out.println(e);
		}
                        roomPanel.add(sp);
                        roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.Y_AXIS));
                        a.add(roomPanel);
                        a.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        a.setVisible(true);
                        dispose();
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
/*     public static void main(String [] args)
        {
		Receptionist a = new Receptionist(loginID);
		a.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//a.setUndecorated(true);
		a.setVisible(true);
		} */

