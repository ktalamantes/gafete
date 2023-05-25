package com.example.gafete;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ingresarController  implements Initializable{
    @FXML
    private TextField txtNombreA;
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
    private Button btnSalirA;
    @FXML
    private ComboBox<personal> comPersona;

    private ObservableList<personal> lista;

    @FXML
    protected void agregarBtn(){
        try{
            Connection c = Enlace.getConexion();
            Statement stm = c.createStatement();
            // Crear una variable que va contener lo del texfield
            String matricula = txtMatriculaA.getText();
            //Hacer la expresion regular
            String cadena = "^[A-Z0-9]{7}$";

            //Utilizar el Pattern y Martcher  para presentar el patron y  y aplicar el patron
            Pattern p = Pattern.compile(cadena);
            Matcher m = p.matcher(matricula);

            // el if para validar la que la cadena este dentro del patron
            if(m.matches()) {
                String sql = "INSERT INTO registros VALUES (0, '" + txtNombreA.getText() + "','" +matricula + "','" +
                        txtMarcaA.getText() + "','" + txtModeloA.getText() + "','" + txtColor.getText() + "','" +
                        comPersona.getSelectionModel().getSelectedItem().toString() + "')";
                stm.executeUpdate(sql);


                Stage stage = new Stage();//Crear una nueva ventana
                FXMLLoader loader = new FXMLLoader(getClass().getResource("anuncioRegistroCreado.fxml"));
                Scene escena = new Scene(loader.load());
                stage.setTitle("editar");
                stage.setScene(escena);
                stage.showAndWait();

            }else {
                System.out.println("MATRICULA NO VALIDA");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Contraseña no valida");
                alert.setContentText("LA MATRICULA NO ES VALIDA");
                alert.showAndWait();
            }


        }catch (Exception e){
            e.printStackTrace();
        }


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
        lista.add(new personal("Administrativo"));
        lista.add(new personal("Gastronomia"));
        comPersona.setItems(lista);
    }
}
