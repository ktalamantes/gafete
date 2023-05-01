package com.example.gafete;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class HelloController {
    @FXML
    private ImageView agregarImagen;
    @FXML
    private ImageView editarImagen;
    @FXML
    private ImageView tec;
    @FXML
    private TextField txtNombreA;
    @FXML
    private TextField txtPersonaA;
    @FXML
    private TextField txtMatriculaA;
    @FXML
    private TextField txtMarcaA;
    @FXML
    private TextField txtModeloA;
    @FXML
    private TextField txtColor;
    @FXML
    private Button btnG;
    @FXML
    private Button btnUsuario;
    @FXML
    private Button btnSalirA;


    @FXML
    private void mostrarAlertInfo(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText("Informacion sobre la aplicación");
        alert.showAndWait();
    }

    @FXML
    protected void btnAgregar(){
        try {
            Stage stage = new Stage();//Crear una nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AgregarUsuario.fxml"));
            Scene escena = new Scene(loader.load());
            stage.setTitle("editar");
            stage.setScene(escena);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }//catch
        Stage cerrar = (Stage) btnUsuario.getScene().getWindow();
        cerrar.close();
    }//boton agregar

    @FXML
    protected void btnEditar(){
        try {
            Stage stage = new Stage();//Crear una nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editar.fxml"));
            Scene escena = new Scene(loader.load());
            stage.setTitle("editar");
            stage.setScene(escena);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }//catch
    }//Boton editar

    @FXML
    protected void agregarBtn(){
        try{
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            String sql = "INSERT INTO automovil VALUES (0, '" + txtMatriculaA.getText() + "','" + txtMarcaA.getText() + "','" +
                    txtModeloA.getText() + "','" + txtColor.getText() + "')";
            System.out.println("DATOS INSERTADOS EN automovil");
            stm.execute(sql);
            String sql2 = "INSERT INTO persona VALUES (0, '" + txtNombreA.getText()+ "','" + txtPersonaA.getText() + "')";
            stm.execute(sql2);
            System.out.println("DATOS INSERTADOS EN persona");
            //actualizar();
            Stage stage = new Stage();//Crear una nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("anuncioUsuarioCreado.fxml"));
            Scene escena = new Scene(loader.load());
            stage.setTitle("editar");
            stage.setScene(escena);
            stage.showAndWait();
        }catch (Exception e){
            e.printStackTrace();
        }
        txtPersonaA.setText("");
        txtColor.setText("");
        txtNombreA.setText("");
        txtModeloA.setText("");
        txtMarcaA.setText("");
        txtMatriculaA.setText("");
        Stage cerrar = (Stage) btnG.getScene().getWindow();
        cerrar.close();
    }

    @FXML
    protected void btnSalirAgregar(){
        Stage s = (Stage) btnSalirA.getScene().getWindow();
        s.close();
    }//boton salirAgregar
}