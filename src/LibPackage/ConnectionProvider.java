/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibPackage;

import java.sql.DriverManager;

/**
 *
 * @author moham
 */
public class ConnectionProvider {
static java.sql.Connection conn=null;
static final String url="jdbc:oracle:thin:@localhost:1521:xe";
static final String user="system";
static final String pswd="admin";
    public static java.sql.Connection getCon()
    {
        System.out.print("Connecting..");
       try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
            
             conn = DriverManager.getConnection(url,user,pswd);
            if(conn.isClosed()){
                System.out.println("Connection is closed.");
            }
            else
            System.out.println("Connection is Established.");

        } catch (Exception e) {
        }
       return conn;
    }
}