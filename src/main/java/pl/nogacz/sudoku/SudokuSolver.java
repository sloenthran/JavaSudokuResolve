package pl.nogacz.sudoku;

import pl.nogacz.sudoku.board.Board;

/**
 * @author Dawid Nogacz on 23.06.2019
 */
public class SudokuSolver {
    public static void main(String[] args) {
        Board board = new Board();
        board.setNumberInCell(0, 0, 1);
        board.setNumberInCell(0, 1, 2);
        board.displayBoard();
    }
}
