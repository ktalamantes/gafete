package com.example.gafete;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;

public class nuevoController implements Initializable {
    @FXML
    private TableView tabla2;
    @FXML
    private TableColumn id2;
    @FXML
    private TableColumn propietario2;
    @FXML
    private TableColumn marca2;
    @FXML
    private TableColumn modelo2;
    @FXML
    private TableColumn placas2;
    @FXML
    private TableColumn color2;
    @FXML
    private TableColumn persona2;
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

    @FXML private TextField prop;
    @FXML private TextField mar;
    @FXML private TextField mod;
    @FXML private TextField pla;
    @FXML private TextField per;
    @FXML private TextField buscar;
    @FXML
    private Button siguiente;
    @FXML
    private Button genPdf;
    @FXML
    private Button btnCerrarLogin;
    @FXML
    private Tab tabEditar;
    @FXML
    private TabPane tabGeneral;
    private Consulta idP;
    private Consulta tmpConsulta;



    ObservableList<Consulta> lista2 = FXCollections.observableArrayList();





    //------------METODO QUE ABRE "CUENTA" DANDO CLICK EN IMAGEN-------------------
    @FXML
    public  void imagenAgregar(){
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
    public void imagenCuenta(){
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
    protected void cerrarSesion(){
        try {
            Stage stage = new Stage();//Crear una nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inicioSesion.fxml"));
            Stage cerrar = (Stage) btnCerrarLogin.getScene().getWindow();
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




    //------------------------BASE DE DATOS--------------------------------4

    @FXML
    public void siguienteEditar(){
        tabGeneral.getSelectionModel().select(1);
    }
    @FXML
    public void sigueintePDF(){
        //tabGeneral.getSelectionModel().select(2);
        Document documento = new Document();
        try{
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "\\OneDrive\\Escritorio\\usuarios2.pdf"));
            documento.open();

            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("id");
            tabla.addCell("nombre");
            tabla.addCell("matricula");
            tabla.addCell("marca");
            tabla.addCell("modelo");
            tabla.addCell("color");
            tabla.addCell("persona");

            try {
                Connection c = Enlace.getConexion();
                Statement stm = c.createStatement();
                String sql = "SELECT * FROM registros WHERE id = '1'";
                ResultSet r = stm.executeQuery(sql);
               while (r.next()){
                   tabla.addCell(r.getString(1));
                   tabla.addCell(r.getString(2));
                   tabla.addCell(r.getString(3));
                   tabla.addCell(r.getString(4));
                   tabla.addCell(r.getString(5));
                   tabla.addCell(r.getString(6));
                   tabla.addCell(r.getString(7));
               }
               documento.add(tabla);
                System.out.println("Documento creado. ");

            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //METODO PARA SELECCIONAR EN LA TABLA SOLICITANTES
    int idSolicitantes;
    @FXML
    public void ClickTablaSolicitantes(MouseEvent evt) {
        if (evt.getClickCount() >= 1) {
            idP = (Consulta) tablita.getSelectionModel().getSelectedItem();
            tmpConsulta = idP;
            idSolicitantes = idP.getId();
            System.out.println("Se ha seleccionado el solicitante");
            System.out.println("ID: " + idP.getId());
            genPdf.setDisable(false);
            siguiente.setDisable(false);
        }
    }


    @FXML
    private void refrescar(){
        try {
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            String sql = "SELECT * FROM registros";
            //String sql = "SELECT * FROM automovil INNER JOIN persona ON automovil.id = persona.id";
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
            tablita.refresh();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void actualizar(){
        try {
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            String sql = "SELECT * FROM registros";
            //String sql = "SELECT * FROM automovil INNER JOIN persona ON automovil.id = persona.id";
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
            tablita.refresh();
        }catch (Exception e){
            e.printStackTrace();
        }
        //tabla.refresh();
    }



    //------------------------FIN BASE DE DATOS--------------------------------




    //EDITAR DANDO DOBLE CLICK
    public void dobleclick(MouseEvent mevt){
        if(mevt.getClickCount()>2){
            if(tablita.getSelectionModel().getSelectedItem()!=null){
                try{
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("editar.fxml"));
                    Scene scene = new Scene(loader.load());
                    stage.setScene(scene);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    editarController ec = loader.getController();
                    Consulta cdb = (Consulta) tablita.getSelectionModel().getSelectedItem();
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
                tablita.setItems(lista2);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        actualizar();
        refrescar();
    }
}
