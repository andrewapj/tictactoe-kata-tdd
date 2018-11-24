package com.github.andrewapj;

import com.github.andrewapj.field.Field;
import com.github.andrewapj.field.FieldState;
import com.github.andrewapj.strategy.WinStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Grid {

    public static final int GRID_WIDTH = 3;
    static final int GRID_HEIGHT = 3;

    private final List<WinStrategy> winStrategies;
    private List<Field> fields = new ArrayList<>();

    public Grid(List<WinStrategy> winStrategies) {
        IntStream.range(1, 10).forEach(i -> fields.add(new Field()));
        fields = Collections.unmodifiableList(fields);

        this.winStrategies = winStrategies;
    }

    // Getters / Setters

    public FieldState getFieldStateByIndex(final int fieldNumber) {

        if (isValidFieldNumber(fieldNumber)) {
            return fields.get(fieldNumber - 1).getState();
        } else {
            throw new IllegalArgumentException();
        }
    }

    void setField(final int fieldNumber, final FieldState state) {

        if (isValidFieldNumber(fieldNumber)) {
            fields.get(fieldNumber - 1).setState(state);
        } else {
            throw new IllegalArgumentException();
        }
    }

    // Grid inspections

    boolean isFieldAvailable(final int fieldNumber) {

        if (isValidFieldNumber(fieldNumber)) {
            return fields.get(fieldNumber - 1).getState() == FieldState.EMPTY;
        } else {
            return false;
        }
    }

    boolean hasPlayerWon(FieldState state) {

        return winStrategies.stream()
            .anyMatch(winStrategy -> winStrategy.checkForWin(state, this));
    }

    boolean isStalemate() {
        return fields.stream()
            .allMatch(field -> (field.getState().equals(FieldState.NOUGHT) ||
                field.getState().equals(FieldState.CROSS)));
    }

    private boolean isValidFieldNumber(final int fieldNumber) {
        return (fieldNumber >= 1 && fieldNumber <= 9);
    }
}
