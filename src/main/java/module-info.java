module com.example.gafete {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gafete to javafx.fxml;
    exports com.example.gafete;
}