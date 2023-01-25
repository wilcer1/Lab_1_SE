package com.example.lab1task1;

import javafx.scene.control.Button;

import java.io.Serializable;

public class SerializableObject implements Serializable {

    private String text;

    public SerializableObject(Button button){
        this.text = button.getText();

    }

    public String getButton(){
        return this.text;
    }

    public void setButton(Button button){
        this.text = button.getText();

    }

}
