package com.github.andrewapj;

import com.github.andrewapj.field.FieldState;
import com.github.andrewapj.strategy.WinStrategy;
import java.util.List;

public final class TestGridFactory {

    public static Grid getDiagonalWin(final List<WinStrategy> strategies) {
        Grid grid = getEmptyGrid(strategies);

        grid.setField(1, FieldState.NOUGHT);

        grid.setField(5, FieldState.NOUGHT);

        grid.setField(7, FieldState.CROSS);
        grid.setField(8, FieldState.CROSS);
        grid.setField(9, FieldState.NOUGHT);
        return grid;
    }

    public static Grid getHorizontalWin(final List<WinStrategy> strategies) {
        Grid grid = getEmptyGrid(strategies);

        grid.setField(1, FieldState.CROSS);

        grid.setField(4, FieldState.NOUGHT);
        grid.setField(5, FieldState.NOUGHT);
        grid.setField(6, FieldState.NOUGHT);

        grid.setField(7, FieldState.CROSS);
        return grid;
    }

    public static Grid getVerticalWin(final List<WinStrategy> strategies) {
        Grid grid = getEmptyGrid(strategies);

        grid.setField(2, FieldState.NOUGHT);

        grid.setField(4, FieldState.CROSS);
        grid.setField(5, FieldState.NOUGHT);

        grid.setField(7, FieldState.CROSS);
        grid.setField(8, FieldState.NOUGHT);
        return grid;
    }

    public static Grid getStalemateGrid(final List<WinStrategy> strategies) {
        Grid grid = getEmptyGrid(strategies);

        grid.setField(1, FieldState.CROSS);
        grid.setField(2, FieldState.NOUGHT);
        grid.setField(3, FieldState.CROSS);

        grid.setField(4, FieldState.NOUGHT);
        grid.setField(5, FieldState.NOUGHT);
        grid.setField(6, FieldState.CROSS);

        grid.setField(7, FieldState.NOUGHT);
        grid.setField(8, FieldState.CROSS);
        grid.setField(9, FieldState.NOUGHT);
        return grid;
    }

    public static Grid getEmptyGrid(final List<WinStrategy> strategies) {
        return new Grid(strategies);
    }
}
