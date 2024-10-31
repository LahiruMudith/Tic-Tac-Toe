package com.assignment.tictactoe.service.Controller;

import com.assignment.tictactoe.service.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements BoardUI, Initializable {
    BoardImpl board;
    HumanPlayer humanPlayer;
    AIPlayer aiPlayer;
    Piece pieceX = Piece.X;
    Piece pieceO = Piece.O;

    public BoardController(){
        board =  new BoardImpl();
        humanPlayer  = new HumanPlayer(board);
        aiPlayer  = new AIPlayer(board);
    }
    @FXML
    private GridPane gridPane;


    @FXML
    private Label lblText;

    @FXML
    private Label txtName;

    public void buttonClick(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        int row = Integer.parseInt(button.getId().split("")[2]);
        int col = Integer.parseInt(button.getId().split("")[3]);

        humanPlayer.move(row, col);
        if (!board.isFull()){
            aiPlayer.findBestMove();
            board.printBoard();
        }else {
            new Alert(Alert.AlertType.INFORMATION, "Tic").show();
            clearBoard();
        }
        updateUi();

        if (board.checkWinner() != null) {
            notifyWinner(board.checkWinner().getWinningPiece());
        }
    }

    private void updateUi() {
        for (int i=0; i<board.getPieces().length; i++){
            for (int j=0; j<board.getPieces()[i].length; j++){
                update(j, i, board.getPieces()[i][j]);
            }
        }
    }

    @FXML
    void btnRest(ActionEvent event) {
        clearBoard();
    }
    public void clearBoard(){
        board.initializeBoard();
        for(Node node : gridPane.getChildren()){
            Button button = (Button) node;
            button.setText(null);
            button.setDisable(false);
        }
    }

    @Override
    public void update(int col, int row, Piece piece) {
        String buttonId = "id" + row + col;
        for (Node node : gridPane.getChildren()) {
            if (node instanceof Button button && buttonId.equals(node.getId())) {
                if (piece == Piece.X) {
                    button.setText("X");
                    button.setDisable(true);
                } else if (piece == Piece.O) {
                    button.setText("O");
                    button.setDisable(true);
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    button.setText("");
                }
                break;
            }
        }
    }

    public void notifyWinner(Piece piece) {
        if (piece == pieceX){
            new Alert(Alert.AlertType.INFORMATION, "X Win").show();
            clearBoard();
        }else if (piece == pieceO){
            new Alert(Alert.AlertType.INFORMATION, "O Win").show();
            clearBoard();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        board.initializeBoard();
    }
}