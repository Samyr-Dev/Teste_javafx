module com.example.teste_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;


    opens com.example.teste_javafx to javafx.fxml;
    opens com.example.teste_javafx.controller to javafx.fxml;
    opens com.example.teste_javafx.model to javafx.base;

    exports com.example.teste_javafx;
    exports com.example.teste_javafx.controller to  javafx.fxml;
    exports com.example.teste_javafx.model to  javafx.fxml;
}