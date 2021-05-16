package com.epam.jwd.textHandler.bitCalculating.expressionImpl;

import com.epam.jwd.textHandler.bitCalculating.Expression;

public class ShiftLeft implements Expression{
    Expression expressionLeft;
    Expression expressionRight;

    public ShiftLeft(Expression expressionLeft, Expression expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public long interpreter(Expression context) {
        return expressionLeft.interpreter(context) << expressionRight.interpreter(context);
    }
}
