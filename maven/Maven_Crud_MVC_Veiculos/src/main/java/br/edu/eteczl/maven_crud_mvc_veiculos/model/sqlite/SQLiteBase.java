/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.eteczl.maven_crud_mvc_veiculos.model.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class SQLiteBase {
    protected Connection conn;
    
    public Connection open(){
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:my_database+.db");
            return conn;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void close(){
        try{
            if(conn != null){
                conn.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
