package com.github.andrewapj.strategy;

import com.github.andrewapj.TestGridFactory;
import com.github.andrewapj.field.FieldState;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiagonalWinStrategyTest {

    @Test
    void should_DetectWin() {
        DiagonalWinStrategy strategy = new DiagonalWinStrategy();

        Assertions.assertTrue(
            strategy.checkForWin(
                FieldState.NOUGHT, TestGridFactory.getDiagonalWin(List.of(strategy))));
    }
}
