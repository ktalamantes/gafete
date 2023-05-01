package com.example.gafete;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class alertasController {
    @FXML
    private Button btnAlertaU;
    @FXML
    private Button btnRegistroU;


    @FXML
    protected void btnAceptarA(){
        Stage s = (Stage) btnAlertaU.getScene().getWindow();
        s.close();
    }//boton salirAgregar

    @FXML
    protected void btnAceptarR(){
        Stage s = (Stage) btnRegistroU.getScene().getWindow();
        s.close();
    }//boton salirAgregar

}
