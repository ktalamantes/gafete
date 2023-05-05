package com.example.gafete;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
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
    private ObservableList<personal> lista;

    @FXML
    protected void agregarBtn(){
        try{
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            String sql = "INSERT INTO automovil VALUES (0, '" + txtMatriculaA.getText() + "','" + txtMarcaA.getText() + "','" +
                    txtModeloA.getText() + "','" + txtColor.getText() + "')";
            System.out.println("DATOS INSERTADOS EN automovil");
            stm.execute(sql);
            String sql2 = "INSERT INTO persona VALUES (0, '" + txtNombreA.getText()+ "','" +
                    comPersona.getSelectionModel().getSelectedItem().toString() + "')";
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
