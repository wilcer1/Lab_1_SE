package com.example.lab1task1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Stack;

public class Receiver extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage.setTitle("Hello!");
        Button button = new Button();
        button.setText("Receiver Button");
        BorderPane root = new BorderPane();
        root.setTop(button);
        Scene scene = new Scene(root, 320, 240);
        stage.setScene(scene);

        ListView<Button> listView = new ListView<>();
        BorderPane.setAlignment(listView, Pos.BOTTOM_CENTER);
        BorderPane.setMargin(listView, new Insets(10));
        button.setOnAction(e -> {
            Button senderButton = getButton();
            listView.getItems().add(senderButton);
            if (!root.getChildren().contains(listView)) {
                root.setCenter(listView);
            }
        });

        stage.show();
    }
    public static Button getButton(){
        String filename = "javafxobject.ser";

        SerializableObject button = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            button = (SerializableObject) in.readObject();
            in.close();
        } catch(IOException ex){
            ex.printStackTrace();
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }

        return new Button(button.getText());
    }

    public static void main(String[] args) {
        launch();
    }
}