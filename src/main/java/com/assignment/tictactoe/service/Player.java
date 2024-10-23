package com.assignment.tictactoe.service;

public abstract class Player {
    BoardImpl board;
    Player(BoardImpl board){
        this.board = board;
    }
    public abstract void move(int row, int col);
}
