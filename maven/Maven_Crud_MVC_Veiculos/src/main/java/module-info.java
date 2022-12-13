module br.edu.eteczl.maven_crud_mvc_veiculos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    

    opens br.edu.eteczl.maven_crud_mvc_veiculos to javafx.fxml;
    opens br.edu.eteczl.maven_crud_mvc_veiculos.controller to javafx.fxml;
    opens br.edu.eteczl.maven_crud_mvc_veiculos.model to javafx.fxml;
    exports br.edu.eteczl.maven_crud_mvc_veiculos;
    exports br.edu.eteczl.maven_crud_mvc_veiculos.controller;
    exports br.edu.eteczl.maven_crud_mvc_veiculos.model;
}
