module com.example.teste_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.teste_javafx to javafx.fxml;
    exports com.example.teste_javafx;
    exports com.example.teste_javafx.controller to  javafx.fxml;
}