package pl.edu.wszib.dao.Impl;

//import com.mysql.jdbc.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {

    public static Connection connection = null;
    public static void connect(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connectin DB..");
            DataBaseConnector.connection = DriverManager.
                    getConnection("jdbc:mysql://localhost/Apteka?user=root&password=");
            System.out.println("Connection is done!");
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
