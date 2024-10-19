package com.assignment.tictactoe.service.Controller;

import com.assignment.tictactoe.service.BoardImpl;
import com.assignment.tictactoe.service.HumanPlayer;
import com.assignment.tictactoe.service.Piece;
import com.assignment.tictactoe.service.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class BoardController extends BoardImpl implements Initializable{
    Random random = new Random();

    Player humanPlayer;
    Player AIPlayer;
    Piece pieceX = Piece.X;
    Piece pieceO = Piece.O;

    @FXML
    private GridPane gridPane;

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

    Integer rowIndex = 0;
    Integer colIndex = 0;

    private Node getNodeByRowColumnIndex(int row, int col, GridPane gridPane) {
        for (Node node : gridPane.getChildren()) {
            // Check if the node has valid row and column indices
            Integer nodeRowIndex = GridPane.getRowIndex(node);
            Integer nodeColIndex = GridPane.getColumnIndex(node);

            if (nodeColIndex == null) {
                nodeColIndex = 0;
            }
            if (nodeRowIndex == null) {
                nodeRowIndex = 0;
            }

            if (nodeRowIndex == row && nodeColIndex == col) {
                return node;
            }
        }
        return null;
    }

    public void buttonClick(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        colIndex = GridPane.getColumnIndex(source);
        rowIndex = GridPane.getRowIndex(source);

        if (colIndex == null) {
            colIndex = 0;
        }
        if (rowIndex == null) {
            rowIndex = 0;
        }
    }

    public void clickButton(Button button){
        button.setOnMouseClicked(mouseEvent -> {
            System.out.println("Row Index : " + rowIndex + " Col Index : " + colIndex);
            System.out.println("Is legal to move : " + isLegalMove(rowIndex, colIndex));
            if (isLegalMove(rowIndex, colIndex)){
                updateMove(rowIndex, colIndex, pieceX);
                printBoard();
                System.out.println();
                button.setText(pieceX.toString());
                button.setFocusTraversable(false);

                boolean randomGenarator = true;
                boolean goForward = false;
                while (randomGenarator){
                    rowIndex = random.nextInt(4);
                    colIndex = random.nextInt(4);
                    boolean x = isLegalMove(rowIndex, colIndex);
                    if (x){
                        randomGenarator = false;
                        goForward = true;
                    }
                }
                if (goForward){
                    System.out.println("Row Index : " + rowIndex + " Col Index : " + colIndex);
                    System.out.println("Is legal to move : " + isLegalMove(rowIndex, colIndex));
                    if (isLegalMove(rowIndex, colIndex)){
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        updateMove(rowIndex, colIndex, pieceO);
                        printBoard();
                        System.out.println();
                        Button newBtnId = (Button) getNodeByRowColumnIndex(rowIndex, colIndex, gridPane);
                        newBtnId.setText(pieceO.toString());
//                        newBtnId.setFocusTraversable(false);
                        printWinner();
                    }
                }
            }
        });
    }

    @FXML
    void btnRest(ActionEvent event) {
        initializeBoard();
        printWinner();
        for(Button button : buttons){
            button.setText(null);
            button.setDisable(false);
        }
    }

    public void printWinner(){
        printBoard();
        System.out.println();
        Piece piece = checkWinner();
        if (piece == pieceX){
            lblText.setText("X is win");
            for(Button button : buttons){
                button.setDisable(true);
            }
        }else if (piece == pieceO){
            lblText.setText("O is win");
            for(Button button : buttons){
                button.setDisable(true);
            }
        }else{
            lblText.setText("Tic-Tac-Toe");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));

        System.out.println(getNodeByRowColumnIndex(2, 2, gridPane));

        initializeBoard();
        for(Button button : buttons){
            clickButton(button);
        }
    }
}