package com.assignment.tictactoe.service;

public interface BoardUI {
    public void update(int col, int row, boolean isHumen);
    public void notifyWinner();
}
