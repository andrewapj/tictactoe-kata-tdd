package com.github.andrewapj.strategy;

import com.github.andrewapj.TestGridFactory;
import com.github.andrewapj.field.FieldState;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HorizontalWinStrategyTest {

    @Test
    void should_DetectWin() {
        HorizontalWinStrategy strategy = new HorizontalWinStrategy();

        Assertions.assertTrue(
            strategy.checkForWin(
                FieldState.NOUGHT, TestGridFactory.getHorizontalWin(List.of(strategy))));
    }
}