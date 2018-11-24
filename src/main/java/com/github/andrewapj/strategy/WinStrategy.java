package com.github.andrewapj.strategy;

import com.github.andrewapj.Grid;
import com.github.andrewapj.field.FieldState;

public interface WinStrategy {

    boolean checkForWin(FieldState requiredState, Grid grid);

    default boolean hasValidInput(FieldState state, Grid grid) {
        return state != null && grid != null;
    }
}
