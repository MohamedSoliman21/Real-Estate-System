package Classes;

import java.sql.*;
import java.util.*;

public class Database
{
    public String userName = "root";
    public String password = "";
    public String dbName = "propertydb";

    private Connection con;
    
    Connection connect()
    {
        try {
            //Loading the jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Get a connection to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
        } catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
            }
        return con;
    }

    public void Add(String tableName, String values)
    {
        System.out.println(values);
        Connection n = connect();
        String sqlStt = "insert into " + tableName + " values ( ";
        String []data = values.split("@");
        for(int i = 0; i < data.length-1; i++)
        {
            sqlStt += "?, ";
        }
        sqlStt += "? );";
        System.out.println(sqlStt);
        try
        {
            PreparedStatement st = n.prepareStatement(sqlStt);
            switch(tableName)
            {
                case "Property":
                    //PropertyID, PropertyCategory, PropertySize, Description, Price
                    //BookingType, Address, UserID
                    st.setInt(1, Integer.parseInt(data[0]));
                    st.setString(2, data[1]);
                    st.setFloat(3, Float.parseFloat(data[2]));
                    st.setString(4, data[3]);
                    st.setFloat(5, Float.parseFloat(data[4]));
                    st.setString(6, data[5]);
                    st.setString(7, data[6]);
                    st.setInt(8, Integer.parseInt(data[7]));
                    break;
                case "Users":
                    // UserID, FName, LName, PhoneNum, UserName,Password, Email, Case, Oder
                    
                    st.setInt(1, Integer.parseInt(data[0]));
                    st.setString(2, data[1]);
                    st.setString(3, data[2]);
                    st.setInt(4, Integer.parseInt(data[3]));
                    st.setString(5, data[4]);
                    st.setString(6, data[5]);
                    st.setString(7, data[6]);
                    st.setString(8, data[7]);
                    st.setString(9, data[8]);
                    
                    break;
                case "Admin":
                    //AdminID, FName, LName, PhoneNum, UserName,Password, Email, Address
                    st.setInt(1, Integer.parseInt(data[0]));
                    st.setString(2, data[1]);
                    st.setString(3, data[2]);
                    st.setInt(4, Integer.parseInt(data[3]));
                    st.setString(5, data[4]);
                    st.setString(6, data[5]);
                    st.setString(7, data[6]);
                    st.setString(8, data[7]);
                    break;
                case "Advertisment":
                    //Ad_Code, Availability, PropertyID
                    st.setInt(1, Integer.parseInt(data[0]));
                    st.setString(2, data[1]);
                    st.setInt(3, Integer.parseInt(data[2]));
                    break;
                case "Booking":
               //BookingID, BookingType, UserID
                    st.setInt(1, Integer.parseInt(data[0]));
                    st.setString(2, data[1]);
                    st.setInt(3, Integer.parseInt(data[2]));
                    break;
                    
                case "Feedback":
               //FeedbackID, Review,Rate, UserID
                    st.setInt(1, Integer.parseInt(data[0]));
                    st.setString(2, data[1]);
                    st.setInt(3, Integer.parseInt(data[2]));
                    st.setInt(4, Integer.parseInt(data[3]));
                    break;
                    
                case "Review":
               //AdminID, PropertyID
                    st.setInt(1, Integer.parseInt(data[0]));
                    st.setInt(2, Integer.parseInt(data[1]));
                    break;
                    
                case "Payment":
               //PaymentID, Amount, Payment_Method, UserID
                    st.setInt(1, Integer.parseInt(data[0]));
                    st.setFloat(2, Float.parseFloat(data[1]));
                    st.setString(3, data[2]);
                    st.setInt(4, Integer.parseInt(data[3]));
                    break;
            }
            st.execute();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        catch(NullPointerException nullE)
        {
            System.out.println("Null Pointer Exception, con variable is NULL, check the connect method");
        }
    }

    
        public void Delete(String TableName, String condition)
    {
        Connection n = connect();
        String sqlStt = " delete from " + TableName +  " where " + condition+";";
        try
        {
            Statement st = n.createStatement();
            st.execute(sqlStt);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        catch(NullPointerException nullE)
        {
            System.out.println("Null Pointer Exception, con variable is NULL, check the connect method");
        }
    }
        
    
    public ArrayList<Object> read(String tableName, String sortBy, boolean ascending)
    {
        String sortType = " asc";
        if(!ascending)
        {
            sortType = " desc";
        }
        String sqlStt = "select * from " + tableName + " order by " + sortBy + sortType;
        Connection n = connect();
        ResultSet rs;
        ArrayList<Object> readedData = new ArrayList<>();
        try
        {
            Statement st = n.createStatement();
            rs = st.executeQuery(sqlStt);
            switch(tableName)
            {
                case "Users":
                    //id@name@lastName@quantity@parcode@price@category@EXP
                    while(rs.next())
                    {
                        Users User = new Users();
                        User.setUserID(rs.getInt(1));
                        User.setFName(rs.getString(2));
                        User.setLName(rs.getString(3));
                        User.setUserName(rs.getString(4));
                        User.setPassword(rs.getString(5));
                        User.setEmail(rs.getString(6));
                        User.setPhoneNum(rs.getInt(7));
                        User.setCase(rs.getString(8));
                        readedData.add(User);
                    }
                    break;
                case "Advertisment":
                    // Ad_Code, Availability
                    while(rs.next())
                    {
                        Advertisment Adv = new Advertisment();
                        Adv.setAd_Code(rs.getInt(1));
                        Adv.setAvailability(rs.getString(2));
                        readedData.add(Adv);
                    }
                    break;
                case "Property":
    //int PropertyId, String PropertyCategory, float PropertySize, String Description, float Price, String PropertyType, String Address, String City
                    while(rs.next())
                    {
                        Property newProperty = new Property();
                        newProperty.setPropertyId(rs.getInt(1));
                        newProperty.setPropertyCategory(rs.getString(2));
                        newProperty.setPropertySize(rs.getFloat(3));
                        newProperty.setDescription(rs.getString(4));
                        newProperty.setPrice(rs.getFloat(5));
                        newProperty.setPropertyType(rs.getString(6));
                        newProperty.setAddress(rs.getString(7));
                        newProperty.setCity(rs.getString(8));
                        readedData.add(newProperty);
                    }
                    break;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        catch(NullPointerException nullE)
        {
            System.out.println("Null Pointer Exception, con variable is NULL, check the connect method");
        }
        return readedData;
    }
    
    
    public void execute(String statement)
    {
        Connection n = connect();
        try
        {
            Statement sqlStt = n.createStatement();
            sqlStt.execute(statement);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        catch(NullPointerException nullE)
        {
            System.out.println("Null Pointer Exception, con variable is NULL, check the connect method");
        }
    }
    
    public void updateRow(String tableName, String oldValue, String newValue)
    {
        Delete(tableName, oldValue);
        Add(tableName, newValue);
    }
    public void updateRow(String tableName, Object oldValue, Object newValue)
    {
        Delete(tableName, (String) oldValue);
        Add(tableName, (String) newValue);
    }
    
    public Booking getBookingByID(int BookingID) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from booking where BookID = '" + BookingID + "'");
            if (rs.first()) {
                return new Booking(rs.getInt("BookID"), rs.getString("BookType"), rs.getString("BookDescription"), rs.getInt("BookPrice"));
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return null;
    }

    
    
}



