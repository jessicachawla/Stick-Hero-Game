module application.stickhero {
    requires javafx.controls;
    requires javafx.fxml;


    opens application.stickhero to javafx.fxml;
    exports application.stickhero;
}