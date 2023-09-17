package com.prodapt.learningspring.sudoku.repository;
import org.springframework.data.repository.CrudRepository;

import com.prodapt.learningspring.sudoku.entity.SudokuGrid;

public interface SudokuGridRepository extends CrudRepository<SudokuGrid,Integer>{
    
}