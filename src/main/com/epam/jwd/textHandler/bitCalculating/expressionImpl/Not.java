package com.epam.jwd.textHandler.bitCalculating.expressionImpl;

import com.epam.jwd.textHandler.bitCalculating.Expression;

public class Not implements Expression {
    Expression expressionRight;

    public Not(Expression expressionRight) {
        this.expressionRight = expressionRight;
    }

    @Override
    public long interpreter(Expression context) {
        return ~ expressionRight.interpreter(context);
    }
}
