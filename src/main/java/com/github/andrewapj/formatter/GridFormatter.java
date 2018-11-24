package com.github.andrewapj.formatter;

import com.github.andrewapj.Grid;
import com.github.andrewapj.field.FieldState;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GridFormatter {

    private final String spacer = " | ";
    private final String lineSeparator = System.lineSeparator();
    private StringBuilder stringBuilder;

    public String format(final Grid grid) {
        stringBuilder = new StringBuilder();
        Stream.of(1, 4, 7).forEach(integer -> {
            stringBuilder.append(buildLine(grid, integer));
            stringBuilder.append(lineSeparator);
        });
        return stringBuilder.toString();
    }

    private String buildLine(final Grid grid, final int fieldNumber) {
        StringBuilder builder = new StringBuilder();

        IntStream.range(0, Grid.GRID_WIDTH).forEach(inc -> {
            builder.append(
                convertFieldStateToStringOrInt(
                    grid.getFieldStateByIndex(fieldNumber + inc), fieldNumber + inc));
            if (inc != Grid.GRID_WIDTH - 1) {
                builder.append(spacer);
            }
        });
        return builder.toString();
    }

    private String convertFieldStateToStringOrInt(final FieldState state, final int fieldNumber) {

        String response = String.valueOf(fieldNumber);

        switch (state) {
            case NOUGHT:
                response = "O";
                break;
            case CROSS:
                response = "X";
                break;
        }
        return response;
    }
}
