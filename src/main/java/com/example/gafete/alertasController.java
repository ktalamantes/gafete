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
    private Button btnDescargaR;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnElimarA;


    @FXML
    protected void btnAceptarR(){
        Stage s = (Stage) btnRegistroU.getScene().getWindow();
        s.close();
    }//boton salirAgregar

    @FXML
    protected void btnAceptarD(){
        Stage s = (Stage) btnDescargaR.getScene().getWindow();
        s.close();
    }

    @FXML
    protected void btnEditarA(){
        Stage s = (Stage) btnEditar.getScene().getWindow();
        s.close();
    }

    @FXML
    protected void btnElimarA(){
        Stage s = (Stage) btnElimarA.getScene().getWindow();
        s.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
