package com.epam.jwd.textHandler.bitCalculating;

import org.junit.Test;

import static org.junit.Assert.*;

public class BitCalcTest {

    @Test
    public void getInstance() {
    }

    @Test
    public void isBitExpression_returnFalse() {
        String lexemeString = "onlyLexeme,";

        boolean actual = BitCalc.getInstance().isBitExpression(lexemeString);
        assertFalse(actual);
    }

    @Test
    public void isBitExpression_returnTrue() {
        String lexemeString = "~3&(7|8|(89^1))";

        boolean actual = BitCalc.getInstance().isBitExpression(lexemeString);
        assertTrue(actual);
    }

    @Test
    public void calc_returnResultOfExpression() {
        String lexemeString = "~3&(7|8|(89^1))";

        long actual = BitCalc.getInstance().calc(lexemeString);
        long expected = ~3&(7|8|(89^1));
        assertEquals(expected,actual);
    }
}