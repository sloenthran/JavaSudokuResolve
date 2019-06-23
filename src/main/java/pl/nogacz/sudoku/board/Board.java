package pl.nogacz.sudoku.board;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dawid Nogacz on 23.06.2019
 */
public class Board {
    private Set<Cell> cells = new HashSet<>();

    public Board() {
        for(int x = 0; x < 9; x++) {
            for(int y = 0; y < 9; y++) {
                cells.add(new Cell(x, y));
            }
        }
    }

    public void solve() {
        for(Cell cell : cells) {
            if(cell.getNumber() == null) {
                searchValidNumber(cell);
            }
        }
    }

    private void searchValidNumber(Cell cell) {

    }

    public boolean containsInX(int x, int number) {
        for(int i = 0; i < 9; i++) {
            Cell cell = getCell(x, i);

            if(cell != null && cell.getNumber() == number) {
                return true;
            }
        }

        return false;
    }

    public boolean containsInY(int y, int number) {
        for(int i = 0; i < 9; i++) {
            Cell cell = getCell(i, y);

            if(cell != null && cell.getNumber() == number) {
                return true;
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
        cell.setNumber(number);
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
