module com.example.gafete {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires itextpdf;
    requires barcodes;
    requires layout;
    requires kernel;
    requires core;


    opens com.example.gafete to javafx.fxml;
    exports com.example.gafete;

}