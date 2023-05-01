package com.example.gafete;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class usuarioController {
    @FXML
    private ImageView registar;
    @FXML
    private Button btnCerrar;

    @FXML
    protected void solicitarGafete(){
        try {
            Stage stage = new Stage();//Crear una nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("solicitarGafete.fxml"));
            Stage cerrar = (Stage) registar.getScene().getWindow();
            cerrar.close();
            Scene escena = new Scene(loader.load());
            stage.setTitle("editar");
            stage.setScene(escena);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }//catch
    }

    @FXML
    protected void cerrarSesion(){
        try {
            Stage stage = new Stage();//Crear una nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inicioSesion.fxml"));
            Stage cerrar = (Stage) btnCerrar.getScene().getWindow();
            cerrar.close();
            Scene escena = new Scene(loader.load());
            stage.setTitle("editar");
            stage.setScene(escena);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }//catch
    }
}
