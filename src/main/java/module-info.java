module com.hospitalcrm.mainapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.hospitalcrm.mainapp to javafx.fxml;
    exports com.hospitalcrm.mainapp;
}