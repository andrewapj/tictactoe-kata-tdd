package com.github.andrewapj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.andrewapj.field.FieldState;
import com.github.andrewapj.strategy.DiagonalWinStrategy;
import com.github.andrewapj.strategy.HorizontalWinStrategy;
import com.github.andrewapj.strategy.VerticalWinStrategy;
import com.github.andrewapj.strategy.WinStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class GridTest {

    private Grid grid;

    private final List<WinStrategy> winStrategies = new ArrayList<>();

    @BeforeEach
    void setup() {
        winStrategies.addAll(List.of(
            mock(HorizontalWinStrategy.class),
            mock(VerticalWinStrategy.class),
            mock(DiagonalWinStrategy.class)));

        grid = new Grid(winStrategies);
    }

    @Test
    void should_CreateEmptyGrid() {

        IntStream.range(1, (Grid.GRID_WIDTH * Grid.GRID_HEIGHT + 1))
            .forEach(value -> assertEquals(FieldState.EMPTY, grid.getFieldStateByIndex(value)));
    }

    @Test
    void should_SetField() {
        grid.setField(1, FieldState.NOUGHT);

        assertEquals(FieldState.NOUGHT, grid.getFieldStateByIndex(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    void shouldNot_AllowOutOfBoundsFieldAccess(final int fieldNumber) {
        assertThrows(IllegalArgumentException.class, () -> grid.getFieldStateByIndex(fieldNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 6, 7, 8, 9})
    void should_ShowIfFieldIsAvailable(final int availableFields) {
        grid.setField(5, FieldState.CROSS);
        assertTrue(grid.isFieldAvailable(availableFields));
    }

    @Test
    void should_ShowIfFieldIsNotAvailable() {
        grid.setField(2, FieldState.CROSS);
        assertFalse(grid.isFieldAvailable(2));
    }

    @Test
    void should_DetectWin() {
        Grid grid = TestGridFactory.getHorizontalWin(winStrategies);

        when(winStrategies.get(0).checkForWin(eq(FieldState.CROSS), eq(grid)))
            .thenReturn(true);

        assertTrue(grid.hasPlayerWon(FieldState.CROSS));
    }

    @Test
    void should_DetectStateMate() {
        Grid grid = TestGridFactory.getStalemateGrid(Collections.emptyList());
        assertTrue(grid.isStalemate());
    }
}