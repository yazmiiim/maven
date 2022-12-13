package br.edu.eteczl.maven_crud_mvc_veiculos.controller;

import br.edu.eteczl.maven_crud_mvc_veiculos.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PrimaryController {

//    @FXML
//    private void switchToSecondary() throws IOException {
//        App.setRoot(App.tela_secundaria);
//    }
    
    @FXML
    protected void btn_Novo_Action (ActionEvent e) throws IOException
    {
      System.out.println("BTN Novo!!!");
      App.mudarTela("secundaria" , "Dados para a tela secundária!");
    }
    
    @FXML
    protected void btn_Editar_Action (ActionEvent e)
    {
      System.out.println("BTN Editar!!!");
    }
    
    @FXML
    protected void btn_Apagar_Action (ActionEvent e)
    {
      System.out.println("BTN Apagar!!!");
    }
}
