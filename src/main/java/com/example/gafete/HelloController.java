package com.example.gafete;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private ImageView agregarImagen;
    @FXML
    private ImageView editarImagen;
    @FXML private ImageView tec;
    @FXML private ImageView candado1;
    @FXML private ImageView gamoss;
    @FXML
    private Button btnSalirA;
    @FXML
    private Button btnSalirE;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField usuario;
    @FXML
    private PasswordField contrasenia;
    @FXML
    private CheckBox box;
    @FXML
    private ImageView ojo;


    //--------------------Validar contraseña e ingresar----------------------------------
    @FXML
    protected void btnValidar(){
        if (usuario.getText().equals("Administrador") && contrasenia.getText().equals("12345")){
            try {
                Stage stage = new Stage();//Crear una nueva ventana
                FXMLLoader loader = new FXMLLoader(getClass().getResource("gafete.fxml"));
                Scene escena = new Scene(loader.load());
                stage.setTitle("editar");
                stage.setScene(escena);
                stage.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
            }//catch
        }else {
            System.out.println("ACCESO DENEGADO");
        }
    }//----------------Boton validar-------------------------------

    //-------------Muestra la contraseña-------------
    @FXML
    void changeVisiility(ActionEvent event){
        if(box.isSelected()){
            txtUsuario.setText(contrasenia.getText());
            txtUsuario.setVisible(true);
            contrasenia.setVisible(false);
            return;
        }
        contrasenia.setText(txtUsuario.getText());
        contrasenia.setVisible(true);
        txtUsuario.setVisible(false);
    }//Ver contraseña


    //------------METODO QUE ABRE "CUENTA" DANDO CLICK EN IMAGEN-------------------
    @FXML
    protected void imagenAgregar(){
        try {
            Stage stage = new Stage();//Crear una nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Scene escena = new Scene(loader.load());
            stage.setTitle("editar");
            stage.setScene(escena);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();

        }//catch
    }//Imagen Agregar

    //------------METODO QUE ABRE "AGREGAR" DANDO CLICK EN IMAGEN-------------------
    @FXML
    protected void imagenCuenta(){
        try {
            Stage stage = new Stage();//Crear una nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Agregar.fxml"));
            Scene escena = new Scene(loader.load());
            stage.setTitle("cuenta");
            stage.setScene(escena);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();

        }//catch
    }//Imagen cuenta

    //-----------BOTON QUE AGREGA USUARIO------------
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
    }//boton agregar

    //-------------BOTON QUE PERMITE EDITAR USUARIO/S
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

    //-----------------Boton salir en ventana de agregar-------------------
    @FXML
    protected void btnSalirAgregar(){
        Stage s = (Stage) btnSalirA.getScene().getWindow();
        s.close();
    }//boton salirAgregar

    @FXML
    protected void btnSalirEditar(){
        Stage s = (Stage) btnSalirE.getScene().getWindow();
        s.close();
    }
}