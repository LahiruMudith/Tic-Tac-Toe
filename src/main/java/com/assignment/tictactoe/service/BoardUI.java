package com.assignment.tictactoe.service;

public interface BoardUI {
    public void update(int col, int row, Piece piece);
    public void notifyWinner(Piece piece);
}
