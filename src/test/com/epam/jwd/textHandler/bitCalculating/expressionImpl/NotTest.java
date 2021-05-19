package com.epam.jwd.textHandler.bitCalculating.expressionImpl;

import com.epam.jwd.textHandler.bitCalculating.Expression;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotTest {

    @Test
    public void interpreter() {
        Expression context = new Not(new Number(5));

        long actual = context.interpreter(context);
        assertEquals( ~5, actual);
    }
}