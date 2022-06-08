module project {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.media;
    requires com.google.gson;


    exports Program.Controller;
    opens Program.Controller to javafx.fxml;
    exports Program.View;
    exports Program;
    exports Program.Model.Models;
    exports Program.Model.Enums;
    opens Program to javafx.fxml;
    opens Program.View to com.google.gson, javafx.fxml;
    opens Program.Model.Enums to com.google.gson;
    opens Program.Model.Models to com.google.gson;
}