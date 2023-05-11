package com.example.gafete;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class ingresarController implements Initializable {
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
    private ComboBox<personal> comPersona;
    @FXML
    private DatePicker fechaV;
    @FXML
    private DatePicker fechaE;
    private ObservableList<personal> lista;

    @FXML
    protected void agregarBtn(){
        LocalDateTime diaActual = LocalDateTime.now();
        try{
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            /*
            String sql = "INSERT INTO registros VALUES (0, '" + txtMatriculaA.getText() + "','" + txtMarcaA.getText() + "','" +
                    txtModeloA.getText() + "','" + txtColor.getText() + "')";
            stm.execute(sql);
            String sql2 = "INSERT INTO persona VALUES (0, '" + txtNombreA.getText()+ "','" +
                    comPersona.getSelectionModel().getSelectedItem().toString() + "')";
            stm.execute(sql2);
             */
            String sql = "INSERT INTO registros VALUES (0, '" + txtNombreA.getText() + "','" + txtMatriculaA.getText() + "','" +
                    txtMarcaA.getText() + "','" + txtModeloA.getText() + "','" + txtColor.getText() + "','" +
                    comPersona.getSelectionModel().getSelectedItem().toString() + "')";
            stm.execute(sql);
            //String sql1 = "INSERT INTO gafetes VALUES (0, 1'" + diaActual + "','" + fechaV.getValue() + "')";
            String sql1 = "INSERT INTO gafetes VALUES (0, 3'" + fechaV.getValue() + "')";
            stm.execute(sql1);
            System.out.println("DATOS INSERTADOS EN persona");

            Stage stage = new Stage();//Crear una nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("anuncioRegistroCreado.fxml"));
            Scene escena = new Scene(loader.load());
            stage.setTitle("editar");
            stage.setScene(escena);
            stage.showAndWait();
            //actualizar();


        }catch (Exception e){
            e.printStackTrace();
        }
        /*
        txtPersonaA.setText("");
            txtColor.setText("");
            txtNombreA.setText("");
            txtModeloA.setText("");
            txtMarcaA.setText("");
            txtMatriculaA.setText("");
         */
        Stage cerrar = (Stage) btnG.getScene().getWindow();
        cerrar.close();
    }

    @FXML
    protected void btnSalirAgregar(){
        Stage s = (Stage) btnSalirA.getScene().getWindow();
        s.close();
    }//boton salirAgregar


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lista= FXCollections.observableArrayList();
        lista.add(new personal("Maestro"));
        lista.add(new personal("Alumno"));
        lista.add(new personal("Cafeteria"));
        lista.add(new personal("Admnistrativo"));
        lista.add(new personal("Gastronomia"));
        comPersona.setItems(lista);
    }
}
