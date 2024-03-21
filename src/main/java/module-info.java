module com.beginsecure.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.sql.rowset;

    opens com.beginsecure.demo to javafx.fxml;
    exports com.beginsecure.demo;
    exports packWork;
    opens packWork to javafx.fxml;
}