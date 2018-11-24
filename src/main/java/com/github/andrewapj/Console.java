package com.github.andrewapj;

import com.github.andrewapj.formatter.GridFormatter;
import java.util.Scanner;

class Console {

    private final Scanner scanner = new Scanner(System.in);
    private static final String WIN_MESSAGE = " Wins!";
    private static final String STALEMATE_MESSAGE = "No-one won";

    private final GridFormatter formatter = new GridFormatter();

    void print(final Grid grid, final String message) {
        System.out.println(message);
        System.out.println();
        System.out.print(formatter.format(grid));
    }

    void printPlayerWon(final Player player, final Grid grid) {
        print(grid, player.getName() + WIN_MESSAGE);
    }

    void printStalemate(final Grid grid) {
        print(grid, STALEMATE_MESSAGE);
    }

    int getInput(final Player player) {
        int choice;

        do {
            try {
                System.out.println(player.getName() + ": Please enter a number corresponding to a field: ");
                choice = Integer.parseInt(scanner.next());
            } catch (NumberFormatException x) {
                choice = 0;
            }
        } while (choice < 1 || choice > 9);
        return choice;
    }

    void close() {
        scanner.close();
    }
}
