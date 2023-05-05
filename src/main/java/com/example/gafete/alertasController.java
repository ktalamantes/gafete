package com.example.gafete;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class alertasController {

    @FXML
    private Button btnRegistroU;


    @FXML
    protected void btnAceptarR(){
        Stage s = (Stage) btnRegistroU.getScene().getWindow();
        s.close();
    }//boton salirAgregar

}
