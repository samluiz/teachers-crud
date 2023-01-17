package com.saurs.teacherscrud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    private static Stage primaryStage;
    private static Scene mainScene;
    @Override
    public void start(Stage stage) {
        try {
            URL fxmlLocation = getClass().getResource("Main.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            ScrollPane scrollPane = loader.load();
            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);
            mainScene = new Scene(scrollPane);
            stage.setScene(mainScene);
            stage.setTitle("Professores");
            stage.setResizable(false);
            stage.show();
            primaryStage = stage;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Scene getMainScene() {
        return mainScene;
    }
    public static Stage getPrimaryStage() { return primaryStage; }

    public static void main(String[] args) {
        launch();
    }
}