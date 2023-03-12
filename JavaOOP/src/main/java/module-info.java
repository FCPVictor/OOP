module com.example.javaoop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javaoop to javafx.fxml;
    exports com.example.javaoop;
}