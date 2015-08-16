package com.gollahalli.main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;

/**
 * Created by akshayrajgollahalli on 16/08/15.
 */
public class controller {

    @FXML
    private MenuBar jmark_menuBar;
    @FXML
    private BorderPane jmark_borderPane;

    @FXML
    private void initialize(){
        String os = System.getProperty("os.name");
        if (os != null && os.startsWith("Mac")){
            jmark_menuBar.useSystemMenuBarProperty().set(true);
            jmark_borderPane.setPrefSize(800,600);
            jmark_borderPane.setLayoutY(0.0);
        }
    }
}
