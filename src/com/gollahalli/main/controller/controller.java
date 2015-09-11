package com.gollahalli.main.controller;

import com.github.rjeschke.txtmark.Processor;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;


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
    private Separator jmark_separator;

    @FXML
    private MenuItem jmark_about;

    @FXML
    private Window window;

    @FXML
    private AnchorPane jmark_anchor;


    @FXML
    private void initialize() {
        String os = System.getProperty("os.name");
        if (os != null && os.startsWith("Mac")) {
            jmark_menuBar.useSystemMenuBarProperty().set(true);
            jmark_borderPane.setPrefSize(800, 600);
            jmark_borderPane.setLayoutY(0.0);

            jmark_separator.setVisible(false);
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

//        preview_btn.setOnAction(event -> System.out.println(jmark_textArea.getSelectedText()));

        jmark_about.setOnAction(event -> {
            Stage stage = new Stage();
            Parent root = null;
            try {
                BoxBlur bb = new BoxBlur();
                GaussianBlur gb = new GaussianBlur();
                gb.setRadius(5.5);
                jmark_anchor.setEffect(gb);
                root = FXMLLoader.load(getClass().getResource("/com/gollahalli/gui/JMark_about.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(event1 -> jmark_anchor.setEffect(null));
        });

        preview_btn.setOnAction(event -> {
            String a = jmark_textArea.getText();
            String result = Processor.process(a);

            Stage stage = new Stage();
            Parent root = null;
            try {
                BoxBlur bb = new BoxBlur();
                GaussianBlur gb = new GaussianBlur();
                gb.setRadius(5.5);
                jmark_anchor.setEffect(gb);
                root = FXMLLoader.load(getClass().getResource("/com/gollahalli/gui/JMark_webview.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root, 1024, 768);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

            final WebView browser = new WebView();
            browser.setPrefSize(1024, 768);
            final WebEngine webEngine = browser.getEngine();

            ScrollPane scrollPane = (ScrollPane) scene.lookup("#scroll");
            scrollPane.setPannable(true);
            scrollPane.setContent(browser);

            webEngine.loadContent(result);
            stage.setOnCloseRequest(event1 -> jmark_anchor.setEffect(null));


        });

    }

}