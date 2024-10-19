package com.assignment.tictactoe.service;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {
    public void start(Stage stage) throws IOException {
//        BoardImpl board = new BoardImpl();
//        HumanPlayer humanPlayer = new HumanPlayer(board);
//        AIPlayer aiPlayer = new AIPlayer(board);

        // Game loop to alternate turns between human and AI
//        while (!board.isGameOver()) {
//            // Human player move
//            int[] humanMove = humanPlayer.getMove();
//            board.updateMove(humanMove[0], humanMove[1], Piece.X);
//
//            if (board.checkWinner() != Piece.EMPTY) break;
//
//            // AI move
//            int[] aiMove = aiPlayer.getMove();
//            board.updateMove(aiMove[0], aiMove[1], Piece.O);
//
//            board.printBoard();

            FXMLLoader fxmlLoader = new FXMLLoader(AppInitializer.class.getResource("/view/interface.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}