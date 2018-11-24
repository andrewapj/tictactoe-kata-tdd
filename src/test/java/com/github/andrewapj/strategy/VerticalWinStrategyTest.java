package com.github.andrewapj.strategy;

import com.github.andrewapj.TestGridFactory;
import com.github.andrewapj.field.FieldState;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VerticalWinStrategyTest {

    @Test
    void should_DetectWin() {
        VerticalWinStrategy strategy = new VerticalWinStrategy();

        Assertions.assertTrue(
            strategy.checkForWin(
                FieldState.NOUGHT, TestGridFactory.getVerticalWin(List.of(strategy))));
    }
}