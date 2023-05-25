package com.example.gafete;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class creditosController {
    @FXML
    private Button btnAceptar;

    @FXML
    protected void btnSalirAgregar(){
        Stage s = (Stage) btnAceptar.getScene().getWindow();
        s.close();
    }//boton salirAgregar
}
