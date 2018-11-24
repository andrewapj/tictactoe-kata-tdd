package com.github.andrewapj.formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.andrewapj.TestGridFactory;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class GridFormatterTest {

    private final String lineSeparator = System.lineSeparator();

    private final String emptyGrid =
        "1 | 2 | 3" + lineSeparator +
            "4 | 5 | 6" + lineSeparator +
            "7 | 8 | 9" + lineSeparator;

    private final String stalemateGrid =
        "X | O | X" + lineSeparator +
            "O | O | X" + lineSeparator +
            "O | X | O" + lineSeparator;

    @Test
    void should_PrintStalemateGrid() {
        GridFormatter formatter = new GridFormatter();

        assertEquals(
            stalemateGrid,
            formatter.format(TestGridFactory.getStalemateGrid(Collections.emptyList())));
    }

    @Test
    void should_PrintEmptyGrid_WithNumbers() {
        GridFormatter formatter = new GridFormatter();

        assertEquals(
            emptyGrid, formatter.format(TestGridFactory.getEmptyGrid(Collections.emptyList())));
    }
}