package pl.nogacz.sudoku.board;

/**
 * @author Dawid Nogacz on 23.06.2019
 */
public class Board {
    private int[][] cell = new int[9][9];

    public Board() {
        for(int x = 0; x < 9; x++) {
            for(int y = 0; y < 9; y++) {
                cell[x][y] = 0;
            }
        }
    }

    public boolean solveSudoku() {
        for(int x = 0; x < 9; x++) {
            for(int y = 0; y < 9; y++) {
                if(cell[x][y] == 0) {
                    return searchPossibleNumbers(x, y);
                }
            }
        }

        return true;
    }

    private boolean searchPossibleNumbers(int x, int y) {
        for(int number = 1; number < 10; number++) {
            if(isAllowedNumber(x, y, number)) {
                cell[x][y] = number;

                if(solveSudoku()) {
                    return true;
                } else {
                    cell[x][y] = 0;
                }
            }
        }

        return false;
    }

    public boolean isAllowedNumber(int x, int y, int number) {
        return !(containsInX(x, number) || containsInY(y, number) || containsInBox(x, y, number));
    }

    private boolean containsInX(int x, int number) {
        for(int i = 0; i < 9; i++) {
            if(cell[x][i] == number) {
                return true;
            }
        }

        return false;
    }

    private boolean containsInY(int y, int number) {
        for(int i = 0; i < 9; i++) {
            if(cell[i][y] == number) {
                return true;
            }
        }

        return false;
    }

    private boolean containsInBox(int x, int y, int number) {
        int newX = x - x % 3;
        int newY = y - y % 3;

        for(x = newX; x < newX + 3; x++) {
            for(y = newY; y < newY + 3; y++) {
                if(cell[x][y] == number) {
                    return true;
                }
            }
        }

        return false;
    }

    public void setNumberInCell(int x, int y, int number) {
        if(isAllowedNumber(x, y, number)) {
            cell[x][y] = number;
        }
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

                System.out.print(" " + cell[x][y] + " ");
            }

            System.out.println("\n");
        }

        System.out.println("----------------------------------\n");
    }
}
