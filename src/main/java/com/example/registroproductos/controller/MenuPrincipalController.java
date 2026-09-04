package com.example.registroproductos.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalController {
    @FXML
    private void abrirMenuProductos(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/registroproductos/registro-productos.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Menu Productos");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void abrirMenuReporte(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/registroproductos/hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Menu Reportes");
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    private void abrirMenuClientes(ActionEvent event) throws IOException{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Menu Clientes");
        alert.setHeaderText("Clientes");
        alert.setContentText("Clientes");
        alert.showAndWait();
    }
    @FXML
    private void cerrarApp(ActionEvent event)throws IOException{
        Platform.exit();
    }
}
