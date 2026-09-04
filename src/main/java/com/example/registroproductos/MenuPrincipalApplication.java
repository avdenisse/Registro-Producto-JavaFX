package com.example.registroproductos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalApplication extends Application {
    public static void main(String[]args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu-principal-1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Bienvenido al sistema de registros");
        stage.setScene(scene);
        stage.show();
    }
}


