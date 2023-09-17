package com.prodapt.learningspring.sudoku.logic;

import java.util.Random;

public class Sudoku {
    private static final int SIZE = 9;
    private int[][] grid;

    public Sudoku() {
        grid = new int[SIZE][SIZE];
    }

    public int[][] generateRandomPuzzle() {
        // Generate a simple Sudoku puzzle for demonstration
        int[][] puzzle = new int[SIZE][SIZE];
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                puzzle[i][j] = (i * 3 + i / 3 + j) % 9 + 1; // Fill numbers 1-9
            }
            // Shuffle the row
            for (int k = 0; k < SIZE; k++) {
                int temp = puzzle[i][k];
                int randIndex = random.nextInt(SIZE);
                puzzle[i][k] = puzzle[i][randIndex];
                puzzle[i][randIndex] = temp;
            }
        }

        return puzzle;
}
}
