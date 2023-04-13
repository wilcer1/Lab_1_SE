package com.example.lab1task2;

import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Sender extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Receiver.class.getResource("sender-view.fxml"));
        stage.setTitle("Sender");
        stage.setScene(new Scene(fxmlLoader.load(), 300, 250));
        stage.show();
    }

    public static void main(String[] args) {
        launch(Sender.class);
    }
}

