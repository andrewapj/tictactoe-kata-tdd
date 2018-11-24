package com.github.andrewapj;

import com.github.andrewapj.field.FieldState;
import com.github.andrewapj.strategy.DiagonalWinStrategy;
import com.github.andrewapj.strategy.HorizontalWinStrategy;
import com.github.andrewapj.strategy.VerticalWinStrategy;
import com.github.andrewapj.strategy.WinStrategy;
import java.util.List;

class GameEngine {

    private final Console console;
    private Grid grid;
    private final List<WinStrategy> winStrategies = List.of(
        new HorizontalWinStrategy(),
        new VerticalWinStrategy(),
        new DiagonalWinStrategy());

    private final Player player1 = new Player(FieldState.NOUGHT, "Player O");
    private final Player player2 = new Player(FieldState.CROSS, "Player X");

    GameEngine(Console console) {
        this.console = console;
    }

    void playGame() {

        grid = new Grid(winStrategies);
        Player currentPlayer = player1;
        int fieldChoice;

        while (true) {
            console.print(grid, "Welcome to Tic-Tac-Toe");
            fieldChoice = console.getInput(currentPlayer);

            if (grid.isFieldAvailable(fieldChoice)) {
                grid.setField(fieldChoice, currentPlayer.getState());

                if (checkPlayerWon(currentPlayer)) {
                    break;
                } else if (isStalemate()) {
                    break;
                }

                currentPlayer = nextTurn(currentPlayer);
            }
        }
        console.close();
    }

    private Player nextTurn(final Player currentPlayer) {
        if (currentPlayer.equals(player1)) {
            return player2;
        } else {
            return player1;
        }
    }

    private boolean checkPlayerWon(final Player player) {
        if (grid.hasPlayerWon(player.getState())) {
            console.printPlayerWon(player, grid);
            return true;
        }
        return false;
    }

    private boolean isStalemate() {
        if (grid.isStalemate()) {
            console.printStalemate(grid);
            return true;
        }
        return false;
    }
}
