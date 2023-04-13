package com.example.lab1task2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SenderController {

    @FXML
    private Button sendButton;

    @FXML
    private TextField textField;

    @FXML
    private Label welcomeText;

    @FXML
    void sendButton(ActionEvent event) {
        Button sendButton = new Button(textField.getText());
        SerializableObject object = new SerializableObject(sendButton);
        try {
            Socket socket = new Socket("localhost", 5555);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(object);
            out.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

