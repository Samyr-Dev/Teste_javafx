package com.example.teste_javafx.utils;

import java.nio.file.Paths;

public class PathFXML {
    public static String pathFXML(){
        String path = "src/main/java/com/example/teste_javafx/view";
        return Paths.get(path).toAbsolutePath().toString();
    }
}
