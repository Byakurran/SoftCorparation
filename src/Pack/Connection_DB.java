package Pack;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Connection_DB {

    
    Connection CON;
    Statement STMT;
    ResultSet RS;
    ResultSetMetaData RS_MD;
    String SQL, InsertSQL, DeleteSQL, UpdateSQL;
   
    public void Connect() {        
        try {
            Class.forName("org.h2.Driver");
            CON = DriverManager.getConnection("jdbc:h2:C:\\Program Files\\SoftCorparation\\DB");
            RS = CON.createStatement().executeQuery(SQL);
        } catch (ClassNotFoundException | SQLException e) {        
              System.out.println("Ошибка соединения с базой данных!");
              JOptionPane.showMessageDialog(null, "Ошибка соединения с базой данных!");
        }
    }

    public void DisConnect() {
        try {
            RS.close();
            STMT.close();
            CON.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connection_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Insert() {
        try {
            Class.forName("org.h2.Driver");
            CON = DriverManager.getConnection("jdbc:h2:C:\\Program Files\\SoftCorparation\\DB");
            STMT = CON.createStatement();
            STMT.executeUpdate(InsertSQL);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Connection_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DELETE_Row() {
        try {
            Class.forName("org.h2.Driver");
            CON = DriverManager.getConnection("jdbc:h2:C:\\Program Files\\SoftCorparation\\DB");
            STMT = CON.createStatement();
            STMT.executeUpdate(DeleteSQL);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Connection_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Update() {
        try {
            Class.forName("org.h2.Driver");
            CON = DriverManager.getConnection("jdbc:h2:C:\\Program Files\\SoftCorparation\\DB");
            STMT = CON.createStatement();
            STMT.executeUpdate(UpdateSQL);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Connection_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
