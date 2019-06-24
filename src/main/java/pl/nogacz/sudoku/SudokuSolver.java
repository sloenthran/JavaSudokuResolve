package pl.nogacz.sudoku;

import pl.nogacz.sudoku.board.Board;
import pl.nogacz.sudoku.util.Console;

/**
 * @author Dawid Nogacz on 23.06.2019
 */
public class SudokuSolver {
    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        Console console = new Console();
        Board board = new Board();

        boolean startSolve = false;

        do {
            System.out.println("Welcome in Sudoku Solver\n" +
                    "Choose action:\n\n" +
                    "1. Set number in cell\n" +
                    "2. Solve!\n" +
                    "3. Show board\n" +
                    "4. Exit");

            int menuNumber = console.getInt(4);

            switch (menuNumber) {
                case 1: {
                    console.clearConsole();

                    System.out.println("Give X coordinates");

                    int x = console.getInt(9);

                    System.out.println("Give Y coordinates");

                    int y = console.getInt(9);

                    System.out.println("Give number");

                    int number = console.getInt(9);

                    board.setNumberInCell(x, y, number);

                    break;
                }

                case 2: {
                    startSolve = true;
                    break;
                }

                case 3: {
                    console.clearConsole();
                    board.displayBoard();
                    break;
                }

                case 4: {
                    System.exit(0);
                    break;
                }
            }
        } while(!startSolve);

        console.clearConsole();

        System.out.println("Solve started... Please waiting...");

        if(board.solveSudoku()) {
            System.out.println("Solved");
        } else {
            System.out.println("Unsolvable");
        }

        board.displayBoard();

        mainMenu();
    }
}
