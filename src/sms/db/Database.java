package sms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Douglas
 */
public class Database {
    
    private static final String DB_DRIVER = "com.mysql.cj.jbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/smart_school";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
    private Connection conn;
    private static Database databaseCon;
    
    private Database() throws ClassNotFoundException, SQLException{
        conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public static Database getDatabase() throws ClassNotFoundException, SQLException{
        if(databaseCon == null){
            databaseCon = new Database();
        }
        return databaseCon;
    }
}
