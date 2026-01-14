module org.example.switchbuttonlib {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.switchbuttonlib to javafx.fxml, javafx.graphics, org.testfx.junit5;

    exports org.example.switchbuttonlib;
}