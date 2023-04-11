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
import javafx.stage.Stage;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
    @FXML
    private TableView tabla;
    @FXML
    private TableColumn id;
    @FXML
    private TableColumn propietario;
    @FXML
    private TableColumn marca;
    @FXML
    private TableColumn modelo;
    @FXML
    private TableColumn placas;
    @FXML
    private TableColumn persona;
    ObservableList<Consulta> lista = FXCollections.observableArrayList();


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

    @FXML
    protected void initialize() {
        actualizar();
    }

    //------------------------BASE DE DATOS--------------------------------
    @FXML
    private void actualizar(){
        try {
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            String sql = "SELECT personales.id, personales.nombre, personales.puesto, automoviles.matricula, " +
                    "automoviles.modelo, automoviles.marca FROM personales INNER JOIN automoviles;";
            ResultSet r = stm.executeQuery(sql);
            //lista.clear();
            while (r.next()){
                lista.add(new Consulta(r.getInt("id"),r.getString("nombre"), r.getString("marca"), r.getString("modelo"), r.getString("matricula"), r.getString("puesto")));
                id.setCellValueFactory(new PropertyValueFactory<>("id"));
                propietario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
                modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
                placas.setCellValueFactory(new PropertyValueFactory<>("matricula"));
                persona.setCellValueFactory(new PropertyValueFactory<>("puesto"));
                tabla.setItems(lista);
            }
            stm.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //------------------------FIN BASE DE DATOS--------------------------------

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
    //----------------FIN BOTONES SALIR-----------------------------------
}