package com.assignment.tictactoe.service.Controller;

import com.assignment.tictactoe.service.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

public class BoardController implements BoardUI, Initializable {
    BoardImpl board =  new BoardImpl();
    HumanPlayer humanPlayer = new HumanPlayer(board);
    AIPlayer aiPlayer = new AIPlayer(board);
    Piece pieceX = Piece.X;
    Piece pieceO = Piece.O;

    @FXML
    private GridPane gridPane;

    @FXML
    private Label txtName;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button button6;

    @FXML
    private Label lblText;

    @FXML
    private Button button7;

    @FXML
    private Button button1;

    ArrayList<Button> buttons;
    public Button clickBtn;

    public void setName(String name){
        txtName.setText(name);
    }


    public void buttonClick(ActionEvent actionEvent) {
        clickBtn = (Button) actionEvent.getSource();
        Node source = (Node) actionEvent.getSource();
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        if (colIndex == null) {colIndex = 0;}
        if (rowIndex == null) {rowIndex = 0;}

        humanPlayer.move(rowIndex, colIndex);
        update(colIndex, rowIndex, true);
        notifyWinner();
    }

    @FXML
    void btnRest(ActionEvent event) {
        board.initializeBoard();
        notifyWinner();
        for(Button button : buttons){
            button.setText(null);
            button.setDisable(false);
        }
    }

    @Override
    public void update(int col, int row, boolean isHumen) {
        if (clickBtn != null){
            clickBtn.setText(isHumen ? pieceX.toString() : pieceO.toString());
            clickBtn.setDisable(true);
            clickBtn.setFocusTraversable(false);
        }
    }

    @Override
    public void notifyWinner() {
        Piece winner = board.checkWinner();
        if (winner == pieceX){
            lblText.setText("X is win");
            clickBtn.setDisable(true);
        }else if (winner == pieceO){
            lblText.setText("O is win");
            clickBtn.setDisable(true);
        }else{
            lblText.setText("Tic-Tac-Toe");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));
        for(Button button : buttons){
            button.setFocusTraversable(false);
        }
        board.initializeBoard();
        board.printBoard();
    }
}