package com.example.gafete;

import java.time.LocalTime;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;



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
    @FXML
    private TableColumn emision;
    @FXML
    private TableColumn vencimiento;


    @FXML private TextField buscar;
    @FXML
    private Button siguiente;
    @FXML
    private Button genPdf;
    @FXML
    private Label lPersona;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnFecha;
    @FXML
    private TabPane tabGeneral;
    @FXML
    private TextField txtEPropietario;
    @FXML
    private TextField txtEMarca;
    @FXML
    private TextField txtEModelo;
    @FXML
    private TextField txtEPlaca;
    @FXML
    private Label lSaludo;
    @FXML
    private DatePicker fechaV;
    @FXML
    private TextField txtEId;
    //TextField ver
    @FXML
    private TextField txtVerNombre;
    @FXML
    private TextField txtVerMatricula;





    @FXML
    private ComboBox<personal> txtEPersona;
    private Consulta idP;
    private Consulta tmpConsulta;


    private ObservableList<personal> lista;

    ObservableList<Consulta> lista2 = FXCollections.observableArrayList();
    ObservableList<ConsultaTotal> listaT = FXCollections.observableArrayList();






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



    //-------------BOTON QUE PERMITE EDITAR USUARIO/S

    @FXML
    public void editarUsuario (ActionEvent evt) {
        tabGeneral.getSelectionModel().select(0);
        try{
            tmpConsulta.setNombre(txtEPropietario.getText());
            tmpConsulta.setMatricula(txtEPlaca.getText());
            tmpConsulta.setMarca(txtEMarca.getText());
            tmpConsulta.setModelo(txtEModelo.getText());

            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            String sql = "UPDATE registros SET nombre='"+ tmpConsulta.getNombre()+  "',matricula='" + tmpConsulta.getMatricula() + "',marca='" + tmpConsulta.getMarca() +
            "',modelo='" + tmpConsulta.getModelo() + "',color='" + tmpConsulta.getColor() + "',puesto='" + tmpConsulta.getPuesto() + "'WHERE id=" + idSolicitantes ;
            //System.out.println("CAMBIOS GUARDADOS ");
            stm.execute(sql);
           refrescar();
            Stage stage = new Stage();//Crear una nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("anuncioEditar.fxml"));
            Scene escena = new Scene(loader.load());
            stage.setTitle("editar");
            stage.setScene(escena);
            stage.showAndWait();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    protected void btnSalirEditar(){
        tabGeneral.getSelectionModel().select(0);

    }//boton salir Editar





    //------------------------BASE DE DATOS--------------------------------4

    @FXML
    public void siguienteEditar(){
        tabGeneral.getSelectionModel().select(1);
        try {
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            String sql = "SELECT * FROM registros WHERE id= " + idSolicitantes;
            stm.executeQuery(sql);
            txtEPropietario.setText(idP.getNombre());
            txtEMarca.setText(idP.getMarca());
            txtEModelo.setText(idP.getModelo());
            txtEPlaca.setText(idP.getMatricula());
            txtEPersona.getSelectionModel().getSelectedItem();
            lPersona.setText(idP.getNombre().toUpperCase());
            lPersona.setVisible(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnVencimiento(ActionEvent evt){
        tabGeneral.getSelectionModel().select(3);
        try{
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            String sql = "INSERT INTO gafetes VALUES (0,'" + txtEId.getText() + "', null,'" +
                    fechaV.getValue() + "')";
            stm.executeLargeUpdate(sql);
            System.out.println("Datos insertados. ");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }
        refresh();
    }

    @FXML
    public void agregarFecha(){
        tabGeneral.getSelectionModel().select(2);
        try{
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            String sql1 = "SELECT * FROM registros WHERE id= " + idSolicitantes;
            stm.executeQuery(sql1);
            txtEId.setText(String.valueOf(idP.getId()));
            txtVerNombre.setText(idP.getNombre());
            txtVerMatricula.setText(idP.getMatricula());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public void sigueintePDF(){
        //tabGeneral.getSelectionModel().select(2);
        Document documento = new Document(PageSize.A4);
        try{
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "\\OneDrive\\Escritorio\\PDF\\" +
                    idP.getMatricula() + ".pdf"));
            //-------------------------------CREACION DE IMAGENES-------------------------------------------------------
            //Imagen alumno parte frontal
            Image iAlumnoF = Image.getInstance("src\\main\\resources\\com\\example\\gafete\\alumno1.jpg");
            iAlumnoF.scaleToFit(400, 250);
            iAlumnoF.setAlignment(Chunk.ALIGN_CENTER);
            //Imagen alumno posterior
            Image iAlumnoP = Image.getInstance("src\\main\\resources\\com\\example\\gafete\\alumno2.jpg");
            iAlumnoP.scaleToFit(400, 250);
            iAlumnoP.setAlignment(Chunk.ALIGN_CENTER);

            Image iMaestro = Image.getInstance("src\\main\\resources\\com\\example\\gafete\\maestro1.jpg");
            iMaestro.scaleToFit(400, 250);
            iMaestro.setAlignment(Chunk.ALIGN_CENTER);
            //Imagen alumno posterior
            Image iMaestroP = Image.getInstance("src\\main\\resources\\com\\example\\gafete\\maestro2.jpg");
            iMaestroP.scaleToFit(400, 250);
            iMaestroP.setAlignment(Chunk.ALIGN_CENTER);

            //Imagen administrativo frontal
            Image iAdministrativo = Image.getInstance("src\\main\\resources\\com\\example\\gafete\\admin1.jpg");
            iAdministrativo.scaleToFit(400, 250);
            iAdministrativo.setAlignment(Chunk.ALIGN_CENTER);
            //Imagen adiministrativo posterior
            Image iAdministrativoP = Image.getInstance("src\\main\\resources\\com\\example\\gafete\\admin2.jpg");
            iAdministrativoP.scaleToFit(400, 250);
            iAdministrativoP.setAlignment(Chunk.ALIGN_CENTER);

            //Imagen cafe frontal
            Image iCafe = Image.getInstance("src\\main\\resources\\com\\example\\gafete\\cafe1.jpg");
            iCafe.scaleToFit(400, 250);
            iCafe.setAlignment(Chunk.ALIGN_CENTER);
            //Imagen cafe posterior
            Image iCafeP = Image.getInstance("src\\main\\resources\\com\\example\\gafete\\cafe2.jpg");
            iCafeP.scaleToFit(400, 250);
            iCafeP.setAlignment(Chunk.ALIGN_CENTER);

            //Imagen cafe frontal
            Image iGasF = Image.getInstance("src\\main\\resources\\com\\example\\gafete\\gas1.jpg");
            iGasF.scaleToFit(400, 250);
            iGasF.setAlignment(Chunk.ALIGN_CENTER);
            //Imagen cafe posterior
            Image iGasP = Image.getInstance("src\\main\\resources\\com\\example\\gafete\\gas2.jpg");
            iGasP.scaleToFit(400, 250);
            iGasP.setAlignment(Chunk.ALIGN_CENTER);
            //--------------------------------FIN CREACION DE IMAGENES--------------------------------------------------

            //Se crea metodo para agregar texto en la hoja así mismo como agregarle estilo de fuente y alineacion
            Paragraph matricula = new Paragraph();
            matricula.setAlignment(Paragraph.ALIGN_CENTER);
            matricula.add("\n\n\n\n\n  "+idP.getMatricula().toUpperCase());
            matricula.add("\n\n\n"+idP.getMarca().toUpperCase()+"/");
            matricula.add(idP.getModelo().toUpperCase());
            matricula.setFont(FontFactory.getFont("Tahoma",14,Font.BOLD,BaseColor.BLACK));




            //Se crean if para saber si el puesto es de cada departamento
            if(idP.getPuesto().equals("Alumno")){
                documento.open();
                iAlumnoF.setAbsolutePosition(80f, 600f);
                iAlumnoP.setAbsolutePosition(80f, 300f);
                documento.add(iAlumnoF);
                documento.add(iAlumnoP);
                documento.add(matricula);

            } else if (idP.getPuesto().equals("Maestro")) {
                documento.open();
                iMaestro.setAbsolutePosition(80f, 600f);
                iMaestroP.setAbsolutePosition(80f, 300f);
                documento.add(iMaestro);
                documento.add(iMaestroP);

                documento.add(matricula);
            } else if (idP.getPuesto().equals("Administrativo")) {
                documento.open();
                iAdministrativo.setAbsolutePosition(80f, 600f);
                iAdministrativoP.setAbsolutePosition(80f, 300f);
                documento.add(iAdministrativo);
                documento.add(iAdministrativoP);
                documento.add(matricula);

            } else if (idP.getPuesto().equals("Cafeteria")) {
                documento.open();
                iAlumnoF.setAbsolutePosition(80f, 600f);
                iAlumnoP.setAbsolutePosition(80f, 300f);
                documento.add(iCafe);
                documento.add(iCafeP);
                documento.add(matricula);

            } else if (idP.getPuesto().equals("Gastronomia")) {
                documento.open();
                iGasF.setAbsolutePosition(80f, 600f);
                iGasP.setAbsolutePosition(80f, 300f);
                documento.add(iGasF);
                documento.add(iGasP);
                documento.add(matricula);
                //documento.add(marca);
                //documento.add(modelo);
            } 

            try {
                Connection c = Enlace.getConexion();
                Statement stm = c.createStatement();
                String sql = "SELECT matricula, marca, modelo FROM registros WHERE id =" + idSolicitantes;
                ResultSet r = stm.executeQuery(sql);

            }catch (SQLException e){
                //e.printStackTrace();
                System.out.println("Error en la conexión " + e);
            }
            documento.close();
            System.out.println("Documento creado. ");
            Stage stage = new Stage();//Crear una nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("anuncioDescargaLista.fxml"));
            Scene escena = new Scene(loader.load());
            stage.setTitle("");
            stage.setScene(escena);
            stage.showAndWait();
        }catch (DocumentException | FileNotFoundException e){
            //e.printStackTrace();
            System.out.println("Error en PDF " + e);
        }catch (IOException e){
            //e.printStackTrace();
            System.out.println("Error en la imagen " + e);
        }
    }

    @FXML
    public void cerrarSql(){
        try {
            Connection c = Enlace.closeConexion();
            System.exit(0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void eliminarPersona(ActionEvent evt){
       try{
           if(idP != null){
               lista2.remove(idP);
               Connection c = Enlace.getConexion();
               Statement stm = c.createStatement();
               String sql = "DELETE FROM registros WHERE id= " + idSolicitantes;
               stm.executeLargeUpdate(sql);
           }
           System.out.println("Se ha eliminado a la matricula: " + idP.getMatricula());
           Stage stage = new Stage();//Crear una nueva ventana
           FXMLLoader loader = new FXMLLoader(getClass().getResource("anuncioEliminado.fxml"));
           Scene escena = new Scene(loader.load());
           stage.setTitle(""+idP.getMatricula());
           stage.setScene(escena);
           stage.showAndWait();
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
            btnEliminar.setDisable(false);
            btnFecha.setDisable(false);
        }
    }

    //-----------------------------------------PRUEBA----------------------------------------



    //-------------------------------------FIN PRUEBA------------------------------------------


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
            stm.execute(sql);
            //tablita.refresh();
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

    @FXML
    private void actualizarTotal(){
        try {
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            String sql = "SELECT * FROM registros INNER JOIN gafetes ON registros.id = gafetes.id";
            //String sql = "SELECT * FROM automovil INNER JOIN persona ON automovil.id = persona.id";
            ResultSet r = stm.executeQuery(sql);
            listaT.clear();
            while (r.next()){
                tabla2.setItems(listaT);
                listaT.add(new ConsultaTotal(r.getInt("id"),
                        r.getString("nombre"),
                        r.getString("matricula"),
                        r.getString("marca"),
                        r.getString("modelo"),
                        r.getString("color"),
                        r.getString("puesto"),
                        r.getDate("fecha_emision"),
                        r.getDate("fecha_vencimiento")));
                id2.setCellValueFactory(new PropertyValueFactory<>("id"));
                System.out.println(r.getString("id"));
                propietario2.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                placas2.setCellValueFactory(new PropertyValueFactory<>("matricula"));
                marca2.setCellValueFactory(new PropertyValueFactory<>("marca"));
                modelo2.setCellValueFactory(new PropertyValueFactory<>("modelo"));
                color2.setCellValueFactory(new PropertyValueFactory<>("color"));
                persona2.setCellValueFactory(new PropertyValueFactory<>("puesto"));
                emision.setCellValueFactory(new PropertyValueFactory<>("fecha_emision"));
                vencimiento.setCellValueFactory(new PropertyValueFactory<>("fecha_vencimiento"));
            }
            stm.close();
            tabla2.refresh();
        }catch (Exception e){
            e.printStackTrace();
        }
        //tabla.refresh();
    }

    @FXML
    private void refresh(){
        try {
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            String sql = "SELECT * FROM registros INNER JOIN gafetes ON registros.id = gafetes.id";
            //String sql = "SELECT * FROM automovil INNER JOIN persona ON automovil.id = persona.id";
            ResultSet r = stm.executeQuery(sql);
            listaT.clear();
            while (r.next()){
                tabla2.setItems(listaT);
                listaT.add(new ConsultaTotal(r.getInt("id"),
                        r.getString("nombre"),
                        r.getString("matricula"),
                        r.getString("marca"),
                        r.getString("modelo"),
                        r.getString("color"),
                        r.getString("puesto"),
                        r.getDate("fecha_emision"),
                        r.getDate("fecha_vencimiento")));
                id2.setCellValueFactory(new PropertyValueFactory<>("id"));
                System.out.println(r.getString("id"));
                propietario2.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                placas2.setCellValueFactory(new PropertyValueFactory<>("matricula"));
                marca2.setCellValueFactory(new PropertyValueFactory<>("marca"));
                modelo2.setCellValueFactory(new PropertyValueFactory<>("modelo"));
                color2.setCellValueFactory(new PropertyValueFactory<>("color"));
                persona2.setCellValueFactory(new PropertyValueFactory<>("puesto"));
                emision.setCellValueFactory(new PropertyValueFactory<>("fecha_emision"));
                vencimiento.setCellValueFactory(new PropertyValueFactory<>("fecha_vencimiento"));
            }
            stm.close();
            tabla2.refresh();
        }catch (Exception e){
            e.printStackTrace();
        }
        //tabla.refresh();
    }



    //------------------------FIN BASE DE DATOS--------------------------------


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

    public void saludos(){
        LocalTime horalLocal = LocalTime.now();

        int hora = horalLocal.getHour();
        String saludo = "";
        if(hora >= 6 && hora < 12){
            saludo = "¡Buenos días!";
        } else if (hora >= 12 && hora < 20) {
            saludo = "¡Buenas tardes!";
        } else if (hora >=20 && hora <22) {
            saludo = "¡Buenas noches!";
        } else if (hora >= 22 && hora <6) {
            saludo = "¡Buena madrugada!";
        }
        lSaludo.setText(saludo);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lista= FXCollections.observableArrayList();
        lista.add(new personal("Maestro"));
        lista.add(new personal("Alumno"));
        lista.add(new personal("Cafeteria"));
        lista.add(new personal("Admnistrativo"));
        lista.add(new personal("Gastronomia"));
        txtEPersona.setItems(lista);
        actualizar();
        refrescar();
        saludos();
        actualizarTotal();
    }

}
