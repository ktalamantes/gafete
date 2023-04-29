package com.example.gafete;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class loginController {
    @FXML
    private TextField txtCorreoSesion;
    @FXML
    private TextField txtContraseniaSesion;
    @FXML
    private PasswordField pswContraseniaSesion;
    @FXML
    private Button btnIngresarSesion;
    @FXML
    private ImageView ojoVer;
    @FXML
    private ImageView ojoOcultar;

    @FXML
    protected void btnValidar(){
        if (txtCorreoSesion.getText().equals("admin") && pswContraseniaSesion.getText().equals("12345") ||
                txtContraseniaSesion.getText().equals("12345")){
            try {
                Stage stage = new Stage();//Crear una nueva ventana
                FXMLLoader loader = new FXMLLoader(getClass().getResource("inicio.fxml"));
                Stage cerrar = (Stage) btnIngresarSesion.getScene().getWindow();
                cerrar.close();
                Scene escena = new Scene(loader.load());
                stage.setTitle("editar");
                stage.setScene(escena);
                stage.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
            }//catch
        }else {
            System.out.println("ACCESO DENEGADO");
            //errorContraseña.setVisible(true);
            //erroContraR.setVisible(true);
        }
    }

    @FXML
    public void mostrarContra(){
        if (ojoVer.isVisible()){
            ojoVer.setVisible(false);
            ojoOcultar.setVisible(true);
            txtContraseniaSesion.setVisible(true);
            pswContraseniaSesion.setVisible(false);
            txtContraseniaSesion.setText(pswContraseniaSesion.getText());
        } else if (ojoOcultar.isVisible()) {
            ojoOcultar.setVisible(false);
            ojoVer.setVisible(true);
            txtContraseniaSesion.setVisible(false);
            pswContraseniaSesion.setVisible(true);
            pswContraseniaSesion.setText(txtContraseniaSesion.getText());
        }
    }
}
