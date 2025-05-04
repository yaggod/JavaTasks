module com.yaggod.budgetcontrolsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.yaggod.budgetcontrolsystem to javafx.fxml;
    exports com.yaggod.budgetcontrolsystem;
}