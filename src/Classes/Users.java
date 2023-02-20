package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public  class Users implements Observer {
    private final String DBRead="Users";
    public int UserID;
    public String FName;
    public String LName;
    public String UserName;
    public String Password;
    public String Email;
    public int PhoneNum;
    public String Case; // Case Owner or Seeker
     Database con = new Database();
    Connection n = con.connect();
   
    public ArrayList<Users> LoginList = new ArrayList<Users>(); 

    public Users() {
    }

    public Users(int UserID, String FName, String LName, String UserName, String Password, String Email, int PhoneNum, String Case) {
        this.UserID = UserID;
        this.FName = FName;
        this.LName = LName;
        this.UserName = UserName;
        this.Password = Password;
        this.Email = Email;
        this.PhoneNum = PhoneNum;
        this.Case = Case;
    }

  
    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

   


    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(int PhoneNum) {
        this.PhoneNum = PhoneNum;
    }

    public String getCase() {
        return Case;
    }

    public void setCase(String Case) {
        this.Case = Case;
    }

    public ArrayList<Users> getLoginList() {
        return LoginList;
    }

    public void setLoginList(ArrayList<Users> LoginList) {
        this.LoginList = LoginList;
    }
    

    
    public boolean userLogin(String username,String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        boolean log = false;
        String connectionURL= "jdbc:mysql://localhost:3306/se?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            try {
                Connection conn = DriverManager.getConnection(connectionURL, "root", "");
                String sql = String.format("SELECT * FROM users WHERE username = '%s' AND password = '%s'",username,password);
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
    public boolean userCheck(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        boolean user = false;
        String connectionURL= "jdbc:mysql://localhost:3306/se?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            try {
                Connection conn = DriverManager.getConnection(connectionURL, "root", "");
                String sql = String.format("SELECT * FROM users WHERE username = '%s' ",username);
                Statement st = conn.createStatement();
                ResultSet rs=null;
                rs=st.executeQuery(sql);           
                if(rs.next()){
                    user = true;
                }
                else{
                     System.out.println("Change Username");
                }
                rs.close();
                st.close();
                conn.close();
                } catch (SQLException ex) {
                System.err.println("DATABASE CONNECTION ERROR: " + ex.toString());
                }catch (Exception e) {
        System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
        }


        return user;
    }    
    
    //String sql = String.format("INSERT INTO USERS (USERNAME,PASSWORD,F_NAME,L_NAME,EMAIL,ISEMPLOYEE,P_NUM,DOB) VALUES ('%s','%s','%s','%s','%s',false,'%s','%s')",
                //Username,Password,FName,LName,Email,Num,DOB);
    
     public void signUP(String fname,String lastname,String username,String email,String pass)throws ClassNotFoundException, InstantiationException, IllegalAccessException{
             String connectionURL= "jdbc:mysql://localhost:3306/se?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
          
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                try {
                    Connection conn = DriverManager.getConnection(connectionURL, "root", "");
                    String sql = String.format("INSERT INTO `users` (`firstname`, `lastname`, `username`, `email`, `password`) VALUES ('%s', '%s', '%s', '%s', '%s');",fname,lastname,username,email, pass);
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
      public void addPro(String cat,String room,String Desc,String Price,String address,String city)throws ClassNotFoundException, InstantiationException, IllegalAccessException{
             String connectionURL= "jdbc:mysql://localhost:3306/se?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
          
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                try {
                    Connection conn = DriverManager.getConnection(connectionURL, "root", "");
                    String sql = String.format("INSERT INTO `property` (`P_Description`, `P_Price`, `P_Address`, `room`, `P_Category`, `P_City`, `is_Pending`) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '1');",cat,room,Desc,Price, address,city);
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
    
    public void update_pw(String pass,String name)throws ClassNotFoundException, InstantiationException, IllegalAccessException{
             String connectionURL= "jdbc:mysql://localhost:3306/se?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
          
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                try {
                    Connection conn = DriverManager.getConnection(connectionURL, "root", "");
                    String sql = String.format("UPDATE users SET password = %s  WHERE username = '%s'",pass,name);
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
    
    
    
    @Override
    public void update( String availabiliy )
 {
 System.out.println("Hello " + FName + ", Property is now " + availabiliy + " on Advertisment");
 }
}
