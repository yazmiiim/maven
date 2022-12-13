package br.edu.eteczl.maven_crud_mvc_veiculos;

import br.edu.eteczl.maven_crud_mvc_veiculos.model.Veiculo;
import br.edu.eteczl.maven_crud_mvc_veiculos.model.sqlite.VeiculoSQLiteDao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    public static String tela_primaria = "view/primary";
    
    public static String tela_secundaria = "view/secondary";
    
    private static Stage stage;
    
    private static Scene scenePrimaria;
    
    private static Scene sceneSecundaria;
   

    @Override
    public void start(Stage stage) throws IOException 
    {
        
        VeiculoSQLiteDao database = new VeiculoSQLiteDao();
        
        //Teste Insert;
        
        
        Veiculo v = new Veiculo(6, "Ford" , "Ka", 180);
        v.save();
        System.out.println(database.requestAll());
        database.create(v);
        
        
        //System.out.println(database.find(2));
        
        
        
        // Teste Find;
        // System.out.println(database.find(2));
        
        // Teste Update
        //Veiculo v = new Veiculo(3 , "vw" , "up tsi" , 115);
        //database.update(v);
        
        // Teste Delete 
        //Veiculo v = new Veiculo(6, "fiat" , "uno", 150);
        //database.delete(v);
        //System.exit(0);
        
        // Teste RequestAll;
        //System.out.println(database.requestAll());
        this.stage = stage;
        scenePrimaria = new Scene(loadFXML(App.tela_primaria), 640, 480);
        stage.setTitle("Tela Primária");
        stage.setResizable(false);
        stage.setScene(scenePrimaria);
        stage.show();
        //String path = System.getProperty("user.dir") + "\\icon\\car.png";
        //System.out.println(path);
        //stage.getIcons().add(new Image("C:\\Users\\Wagner Lucca\\Documents\\NetBeansProjects\\Maven_Crud_MVC_Veiculos\\icon\\car.jpg"));
        //Image image = new Image(path);
        //stage.getIcons().add(image);
        //scene = new Scene(loadFXML(App.tela_primaria), 640, 480);
        

    }
    
    public static void mudarTela(String tela , Object userData) throws IOException
    {
      switch (tela)
      {
        case "primaria":
          scenePrimaria = new Scene(loadFXML(App.tela_primaria), 640, 480);
          stage.setScene(scenePrimaria);
          stage.setTitle("Tela Primária");
          stage.setResizable(false);
          notifyAllListeners("primaria" , userData);
        break;
        case "secundaria":
          sceneSecundaria = new Scene(loadFXML(App.tela_secundaria), 640, 480);
          stage.setScene(sceneSecundaria);
          stage.setTitle("Tela Secundária");
          stage.setResizable(false);
          notifyAllListeners("secundaria" , userData);
        break;
      }
    }
    
    public static void mudarTela(String tela) throws IOException
    {
      mudarTela(tela , null);
    }

    public static void setRoot(String fxml) throws IOException 
    {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) 
    {
        launch();
    }
    
    // =========================================================================
    
    private static final ArrayList<OnChangeScreen> listeners = new ArrayList<>();
    
    public static interface OnChangeScreen
    {
      void onScreenChanged(String newScreen , Object userData);
    }

    public static void addOnChangeScreenListener(OnChangeScreen newListener)
    {
      listeners.add(newListener);
    }
    
    private static void notifyAllListeners(String newScreen , Object userData)
    {
      for(OnChangeScreen l : listeners)
      {
        l.onScreenChanged(newScreen , userData);
      }
    }
}