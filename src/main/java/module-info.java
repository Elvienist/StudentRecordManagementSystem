module org.example.studentrecordmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens org.example.studentrecordmanagementsystem to javafx.fxml;
    exports org.example.studentrecordmanagementsystem;
}