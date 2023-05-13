module com.example.gafete {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires itextpdf;


    opens com.example.gafete to javafx.fxml;
    exports com.example.gafete;

}