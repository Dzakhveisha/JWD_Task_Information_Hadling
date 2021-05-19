package com.epam.jwd.textHandler.bitCalculating.expressionImpl;

import com.epam.jwd.textHandler.bitCalculating.Expression;
import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluateTest {

    @Test
    public void interpreter() {
        Expression context = new Xor(new Or(new Number(3), new Number(5)), new And(new Number(11), new Number(12)));

        long actual = context.interpreter(context);
        assertEquals(3|5^11&12, actual);
    }
}