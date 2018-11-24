package com.github.andrewapj.strategy;

import com.github.andrewapj.Grid;
import com.github.andrewapj.field.FieldState;

public class DiagonalWinStrategy implements WinStrategy {
    @Override
    public boolean checkForWin(final FieldState requiredState, final Grid grid) {
        if (hasValidInput(requiredState, grid)) {
            return (
                checkUpwardsHorizontalWin(grid, requiredState) || checkDownwardsHorizontalWin(grid, requiredState));
        } else {
            return false;
        }
    }

    private boolean checkUpwardsHorizontalWin(final Grid grid, final FieldState state) {
        FieldState state1 = grid.getFieldStateByIndex(7);
        FieldState state2 = grid.getFieldStateByIndex(5);
        FieldState state3 = grid.getFieldStateByIndex(3);

        return (state1.equals(state2) && state2.equals(state3) && state3.equals(state));
    }

    private boolean checkDownwardsHorizontalWin(final Grid grid, final FieldState state) {
        FieldState state1 = grid.getFieldStateByIndex(1);
        FieldState state2 = grid.getFieldStateByIndex(5);
        FieldState state3 = grid.getFieldStateByIndex(9);

        return (state1.equals(state2) && state2.equals(state3) && state3.equals(state));
    }
}
