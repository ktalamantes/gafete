package com.example.gafete;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class editarController {
    @FXML
    private TextField prop;
    @FXML private TextField mar;
    @FXML private TextField mod;
    @FXML private TextField pla;
    @FXML private TextField per;
    @FXML private TextField buscar;
    @FXML
    private Button btnCerrarLogin;

    ObservableList editar = FXCollections.observableArrayList();

     public ComboBox <personal> editar1;

     public void initialize(){
         editar1.setItems(editar);
     }
     public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
