package com.example.teste_javafx;

import com.example.teste_javafx.utils.PathFXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(new FileInputStream(PathFXML.pathFXML() + "\\MainView.fxml" ));
        Scene scene = new Scene(root, 800, 400);
        stage.setTitle("Bem-vindo à calculadora de Índice de Massa Corporal!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}