/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibPackage;
import java.sql.*;
/**
 *
 * @author moham
 */
public class testConnection {
    public static void main(String[] args){
        Connection con = ConnectionProvider.getCon();
        if(con!=null){
            System.out.println("Ok");
        }
        else
            System.out.println("No");
    }
}
