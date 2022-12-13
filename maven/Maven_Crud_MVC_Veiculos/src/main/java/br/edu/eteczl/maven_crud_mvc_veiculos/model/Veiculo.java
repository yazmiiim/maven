/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.eteczl.maven_crud_mvc_veiculos.model;
import br.edu.eteczl.maven_crud_mvc_veiculos.model.sqlite.VeiculoSQLiteDao;
import java.util.List;
/**
 *
 * @author Admin
 */
public class Veiculo {
    private Integer _id;
    
    private String marca;
    private String modelo;
    private int hp;
    
    public Veiculo(String marca, String modelo, int hp)
    {
        this.marca = marca;
        this.modelo = modelo;
        this.hp = hp;
    }
    
    public Veiculo(int _id, String marca, String modelo, int hp){
        this._id = _id;
        this.marca = marca;
        this.modelo = modelo;
        this.hp = hp;
    }
    
    public Integer getId(){
        return _id;
    }
    
    public void setId(Integer _id){
       this._id = _id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    
    @Override
    public String toString(){
        return "Veiculo(" + marca + "\t" + modelo + "\t" + hp + ") [" + _id + "]\n";
    }
    
    private static VeiculoSQLiteDao dao = new VeiculoSQLiteDao();
    
    public void save(){
        if(_id != null && dao.find(_id) != null){
            dao.update(this);
        }
        else{
            dao.create(this);
        }
    }
    
    public void delete(){
        if(dao.find(_id) != null){
            dao.delete(this);
        }
    }
    
    public static List<Veiculo> requestAll(){
        return dao.requestAll();
    }
    
    public static Veiculo find(int pk){
        return dao.find(pk);
    }
}
