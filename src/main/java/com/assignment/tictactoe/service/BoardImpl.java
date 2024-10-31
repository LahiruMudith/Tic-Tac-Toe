package com.assignment.tictactoe.service;

public class BoardImpl implements Board {
    public Piece[][] pieces = new Piece[3][3];
    BoardUI boardUI;

    BoardImpl(BoardUI boardUI) {
        initializeBoard();
        Piece empty = Piece.EMPTY;
    }
    public BoardImpl(){

    }

    public Piece[][] getPieces() {
        return pieces;
    }

    @Override
    public BoardUI getBoardUi() {
        return boardUI;
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pieces[i][j] = Piece.EMPTY;
            }
        }
    }

    public boolean isLegalMove(int row, int col) {
        return pieces[row][col] == Piece.EMPTY;
    }

    public void updateMove(int row, int col, Piece piece) {
        pieces[row][col] = piece;
    }

    public Winner checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (pieces[i][0] == pieces[i][1] && pieces[i][1] == pieces[i][2] && pieces[i][0] != Piece.EMPTY) {
                return new Winner(0, i, 1, i, 2, i, pieces[i][0]);
            }
            if (pieces[0][i] == pieces[1][i] && pieces[1][i] == pieces[2][i] && pieces[0][i] != Piece.EMPTY) {
                return new Winner(i, 0, i, 1, i, 2, pieces[0][i]);
            }
        }

        if (pieces[0][0] == pieces[1][1] && pieces[1][1] == pieces[2][2] && pieces[0][0] != Piece.EMPTY) {
            return new Winner(0, 0, 1, 1, 2, 2, pieces[0][0]);
        }

        if (pieces[0][2] == pieces[1][1] && pieces[1][1] == pieces[2][0] && pieces[0][2] != Piece.EMPTY) {
            return new Winner(0, 2, 1, 1, 2, 0, pieces[0][2]);
        }
        return null;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(pieces[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (pieces[i][j] == Piece.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
