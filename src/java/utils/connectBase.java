/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class connectBase {
    

public static Connection connect() throws SQLException, Exception {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connecter = DriverManager.getConnection("jdbc:postgresql://localhost:5432/voyage",
//                "postgres", "Milliardaire2621");
                    "postgres", "root");
            return connecter;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("connection failed");
        }
    }

public static void main(String[] args) {
        try {
           Connection se_connecter;
            se_connecter = connectBase.connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
 }
}
