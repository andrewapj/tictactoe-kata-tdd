package com.github.andrewapj.strategy;

import com.github.andrewapj.Grid;
import com.github.andrewapj.field.FieldState;
import java.util.stream.Stream;

public class VerticalWinStrategy implements WinStrategy {

    @Override
    public boolean checkForWin(final FieldState requiredState, final Grid grid) {

        if (hasValidInput(requiredState, grid)) {
            return Stream.of(1, 2, 3).anyMatch(fieldId -> checkVerticalWin(fieldId, grid, requiredState));
        }
        return false;
    }

    private boolean checkVerticalWin(final int startFieldId, final Grid grid,
                                     final FieldState state) {
        FieldState state1 = grid.getFieldStateByIndex(startFieldId);
        FieldState state2 = grid.getFieldStateByIndex(startFieldId + 3);
        FieldState state3 = grid.getFieldStateByIndex(startFieldId + 6);

        return (state1 == state2 && state2 == state3 && state3 == state);
    }
}
