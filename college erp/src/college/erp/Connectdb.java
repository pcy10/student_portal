package college.erp;
import java.sql.*;

public class Connectdb {
    Connection c;
    Statement s;
    
    Connectdb(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // register class "driver address.driver"
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_record","root","libi1674");
            // connection sting upp
            s= c.createStatement(); // statement
        }
        catch (Exception e){
            e.printStackTrace(); // to print what exceoption is happening
        }
        
        // as mysql is an external entity , so there is high prob of getting errors
        // so we use try and catch
    }
    
    public static void main( String[] args){
        new Connectdb(); // it connects java with sql database
        /* 1 register driver class
        2. creating connection string
        3. creating statement
        4. execute mysql query
        5. close the conection
        */
    }
    
}
