module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens api to javafx.base;
    opens gui to javafx.fxml;
    exports gui;
}