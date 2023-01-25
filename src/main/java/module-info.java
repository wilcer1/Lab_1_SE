module com.example.lab1task1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab1task1 to javafx.fxml;
    exports com.example.lab1task1;
}