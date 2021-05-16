package com.epam.jwd.textHandler.bitCalculating.expressionImpl;

import com.epam.jwd.textHandler.bitCalculating.Expression;

import java.util.ArrayList;
import java.util.Stack;

public class Evaluate implements Expression {

    Expression evaluate;

    public Evaluate(ArrayList<String> reversePolishNotation) {

        Stack<Expression> expressions = new Stack<>();
        for (String s : reversePolishNotation) {
            switch (s) {
                case "~": {
                    expressions.push(new Not(expressions.pop()));
                }
                break;
                case "|":
                    expressions.push(new Or(expressions.pop(), expressions.pop()));
                    break;
                case "&":
                    expressions.push(new And(expressions.pop(), expressions.pop()));
                    break;
                case ">>": {
                    Expression first = expressions.pop();
                    expressions.push(new ShiftRight(expressions.pop(), first));
                }
                break;
                case "<<": {
                    Expression first = expressions.pop();
                    expressions.push(new ShiftLeft(expressions.pop(), first));
                }
                break;
                case "^":
                    expressions.push(new Xor(expressions.pop(), expressions.pop()));
                    break;

                default: { // number
                    expressions.push(new Number(Integer.parseInt(s)));
                }
                break;
            }
        }

        evaluate = expressions.pop();
    }

    @Override
    public long interpreter(Expression context) {
        return evaluate.interpreter(context);
    }
}
