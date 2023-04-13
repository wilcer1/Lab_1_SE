package com.example.lab1task2;

import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Sender extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sender-view.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("Sender");
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }

    public static void main(String[] args) {
        launch(Sender.class);
    }
}

