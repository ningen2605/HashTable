module com.example.hashtable {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires java.desktop;


    opens com.example.hashtable to javafx.fxml;
    exports com.example.hashtable;
}