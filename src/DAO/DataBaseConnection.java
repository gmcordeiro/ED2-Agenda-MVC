/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

/**
 *
 * @author Aluno
 */
public class DataBaseConnection {
    
    private static final String BD = "agenda"; 
    private static final String SERVIDOR = "127.0.0.1"; 
    private static final String PORTA = "3306"; 
    private static final String TIME_ZONE = "useTimezone=true&serverTimezone=UTC";
    private static final String STR_CONNECTION = "jdbc:mysql://" + SERVIDOR + ":" + PORTA + "/" + BD + "?" + TIME_ZONE; 
    private static final String USUARIO = "root"; 
    private static final String SENHA = "root";
    private static final String STR_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    private static Connection StartConnection() {
        Connection objConnection = null;
        try{
            Class.forName(STR_DRIVER);
            objConnection = DriverManager.getConnection(STR_CONNECTION, USUARIO, SENHA);
        }catch(ClassNotFoundException ce){
            System.out.println("Erro ao carregar o driver!");
        }catch(SQLException e){
            System.out.println("Erro ao conectar com o banco de dados!");        
        }
        return objConnection;
    }
    
    public static Connection getConnection() {
        return StartConnection();
    }
    /*
    public static void closeConnection(){
        if(objConnection != null){
            try{
                objConnection.close();
                objConnection = null;
            }catch(SQLException e){
                System.out.println("listacontatos.DataBaseConnection.closeConnection()");
            }
        }
    }*/
    
}
