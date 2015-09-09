package com.gollahalli.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/gollahalli/gui/JMark_gui.fxml"));
        Scene scene = new Scene(root, 800, 600);

        primaryStage.getIcons().add(new Image("com/gollahalli/gui/resource/jm-32.png"));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JMark");
        primaryStage.show();


    }
}
