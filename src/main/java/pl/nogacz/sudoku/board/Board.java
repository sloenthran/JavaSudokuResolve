package pl.nogacz.sudoku.board;

import java.util.*;

/**
 * @author Dawid Nogacz on 23.06.2019
 */
public class Board {
    private Set<Cell> cells = new HashSet<>();
    private Random random = new Random();

    public Board() {
        for(int x = 0; x < 9; x++) {
            for(int y = 0; y < 9; y++) {
                cells.add(new Cell(x, y));
            }
        }
    }

    public boolean solveSudoku() {
        for(Cell cell : cells) {
            if(cell.getNumber() == 0) {
                return searchPossibleNumbers(cell);
            }
        }

        return true;
    }

    private boolean searchPossibleNumbers(Cell cell) {
        for(int number = 1; number < 10; number++) {
            if(isAllowedNumber(cell.getX(), cell.getY(), number)) {
                cell.setNumber(number);

                if(solveSudoku()) {
                    return true;
                } else {
                    cell.setNumber(0);
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
            Cell cell = getCell(x, i);

            if(cell != null && cell.getNumber() == number) {
                return true;
            }
        }

        return false;
    }

    private boolean containsInY(int y, int number) {
        for(int i = 0; i < 9; i++) {
            Cell cell = getCell(i, y);

            if(cell != null && cell.getNumber() == number) {
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
                Cell cell = getCell(x, y);

                if(cell != null && cell.getNumber() == number) {
                    return true;
                }
            }
        }

        return false;
    }

    private Cell getCell(int x, int y) {
        Cell searchCell = new Cell(x, y);

        for(Cell cell : cells) {
            if(cell.equals(searchCell)) {
                return cell;
            }
        }

        return null;
    }

    public void setNumberInCell(int x, int y, int number) {
        Cell cell = getCell(x, y);

        if(cell != null) {
            cell.setNumber(number);
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

                Cell cell = getCell(x, y);

                System.out.print(" " + cell.getNumber() + " ");
            }

            System.out.println("\n");
        }

        System.out.println("----------------------------------\n");
    }
}
