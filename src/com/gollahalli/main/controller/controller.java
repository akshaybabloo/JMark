package com.gollahalli.main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
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
    private TextArea jmark_textArea;
    @FXML
    private Button left_align_btn;
    @FXML
    private Button center_align_btn;
    @FXML
    private Button right_align_btn;
    @FXML
    private Button justify_btn;
    @FXML
    private Button bold_btn;
    @FXML
    private Button italic_btn;
    @FXML
    private Button underline_btn;
    @FXML
    private Button number_btn;
    @FXML
    private Button table_btn;
    @FXML
    private Button bullets_btn;
    @FXML
    private Button preview_btn;



    @FXML
    private void initialize(){
        String os = System.getProperty("os.name");
        if (os != null && os.startsWith("Mac")){
            jmark_menuBar.useSystemMenuBarProperty().set(true);
            jmark_borderPane.setPrefSize(800,600);
            jmark_borderPane.setLayoutY(0.0);
        }

        left_align_btn.setOnAction(event -> {
            System.out.println(jmark_textArea.getSelectedText());
        });
    }

}
