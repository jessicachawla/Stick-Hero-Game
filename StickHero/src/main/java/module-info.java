module application.stickhero {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires org.testng;


    opens application.stickhero to javafx.fxml;
    exports application.stickhero;
}