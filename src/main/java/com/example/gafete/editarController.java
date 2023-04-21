package com.example.gafete;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class editarController {

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
