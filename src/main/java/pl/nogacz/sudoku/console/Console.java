package pl.nogacz.sudoku.console;

import java.util.Scanner;

/**
 * @author Dawid Nogacz on 23.06.2019
 */
public class Console {
    private Scanner console = new Scanner(System.in);
    private boolean correctData = false;

    public int getInt(int max) {
        correctData = false;
        int data = 0;

        do {
            if (console.hasNextInt()) {
                data = console.nextInt();

                if(data == 9) {
                    correctData = true;
                } else {
                    if (data < 0 || data > max) {
                        System.out.println("You must write valid number!");
                        console.nextLine();
                    } else {
                        correctData = true;
                    }
                }
            } else {
                System.out.println("You must write number!");
                console.nextLine();
            }
        } while (!correctData);

        return data;
    }

    public String getString() {
        correctData = false;
        String data = null;

        do {
            data = console.nextLine();
            if(data.isEmpty()) {
                System.out.println("You must write text!");
                System.out.println();
            } else {
                correctData = true;
            }
        } while (!correctData);

        return data;
    }

    public void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
