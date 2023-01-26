module gswa.gswa {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens application to javafx.fxml;
    exports application;
    opens controllers to javafx.fxml;
    exports controllers;
    opens other to javafx.fxml;
    exports other;
    opens data to javafx.fxml;
    exports data;
    opens token to javafx.fxml;
    exports token;
    opens mainClasses to javafx.fxml;
    exports mainClasses;
}