package com.example.gafete;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class alertasController implements Initializable {

    @FXML
    private Button btnRegistroU;


    @FXML
    protected void btnAceptarR(){
        Stage s = (Stage) btnRegistroU.getScene().getWindow();
        s.close();
    }//boton salirAgregar

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
