package com.assignment.tictactoe.service.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class StartMenuController {
    @FXML
    private Pane pane;

    @FXML
    public TextField lblUserName;

    @FXML
    private Text lblLoginError;

    @FXML
    private AnchorPane ancorStartPage;

    @FXML
    void btnStartGame(ActionEvent event) {
        if (lblUserName.getText() != null){
            try {
                AnchorPane load= FXMLLoader.load(getClass().getResource("/view/interface.fxml"));
                ancorStartPage.getChildren().add(load);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            lblLoginError.setText("Please Fil Name");
        }
    }
}
