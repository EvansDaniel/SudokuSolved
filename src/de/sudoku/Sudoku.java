package de.sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by daniel on 9/5/16.
 * @author Daniel Evans
 */
public class Sudoku {

    private static final String DATA_DIR = "/IdeaProjects/SudokuSolved/dataFiles/";


    public static boolean solvePuzzle(int[][] puzzle) {
        return solvePuzzle(0,0,puzzle);
    }

    private static boolean solvePuzzle(int i, int j, int[][] puzzle) {
        if (i == 9) { // have we reached the end of the row?
            i = 0;
            if (++j == 9) // have we reached the end of the puzzle?
                return true;
        }
        // skip this cell if it's already filled
        if (puzzle[i][j] != 0)
            return solvePuzzle(i+1,j,puzzle);

        for (int candidate = 1; candidate <= 9; ++candidate) {
            if (validMove(i, j, candidate, puzzle)) {
                puzzle[i][j] = candidate;
                if (solvePuzzle(i+1,j,puzzle)) // if false, will try next number from 1 to 9, if all false
                    return true;
            }
        }
        // reset this puzzle when puzzle[i-1][j] needs to be changed
        // i.e. reset on backtrack
        puzzle[i][j] = 0;
        // causes puzzle[i-1][j] to be recalculated potentially up to puzzle[0,0]
        // if puzzle[0,0] returns false after trying candidate =1 to candidate = 9
        // , solving this puzzle is impossible
        return false;
    }

    private static boolean validMove(int i, int j, int candidate, int[][] puzzle) {
        // not valid of val is already in this row
        for (int k = 0; k < 9; ++k)
            if (candidate == puzzle[k][j])
                return false;
        // not valid if val is already in this column
        for (int k = 0; k < 9; ++k)
            if (candidate == puzzle[i][k])
                return false;

        int boxRowOffset = getOffset(i); // map ith (row) index to the 0th, 3rd, or 6th spot
        int boxColOffset = getOffset(j); // map jth (col) index to the 0th, 3th, or 6th spot

        // not valid if val is already in this box
        for (int k = 0; k < 3; ++k)
            for (int m = 0; m < 3; ++m)
                if (candidate == puzzle[boxRowOffset+k][boxColOffset+m])
                    return false;

        return true;
    }
    // // map ith row or column index to the 0th, 3th, or 6th spot
    private static int getOffset(int i) {
        return (i/3)*3;
    }

    /*
    *  each token in the file is composed of three numbers
    *  1st: the ith index, indicating what row this number is on
    *  2nd: the jth index, indicating the column this number is on
    *  3rd: the number to insert at puzzle[i][j]
    */
    public static int[][] parseFile(String someFile) throws FileNotFoundException {
        Scanner s = new Scanner(new File(getDataDir() + someFile));
        int args = s.nextInt();
        int[][] puzzle = new int[9][9]; // default 0 vals
        for (int n = 0; n < args; ++n) {
            String s1 = s.next();
            int i = Integer.parseInt(s1.substring(0,1));
            int j = Integer.parseInt(s1.substring(1,2));
            int val = Integer.parseInt(s1.substring(2,3));
            puzzle[i][j] = val;
        }
        return puzzle;
    }

    public static int[][] parseFileAsMatrix(String someFile) throws FileNotFoundException {
        Scanner s = new Scanner(new File(getDataDir() + someFile));
        int[][] puzzle = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                puzzle[i][j] = s.nextInt();
            }
        }
        return puzzle;
    }

    private static String getDataDir() {
        return System.getProperty("user.home") + DATA_DIR;
    }

    public static void createMatrix(int[][] solution) {
        for (int i = 0; i < 9; ++i) {
            if (i % 3 == 0)
                System.out.println("-------------------------");
            for (int j = 0; j < 9; ++j) {
                if (j % 3 == 0) System.out.print("| ");
                if (solution[i][j] == 0) System.out.print(" ");
                else System.out.print(solution[i][j]);
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("-------------------------");
    }
}