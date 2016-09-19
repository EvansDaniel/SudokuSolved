package de.sudoku;

import java.io.FileNotFoundException;

/**
 * Created by daniel on 9/5/16.
 * @author Daniel Evans
 */
public class Main {

    /*
     * Print the specified Sudoku problem and its solution.  The
     * problem is encoded as specified in the class documentation
     * above. Compile with javac
     */
    public static void main(String[] args) throws FileNotFoundException {
        int[][] puzzle = Sudoku.parseFileAsMatrix("easySudoku_matrixForm");
        Sudoku.createMatrix(puzzle);
        // start at the matrix[0][0]
        if (Sudoku.solvePuzzle(puzzle))
            Sudoku.createMatrix(puzzle);
        else
            System.out.println("No way to solve this puzzle puzzle");
    }
}
