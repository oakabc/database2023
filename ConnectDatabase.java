/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connectdatabase;
import java.sql.*;

/**
 *
 * @author chanakarnkin
 */
public class ConnectDatabase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Connection conn = null;
        try {// connection String
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        Statement stmt = conn.createStatement() ; 
//        String createLehigh = "Create table Lehigh " +
// 	"(SSN Integer not null, Name VARCHAR(32), " + "Marks Integer)";
//	stmt.executeUpdate(createLehigh);
//        String insertLehigh = "Insert into Lehigh values " +"(555,'Wonyoung',99)";
//	stmt.executeUpdate(insertLehigh);
        
        String select = "select * from Lehigh";
        
        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()) {
            int ssn = rs.getInt("SSN");
            String name = rs.getString("Name");
            int marks = rs.getInt("Marks");
             System.out.println("SSN = "+ ssn + " Name = " + name + " Mark = " + marks); 
        }
        stmt.close();
        conn.close();   
    }
    
}
