package br.edu.eteczl.maven_crud_mvc_veiculos.controller;

import br.edu.eteczl.maven_crud_mvc_veiculos.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SecondaryController {

//    @FXML
//    private void switchToPrimary() throws IOException {
//        App.setRoot(App.tela_primaria);
//    }
   
    @FXML
    protected void btn_Cancelar_Action (ActionEvent e) throws IOException
    {
      System.out.println("BTN Cancelar!!!");
      App.mudarTela("primaria");
    }
    
    @FXML
    protected void btn_Ok_Action (ActionEvent e)
    {
      System.out.println("BTN OK!!!");
    }
    
    @FXML
    protected void initialize()
    {
      App.addOnChangeScreenListener(new App.OnChangeScreen()
      {
        @Override
        public void onScreenChanged(String newScreen, Object userData)
        {
          if(newScreen.equals("secundaria"))
          {
            System.out.println("Nova Tela: " + newScreen + " , " + userData);
          }
        }
      });
    }
}