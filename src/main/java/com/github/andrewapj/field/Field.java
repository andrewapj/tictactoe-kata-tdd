package com.github.andrewapj.field;

public class Field {

    private FieldState state;

    public Field() {
        this.state = FieldState.EMPTY;
    }

    public FieldState getState() {
        return state;
    }

    public void setState(FieldState newState) {
        if (isInvalidState(newState) || isStateChangeExcludingEmpty(state, newState)) {
            throw new IllegalArgumentException();
        }
        this.state = newState;
    }

    private boolean isStateChangeExcludingEmpty(
        final FieldState oldState, final FieldState newState) {

        boolean response = false;
        if (oldState.equals(FieldState.NOUGHT) && newState == FieldState.CROSS) {
            response = true;
        } else if (oldState.equals(FieldState.CROSS) && newState == FieldState.NOUGHT) {
            response = true;
        }
        return response;
    }

    private boolean isInvalidState(final FieldState state) {
        return (state == null) || (FieldState.EMPTY.equals(state));
    }
}
