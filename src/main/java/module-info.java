module gswa.gswa {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens gswa.gswa to javafx.fxml;
    exports gswa.gswa;
}