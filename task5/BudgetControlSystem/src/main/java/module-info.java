module com.yaggod.budgetcontrolsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.yaggod.budgetcontrolsystem to javafx.fxml;
    opens com.yaggod.budgetcontrolsystem.model to javafx.base;
    exports com.yaggod.budgetcontrolsystem;
}