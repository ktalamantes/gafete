package com.example.gafete;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;

public class registroController {
    @FXML private TextField txtnombre;
    @FXML private TextField txtcorreo;
    @FXML private TextField txtcontraseña;
    @FXML private Button registrar;
    @FXML private Hyperlink cerrarLink;


    @FXML
    protected void RegistrarUsuario (ActionEvent evt){
        try {
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            String sql = "INSERT INTO usuarios VALUES (0, '" + txtnombre.getText() + "','" + txtcorreo.getText() + "','" +
                    txtcontraseña.getText() + "')";
            stm.execute(sql);
            Stage stage = new Stage();//Crear una nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("anuncioRegistroCreado.fxml"));
            Scene escena = new Scene(loader.load());
            stage.setTitle("");
            stage.setScene(escena);
            stage.showAndWait();
            HelloApplication.setVista("inicioSesion");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e+ "No se insertaron datos!!\n");
        }
        txtnombre.setText("");
        txtcorreo.setText("");
        txtcontraseña.setText("");
    }

    @FXML
    protected void crearCuenta(){
        try {
            Stage stage = new Stage();//Crear una nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inicioSesion.fxml"));
            Stage cerrar = (Stage) cerrarLink.getScene().getWindow();
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
