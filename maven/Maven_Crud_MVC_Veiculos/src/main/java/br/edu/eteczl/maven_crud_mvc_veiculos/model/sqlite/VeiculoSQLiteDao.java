/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.eteczl.maven_crud_mvc_veiculos.model.sqlite;
import br.edu.eteczl.maven_crud_mvc_veiculos.model.Veiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class VeiculoSQLiteDao extends SQLiteBase {

   public VeiculoSQLiteDao(){
        this.open();
        
        try{
            PreparedStatement stm = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Veiculos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," + 
                    "marca TEXT," +
                    "modelo TEXT," +
                    "hp INTEGER);");
            stm.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            this.close();
        }
   }
   
   public void create(Veiculo v){
       this.open();
       
       try{
           PreparedStatement stm = conn.prepareStatement("INSERT INTO Veiculos (marca , modelo , hp) VALUES (? , ? , ?);");
           
           stm.setString(1, v.getMarca());
           stm.setString(2, v.getModelo());
           stm.setInt(3, v.getHp());
           
           stm.executeUpdate();
       }
       
       catch(SQLException e){
           e.printStackTrace();
       }
       
       finally{
           this.close();
       }
   }
   
    public List<Veiculo> requestAll(){
        ArrayList<Veiculo> result = new ArrayList<>();
        
        this.open();
        
        try{
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Veiculos ORDER BY id ASC;");
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Veiculo v = new Veiculo(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getInt(4));
                
                result.add(v);
                
                
            }
            
        }
        catch(SQLException e){
                e.printStackTrace();
            }
            
        finally{
            this.close();
        }
       return result;
       
    }
    
    public void update(Veiculo v){
        this.open();
        
        try{
            PreparedStatement stm = conn.prepareStatement("UPDATE Veiculos SET " + 
                            "marca = ? , " + 
                            "modelo = ? , " + 
                            "hp = ? " + 
                            "WHERE id = ?;");
            stm.setString(1, v.getMarca());
            stm.setString(2, v.getModelo());
            stm.setInt(3, v.getHp());
            stm.setInt(4, v.getId());
            
            stm.executeUpdate();
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        finally{
            this.close();
        }
    }
    
    public void delete(Veiculo v){
        this.open();
        
        try{
            PreparedStatement stm = conn.prepareStatement("DELETE FROM Veiculos WHERE id = ?;");
            
            stm.setInt(1, v.getId());
            
            stm.executeUpdate();
        }
        
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            this.close();
        }
    }
    
    public Veiculo find(int pk){
        Veiculo result = null;
        this.open();
        
        try{
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Veiculos WHERE id = ?;");
            
            stm.setInt(1 , pk);
            
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                Veiculo v = new Veiculo(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getInt(4));
                
                result = v;
                
                
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
        this.close();
        }
        return result;
    }
}
