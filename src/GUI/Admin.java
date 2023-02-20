/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;  
import java.util.Date;  


/**
 *
 * @author Mido
 */
// Java program implementing Singleton class 
// with getInstance() method 
class Admin 
{ 
	// static variable single_instance of type Singleton 
	private static Admin single_instance = null; 
    
	// variable of type String 
	public String FirstName ;
        public String LastName ;
        public String username ;
        protected String password;
        public String email ;
       
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /*
    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
       */ 
        
	// private constructor restricted to this class itself 
	private Admin() 
	{ 
		
	} 
        public static void delete_user() {
             
        }
	// static method to create instance of Singleton class 
	public static Admin getInstance() 
	{ 
		if (single_instance == null) 
			single_instance = new Admin(); 

		return single_instance; 
	} 
        /*
        public Admin Login (String name,String Password) {
        try {
            boolean found = true;    
            Statement stmt = n.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Admin where username = '" + name + "'" + "AND password = '" + Password +"'");
            if (rs.next()) {
                
            }
        } 
        catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return null;
        }
        */
        public boolean Login(String username,String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        boolean log = false;
         String connectionURL= "jdbc:mysql://localhost:3306/se?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
          
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                try {
                    Connection conn = DriverManager.getConnection(connectionURL, "root", "");
                    String sql = String.format("SELECT * FROM admin WHERE username = '%s' AND password = '%s'",username,password);
                    Statement st = conn.createStatement();
                    ResultSet rs=null;
                    rs=st.executeQuery(sql);           
                    if(rs.next()){
                        log = true;
                    }
                    else{
                         System.out.println("Wrong username or password ");
                    }
                    rs.close();
                    st.close();
                    conn.close();
                    } catch (SQLException ex) {
                    System.err.println("DATABASE CONNECTION ERROR: " + ex.toString());
                    }catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
            }
            
        
            return log;
        }
        public void DeleteByID(int id)throws ClassNotFoundException, InstantiationException, IllegalAccessException{
         String connectionURL= "jdbc:mysql://localhost:3306/se?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
          
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                try {
                    Connection conn = DriverManager.getConnection(connectionURL, "root", "");
                     String sql = "DELETE FROM USERS WHERE U_ID = " + id;
                    Statement st = conn.createStatement();
                    ResultSet rs=null;
                    st.executeUpdate(sql);
                    rs.close();
                    st.close();
                    conn.close();
                    } catch (SQLException ex) {
                    System.err.println("DATABASE CONNECTION ERROR: " + ex.toString());
                    }catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
            }          
        }  
        public void update_pending(String Desc)throws ClassNotFoundException, InstantiationException, IllegalAccessException{
             String connectionURL= "jdbc:mysql://localhost:3306/se?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
          
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                try {
                    Connection conn = DriverManager.getConnection(connectionURL, "root", "");
                    String sql = String.format("UPDATE property SET is_Pending = 0  WHERE P_Description = '%s'",Desc);
                    Statement st = conn.createStatement();
                    st.executeUpdate(sql);
                    st.close();
                    conn.close();
                    } catch (SQLException ex) {
                    System.err.println("DATABASE CONNECTION ERROR: " + ex.toString());
                    }catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
            }          
        } 
        
        /**
         * 
         * 
         * this.DateDay=Integer.parseInt(currentDate[0]);
            this.DateMonth=Integer.parseInt(currentDate[1]);
            this.DateYear=Integer.parseInt(currentDate[2]);
            AllDay=DateDay+DateMonth*30+DateYear*365;
         * 
         * 
         */
        public void banUser(String username,int months)throws ClassNotFoundException, InstantiationException, IllegalAccessException{
            SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
            Date d=new Date();
            String Date1=s.format(d);
            System.out.print(Date1);
            String[] currentDate=Date1.split("-");
            String year=currentDate[0];
            int  DateMonth=Integer.parseInt(currentDate[1]);
            String day=currentDate[2];
            int expMonth = DateMonth + months;
            String ExpDate  = String.format("%s-%s-%s",year,expMonth,day);
            System.out.print("...."+ExpDate);
            String connectionURL= "jdbc:mysql://localhost:3306/se?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
          
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            try {
                    Connection conn = DriverManager.getConnection(connectionURL, "root", "");
                    //String sql = String.format("UPDATE users SET DateOfBan = %s , Exp = %s  WHERE username = '%s'",Date1,ExpDate,username);
                    String sql = String.format("UPDATE users SET DateOfBan = DATE(@dt) , Exp =   WHERE username = '%s'",Date1,ExpDate,username);
                    Statement st = conn.createStatement();
                    st.executeUpdate(sql);
                    st.close();
                    conn.close();
                    } catch (SQLException ex) {
                    System.err.println("DATABASE CONNECTION ERROR: " + ex.toString());
                    }catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
            }                   
            
        }
} 
