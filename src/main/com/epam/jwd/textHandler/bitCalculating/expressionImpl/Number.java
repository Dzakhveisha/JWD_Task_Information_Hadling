package com.epam.jwd.textHandler.bitCalculating.expressionImpl;

import com.epam.jwd.textHandler.bitCalculating.Expression;

public class Number implements Expression {
    private final long number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public long interpreter(Expression context) {
        return number;
    }
}
