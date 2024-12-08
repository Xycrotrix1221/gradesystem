/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gradesystem;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author USER
 */
public class Gradesystem {

 
    public static Connection mycon(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gradesystem","root","");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con ;
    }

    public static Connection getConnection() {
        return mycon();
    }
}

