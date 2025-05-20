module com.example.apfinalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires junit;
    requires org.junit.jupiter.api;


    opens com.example.apfinalproject to javafx.fxml;
    exports com.example.apfinalproject;
}