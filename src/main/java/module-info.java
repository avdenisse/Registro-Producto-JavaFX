module com.example.registroproductos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.registroproductos.controller to javafx.fxml;
    opens com.example.registroproductos.model to javafx.base;
    opens com.example.registroproductos to javafx.fxml;
    exports com.example.registroproductos;
}