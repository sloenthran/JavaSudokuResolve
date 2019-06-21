package pl.nogacz.sudoku;

/**
 * @author Dawid Nogacz on 21.06.2019
 */

public class Board {
    private Integer[][] sudokuBoard = new Integer[9][9];

    public void setValueInSudokuBoard(int x, int y, int number) {
        sudokuBoard[x][y] = number;
    }

    public boolean containsInX(int x, int number) {
        for(int i = 0; i < 9; i++) {
            if(sudokuBoard[x][i] == number) {
                return true;
            }
        }

        return false;
    }

    public boolean containsInY(int y, int number) {
        for(int i = 0; i < 9; i++) {
            if(sudokuBoard[i][y] == number) {
                return true;
            }
        }

        return false;
    }

    public boolean containsInBox(int x, int y, int number) {
        //TODO
        return false;
    }

    public void displayBoard() {
        System.out.println("----------------------------------\n");

        for(int x = 0; x < 9; x++) {
            if(x % 3 == 0 && x != 0) {
                System.out.println("----------------------------------\n");
            }

            for(int y = 0; y < 9; y++) {
                if(y % 3 == 0 && y != 0)
                {
                    System.out.print(" | ");
                }

                System.out.print(" " + sudokuBoard[x][y] + " ");
            }

            System.out.println("\n");
        }

        System.out.println("----------------------------------\n");
    }



}
