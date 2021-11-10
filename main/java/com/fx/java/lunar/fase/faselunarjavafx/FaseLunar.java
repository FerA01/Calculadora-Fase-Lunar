package com.fx.java.lunar.fase.faselunarjavafx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
public class FaseLunar extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FaseLunar.class.getResource("FaseLunar.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 550, 550);
        stage.setTitle("Fases lunares");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(0,new Image(new FileInputStream("src/main/resources/images/icono-luna.png")));
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}