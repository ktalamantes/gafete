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

public class nuevoController {
    @FXML
    private ImageView candado1;
    @FXML
    private ImageView gamoss;
    @FXML
    private Button btnSalirA;
    @FXML
    private Button btnSalirE;
    @FXML
    private TableView tabla;
    @FXML
    private TableView tablita;
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
    private TableColumn color;
    @FXML
    private TableColumn persona;
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
    private TextField txtAnioA;
    @FXML
    private Button btnValidar;

    @FXML private TextField prop;
    @FXML private TextField mar;
    @FXML private TextField mod;
    @FXML private TextField pla;
    @FXML private TextField per;
    @FXML
    private Label errorContraseña;
    @FXML
    private Rectangle erroContraR;
    @FXML
    private Button btnCerrarSesion;

    @FXML private TextField buscar;
    @FXML
    private Button btnG;
    @FXML
    private Button btnSesion;

    @FXML private TextField txtnombre;


    @FXML private TextField txtcorreo;


    @FXML private TextField txtcontraseña;


    @FXML private Button registrar;

    @FXML private Button CerrarVentana;

    ObservableList<Consulta> lista2 = FXCollections.observableArrayList();




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

    @FXML
    protected void cerrarSesion(){
        try {
            Stage stage = new Stage();//Crear una nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Stage cerrar = (Stage) btnCerrarSesion.getScene().getWindow();
            cerrar.close();
            Scene escena = new Scene(loader.load());
            stage.setTitle("editar");
            stage.setScene(escena);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }//catch
    }

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
    protected void btnRegistar(){
        HelloApplication.setVista("Registro");
    }

    @FXML
    protected void initialize() {
        actualizar();
    }


    //------------------------BASE DE DATOS--------------------------------
    @FXML
    private void refrescar(){
        try {
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            //String sql = "SELECT * FROM registros";
            String sql = "SELECT * FROM automovil INNER JOIN persona ON automovil.id = persona.id";
            ResultSet r = stm.executeQuery(sql);
            lista2.clear();
            while (r.next()){
                tablita.setItems(lista2);
                lista2.add(new Consulta(r.getInt("id"),
                        r.getString("nombre"),
                        r.getString("matricula"),
                        r.getString("marca"),
                        r.getString("modelo"),
                        r.getString("color"),
                        r.getString("puesto")));
                id.setCellValueFactory(new PropertyValueFactory<>("id"));
                System.out.println(r.getString("id"));
                propietario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                placas.setCellValueFactory(new PropertyValueFactory<>("matricula"));
                marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
                modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
                color.setCellValueFactory(new PropertyValueFactory<>("color"));
                persona.setCellValueFactory(new PropertyValueFactory<>("puesto"));
            }
            stm.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void actualizar(){
        try {
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            //String sql = "SELECT * FROM registros";
            String sql = "SELECT * FROM automovil INNER JOIN persona ON automovil.id = persona.id";
            ResultSet r = stm.executeQuery(sql);
            lista2.clear();
            while (r.next()){
                tablita.setItems(lista2);
                lista2.add(new Consulta(r.getInt("id"),
                        r.getString("nombre"),
                        r.getString("matricula"),
                        r.getString("marca"),
                        r.getString("modelo"),
                        r.getString("color"),
                        r.getString("puesto")));
                id.setCellValueFactory(new PropertyValueFactory<>("id"));
                System.out.println(r.getString("id"));
                propietario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                placas.setCellValueFactory(new PropertyValueFactory<>("matricula"));
                marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
                modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
                color.setCellValueFactory(new PropertyValueFactory<>("color"));
                persona.setCellValueFactory(new PropertyValueFactory<>("puesto"));
            }
            stm.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //tabla.refresh();

    }

    @FXML
    protected void agregarUsuario(ActionEvent evt){
        try {
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            String sql = "INSERT INTO registros VALUES (0, '" + txtNombreA.getText() + "','" + txtMatriculaA.getText() + "','" +
                    txtMarcaA.getText() + "','" + txtModeloA.getText() + "','" + txtColor.getText() + "','" +
                    txtPersonaA.getText() + "')";
            System.out.println("DATOS INSERTADOS");
            stm.execute(sql);
            actualizar();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e+ "No se insertaron datos!!\n");
        }
        txtPersonaA.setText("");
        txtColor.setText("");
        txtNombreA.setText("");
        txtModeloA.setText("");
        txtMarcaA.setText("");
        txtMatriculaA.setText("");
        tabla.refresh();
    }
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
            actualizar();
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
    protected void agregarAuto(ActionEvent evt){
        try {
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            /*String sql = "INSERT INTO automovil VALUES (0, '" + txtMatriculaA.getText() + "','" + txtPersonaA.getText() + "')";
             */
            String sql = "INSERT INTO automovil VALUES (0, '" + txtMatriculaA.getText() + "','" + txtMarcaA.getText() + "','" +
                    txtModeloA.getText() + "','" + txtColor.getText() + "')";
            System.out.println("DATOS INSERTADOS");
            stm.execute(sql);
            actualizar();
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


    //EDITAR DANDO DOBLE CLICK
    public void dobleclick(MouseEvent mevt){
        if(mevt.getClickCount()>1){
            if(tablita.getSelectionModel().getSelectedItem()!=null){
                try{
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("editar.fxml"));
                    Scene scene = new Scene(loader.load());
                    stage.setScene(scene);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    editarController ec = loader.getController();
                    ConsultaDB cdb = (ConsultaDB) tablita.getSelectionModel().getSelectedItem();
                    ec.setId(cdb.getId());
                    try{
                        Connection c = Enlace.getConexion();
                        Statement stm = c.createStatement();
                        String sql = "SELECT * FROM registros WHERE id = '"+cdb.getId()+"';";
                        ResultSet r = stm.executeQuery(sql);
                        while (r.next()){

                            prop.setText(r.getString("prop"));
                            mar.setText(r.getString("mar"));
                            mod.setText(r.getString("mod"));
                            pla.setText(r.getString("pla"));
                            per.setText(r.getString("per"));

                        }
                        stm.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    stage.show();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    public void buscarMatricula(KeyEvent evt) {
        Connection c = Enlace.getConexion();
        try {
            Statement stm = c.createStatement();
            String sql = "SELECT * FROM registros WHERE matricula LIKE '" + buscar.getText() + "%'";
            ResultSet r = stm.executeQuery(sql);
            lista2.clear();
            while (r.next()) {
                tabla.setItems(lista2);
                lista2.add(new Consulta(r.getInt("id"), r.getString("Nombre"),
                        r.getString("matricula"), r.getString("marca"),
                        r.getString("modelo"), r.getString("color"), r.getString("puesto")));
                id.setCellValueFactory(new PropertyValueFactory<>("id"));
                propietario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                placas.setCellValueFactory(new PropertyValueFactory<>("matricula"));
                marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
                modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
                color.setCellValueFactory(new PropertyValueFactory<>("color"));
                persona.setCellValueFactory(new PropertyValueFactory<>("puesto"));

            }
            stm.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // ----Buton De Registrar Usuario----
    @FXML
    protected void RegistrarUsuario (ActionEvent evt){
        try {
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            String sql = "INSERT INTO usuarios VALUES (0, '" + txtnombre.getText() + "','" + txtcorreo.getText() + "','" +
                    txtcontraseña.getText() + "')";
            System.out.println("DATOS INSERTADOS");
            stm.execute(sql);
            actualizar();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e+ "No se insertaron datos!!\n");
        }
        txtnombre.setText("");
        txtcorreo.setText("");
        txtcontraseña.setText("");

        HelloApplication.setVista("login");

    }

    @FXML
    public void CerrarAgregar(){
        HelloApplication.setVista("Login");
    }
}
