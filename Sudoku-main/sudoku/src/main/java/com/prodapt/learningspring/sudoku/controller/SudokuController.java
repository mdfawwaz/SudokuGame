package com.prodapt.learningspring.sudoku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//import com.prodapt.learningspring.sudoku.entity.SudokuGrid;
import com.prodapt.learningspring.sudoku.entity.SudokuGrid;
import com.prodapt.learningspring.sudoku.repository.SudokuGridRepository;
//import com.prodapt.learningspring.sudoku.repository.SudokuGridRepository;
import com.prodapt.learningspring.sudoku.service.SudokuSolver;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.prodapt.learningspring.sudoku.entity.SudokuGrid;
import com.prodapt.learningspring.sudoku.repository.SudokuGridRepository;




//@Controller
//public class SudokuController {
//    private final SudokuGridRepository gridRepository;
//    private final SudokuSolver sudokuSolver;
//
//    @Autowired
//    public SudokuController(SudokuGridRepository gridRepository, SudokuSolver sudokuSolver) {
//        this.gridRepository = gridRepository;
//        this.sudokuSolver = sudokuSolver;
//    }
//
//    @GetMapping("/")
//    public String showGrid(Model model) {
//        SudokuGrid sudokuGrid = generateNewGrid();
//        model.addAttribute("sudokuGrid", sudokuGrid);
//        return "sudoku-grid";
//    }
//
//    @PostMapping("/verify")
//    public String verifyGrid(SudokuGrid sudokuGrid) {
//        int[][] board = parseGridData(sudokuGrid.getGrid());
//        if (sudokuSolver.solveSudoku(board)) {
//            // Puzzle is solved
//            // You can implement additional logic here to check if the user's input matches the solution
//            return "redirect:/?message=Sudoku+solved+successfully!";
//        } else {
//            // Puzzle cannot be solved with the current input
//            return "redirect:/?message=Invalid+Sudoku+input!";
//        }
//    }
//
//    @PostMapping("/save")
//    public String saveGrid(SudokuGrid sudokuGrid) {
//        gridRepository.save(sudokuGrid);
//        return "redirect:/";
//    }
//
//    private SudokuGrid generateNewGrid() {
//        SudokuGrid newGrid = new SudokuGrid();
//        String initialGridData = "530070000600195000098000060800060003400803001700020006060000280000419005000080079";
//        newGrid.setGrid(initialGridData);
//        return newGrid;
//    }
//
//    private int[][] parseGridData(String gridData) {
//        int[][] board = new int[9][9];
//        int counter = 0;
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                board[i][j] = Character.getNumericValue(gridData.charAt(counter++));
//            }
//        }
//        return board;
//    }
//}

//
@Controller
public class SudokuController {
    private final SudokuGridRepository gridRepository;
    private final SudokuSolver sudokuSolver;

    @Autowired
    public SudokuController(SudokuGridRepository gridRepository, SudokuSolver sudokuSolver) {
        this.gridRepository = gridRepository;
        this.sudokuSolver = sudokuSolver;
    }

    @GetMapping("/sudoku-grid")
    public String showGrid(Model model) {
        SudokuGrid sudokuGrid = generateNewGrid();
        model.addAttribute("sudokuGrid", sudokuGrid);
        return "sudoku-grid";
    }

    @PostMapping("/verify")
    public String verifyGrid(SudokuGrid sudokuGrid) {
        int[][] board = parseGridData(sudokuGrid.getGrid());
        if (sudokuSolver.solveSudoku(board)) {
            // Puzzle is solved
            return "redirect:/?message=Sudoku+solved+successfully!";
        } else {
            // Puzzle cannot be solved with the current input
            return "redirect:/?message=Invalid+Sudoku+input!";
        }
    }

    @PostMapping("/save")
    public String saveGrid(SudokuGrid sudokuGrid) {
        gridRepository.save(sudokuGrid);
        return "redirect:/";
    }

    private SudokuGrid generateNewGrid() {
        SudokuGrid newGrid = new SudokuGrid();
        String initialGridData = "530070000600195000098000060800060003400803001700020006060000280000419005000080079";
        newGrid.setGrid(initialGridData);
        return newGrid;
    }

    private int[][] parseGridData(String gridData) {
        int[][] board = new int[9][9];
        int counter = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = Character.getNumericValue(gridData.charAt(counter++));
            }
        }
        return board;
    }
}
////package com.prodapt.learningspring.sudoku.controller;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.PostMapping;
////
////import com.prodapt.learningspring.sudoku.entity.SudokuGrid;
////import com.prodapt.learningspring.sudoku.repository.SudokuGridRepository;
////
////@Controller
////public class SudokuController {
////	 private final SudokuGridRepository gridRepository;
////
////	    @Autowired
////	    public SudokuController(SudokuGridRepository gridRepository) {
////	        this.gridRepository = gridRepository;
////	    }
////
////	    @GetMapping("/sudoku-grid")
////	    public String showGrid(Model model) {
////	        SudokuGrid sudokuGrid = new SudokuGrid();
////	        model.addAttribute("sudokuGrid", sudokuGrid);
////	        return "sudoku-grid"; // This should correspond to your Thymeleaf HTML template
////	    }
////
////    @GetMapping("/solve")
////    public String solveGrid(Model model) {
////        if (solveSudoku(grid, 0, 0)) {
////            model.addAttribute("sudokuGrid", grid);
////        } else {
////            // Handle the case when no solution exists
////            model.addAttribute("sudokuGrid", null);
////        }
////        return "sudoku-grid"; // This should correspond to your Thymeleaf HTML template
////    }
////
////   
////    @PostMapping("/verify")
////    public String verifyGrid(SudokuGrid sudokuGrid) {
////        // Implement verification logic here
////        return "redirect:/"; // Redirect back to the grid page
////    }
////
////    @PostMapping("/save")
////    public String saveGrid(SudokuGrid sudokuGrid) {
////        gridRepository.save(sudokuGrid);
////        return "redirect:/"; // Redirect back to the grid page
////    }
////
////
////
////    // Sudoku solving logic
////    private boolean solveSudoku(int[][] grid, int row, int col) {
////        if (row == N - 1 && col == N)
////            return true;
////    
////        if (col == N) {
////            row++;
////            col = 0;
////        }
////    
////        if (grid[row][col] != 0)
////            return solveSudoku(grid, row, col + 1);
////    
////        for (int num = 1; num <= 9; num++) {
////            if (isSafe(grid, row, col, num)) {
////                grid[row][col] = num;
////                if (solveSudoku(grid, row, col + 1))
////                    return true;
////                grid[row][col] = 0;
////            }
////        }
////        return false;
////    }
////    
////    private boolean isSafe(int[][] grid, int row, int col, int num) {
////        for (int x = 0; x < N; x++) {
////            if (grid[row][x] == num || grid[x][col] == num)
////                return false;
////        }
////    
////        int startRow = row - row % 3;
////        int startCol = col - col % 3;
////    
////        for (int i = 0; i < 3; i++) {
////            for (int j = 0; j < 3; j++) {
////                if (grid[i + startRow][j + startCol] == num)
////                    return false;
////            }
////        }
////    
////        return true;
////    }
////    
////    // Utility function to print the Sudoku grid
////    void printGrid(int grid[][]) {
////        // Implementation of printing the Sudoku grid
////        // (Use the code you provided earlier)
////    }
////}
