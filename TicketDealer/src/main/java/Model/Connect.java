package Model;
import Vistas.*;
import Controlador.*;
import Resources.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    String url = "jdbc:mysql://localhost:3306/TicketDealer?useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "TicketDealer";
    String pass = "1101";
    ResultSet rs ;
    Statement s ;
    Connection cnx;
        public Connect() throws SQLException {
         try {            

            Class.forName("com.mysql.cj.jdbc.Driver");
          cnx= DriverManager.getConnection(url, user, pass) ;

            
            s = cnx.createStatement();
                rs = s.executeQuery ("select * from usuarios");          
                           while (rs.next()) 
{ 
                        System.out.printf("User :"+rs.getString (2)+ "|| Pass: " + rs.getString(3) + "\n");   //JOptionPane.showMessageDialog(null,rs.getString (1)+ "/"+ rs.getString (2));
} 
           
           
           
           
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
        }
        public Connection getConnection(){
        return cnx;
        }
}
