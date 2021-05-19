package com.epam.jwd.textHandler.bitCalculating.expressionImpl;

import com.epam.jwd.textHandler.bitCalculating.Expression;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberTest {

    @Test
    public void interpreter() {
        Expression context = new Number(3);

        long actual = context.interpreter(context);
        assertEquals(3, actual);
    }
}