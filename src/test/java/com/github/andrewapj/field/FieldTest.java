package com.github.andrewapj.field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class FieldTest {

    private Field field;

    @BeforeEach
    void setup() {
        field = new Field();
    }

    @Test
    void should_SetStateAsEmpty_When_Created() {
        assertEquals(FieldState.EMPTY, field.getState());
    }

    @ParameterizedTest
    @EnumSource(value = FieldState.class, names = {"NOUGHT", "CROSS"})
    void should_SetNewState(FieldState state) {
        field.setState(state);
        assertEquals(state, field.getState());
    }

    @Test
    void shouldNot_SetStateToEmpty() {
        assertThrows(IllegalArgumentException.class, () -> field.setState(FieldState.EMPTY));
    }

    @Test
    void shouldNot_AllowNullState() {
        assertThrows(IllegalArgumentException.class, () -> field.setState(null));
    }

    @Test
    void shouldNot_AllowStateChange_WhenNotEmpty() {

        assertThrows(IllegalArgumentException.class, () -> {
            field.setState(FieldState.NOUGHT);
            field.setState(FieldState.CROSS);
        });

    }
}

