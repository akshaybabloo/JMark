package com.gollahalli.main.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;


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

        Platform.runLater(new Runnable() {
                              @Override
                              public void run() {
                                  jmark_textArea.requestFocus();
                              }
                          });

        // above code can be written as Platform.runLater(() -> jmark_textArea.requestFocus());

                Font f = Font.loadFont(getClass().getResourceAsStream("/com/gollahalli/gui/resource/FontAwesome.otf"), 20);

        left_align_btn.setFont(f);
        center_align_btn.setFont(f);
        right_align_btn.setFont(f);
        justify_btn.setFont(f);
        bold_btn.setFont(f);
        italic_btn.setFont(f);
        underline_btn.setFont(f);
        number_btn.setFont(f);
        table_btn.setFont(f);
        bullets_btn.setFont(f);
        preview_btn.setFont(f);

        left_align_btn.setText('\uf036' + "");
        center_align_btn.setText('\uf037' + "");
        right_align_btn.setText('\uf038' + "");
        justify_btn.setText('\uf039' + "");
        bold_btn.setText('\uf032' + "");
        italic_btn.setText('\uf033' + "");
        underline_btn.setText('\uf0cd' + "");
        number_btn.setText('\uf0cb' + "");
        table_btn.setText('\uf0ce' + "");
        bullets_btn.setText('\uf0ca' + "");
        preview_btn.setText('\uf06e' + "");

//        jmark_textArea.requestFocus();

        left_align_btn.setOnAction(event -> {
            System.out.println(jmark_textArea.getSelectedText());
        });
    }

}