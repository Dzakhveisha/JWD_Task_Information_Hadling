package com.epam.jwd.textHandler.bitCalculating.expressionImpl;

import com.epam.jwd.textHandler.bitCalculating.Expression;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrTest {

    @Test
    public void interpreter() {
        Expression context = new Or(new Number(3), new Number(5));

        long actual = context.interpreter(context);
        assertEquals(3 | 5, actual);
    }
}