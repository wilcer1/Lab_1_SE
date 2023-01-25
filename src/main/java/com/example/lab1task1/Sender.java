package com.example.lab1task1;

import javafx.scene.control.Button;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Stack;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Sender extends Application {
    @Override
    public void start(Stage primaryStage) {
        String filename = "javafxobject.ser";
        Button button = new Button("Sender Button");
        SerializableObject object = new SerializableObject(button);

        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(object);
            out.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
        StackPane root = new StackPane();
        root.getChildren().add(button);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(Sender.class);
    }
}

