package model.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
   public Connection connectDataBase(){
        final String URL ="jdbc:mysql://localhost:3306/case_study_2?useSSL=false";
        final String USER = "root";
        final String PASSWORD = "12345";

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
           try{
               connection = DriverManager.getConnection(URL, USER, PASSWORD);
               return connection;
           } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
        }catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
