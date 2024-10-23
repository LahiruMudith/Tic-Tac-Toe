package com.assignment.tictactoe.service;

public class HumanPlayer extends Player {
    BoardImpl board;
    public HumanPlayer(BoardImpl board) {
        super(board);
        this.board = board;
    }

    public void move(int row, int col) {
        if (board.isLegalMove(row, col)){
            board.updateMove(row, col, Piece.X);
        }else {
            System.out.println("Error to move Human Player Row: " + row + ", col: " + col);
        }
    }
}
