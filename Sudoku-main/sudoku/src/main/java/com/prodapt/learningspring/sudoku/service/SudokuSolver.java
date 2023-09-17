package com.prodapt.learningspring.sudoku.service;

import org.springframework.stereotype.Service;

@Service
public class SudokuSolver {

    public boolean solveSudoku(int[][] board) {
        return solve(board);
    }

    private boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) {
                                return true;
                            }
                            board[row][col] = 0; // If placing the number didn't lead to a solution, backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true; // All cells are filled
    }

    private boolean isValid(int[][] board, int row, int col, int num) {
        // Check if 'num' is already present in the current row, column, or 3x3 grid
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num || board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
