module org.example.masodfoku {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.masodfoku to javafx.fxml;
    exports org.example.masodfoku;
}