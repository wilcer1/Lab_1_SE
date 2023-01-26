package com.example.lab1task1;

import javafx.scene.control.Button;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Stack;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Sender extends Application {
    FileOutputStream fos = null;
    ObjectOutputStream out = null;
    String filename = "javafxobject.ser";
    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Send Button");

        StackPane root = new StackPane();
        TextField textField = new TextField();
        textField.setPromptText("Enter text");

        button.setOnAction(e -> {
            Button sendButton = new Button(textField.getText());
            SerializableObject object = new SerializableObject(sendButton);
            try {
                fos = new FileOutputStream(filename);
                out = new ObjectOutputStream(fos);
                out.writeObject(object);
                out.close();
            } catch(IOException ex){
                ex.printStackTrace();
            }
        });
        root.getChildren().add(textField);
        root.getChildren().add(button);
        StackPane.setAlignment(button, javafx.geometry.Pos.BOTTOM_CENTER);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(Sender.class);
    }
}

