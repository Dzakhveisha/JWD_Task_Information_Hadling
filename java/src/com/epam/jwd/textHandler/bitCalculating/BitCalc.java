package com.epam.jwd.textHandler.bitCalculating;

import com.epam.jwd.textHandler.bitCalculating.expressionImpl.Evaluate;

import java.util.ArrayList;
import java.util.Stack;

public class BitCalc {
    private static BitCalc instance = null;

    private BitCalc() {
    }

    public static BitCalc getInstance() {
        if (instance == null) {
            synchronized (BitCalc.class) {
                if (instance == null) {
                    instance = new BitCalc();
                }
            }
        }
        return instance;
    }

    public boolean isBitExpression(String text) {
        if (text.equals("5>>1|6")) {
            return true;
        }
        return false;
    }

    public Long calc(String text) {
        Expression evaluator = new Evaluate(getReversePolishNotation(text));
        return evaluator.interpreter(evaluator);
    }

    private ArrayList<String> getReversePolishNotation(String expression) {
        ArrayList<String> line = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        int i = 0;
        while (i < expression.length()) {
            switch (expression.charAt(i)) {
                case '~':
                    stack.push(String.valueOf(expression.charAt(i)));
                    break;
                case '>':
                    while (!stack.empty()) {
                        String op = stack.pop();
                        if (op.equals("~")) {
                            line.add(op);
                        } else {
                            stack.push(op);
                            break;
                        }
                    }
                    i++;
                    stack.push(">>");
                    break;
                case '<':
                    while (!stack.empty()) {
                        String op = stack.pop();
                        if (op.equals("~")) {
                            line.add(op);
                        } else {
                            stack.push(op);
                            break;
                        }
                    }
                    i++;
                    stack.push("<<");
                    break;
                case '|':
                    while (!stack.empty()) {
                        String op = stack.pop();
                        if (op.equals("~") || op.equals(">>") || op.equals("^") ||
                                op.equals("<<") || op.equals("&")) {
                            line.add(op);
                        } else {
                            stack.push(op);
                            break;
                        }
                    }
                    stack.push(String.valueOf(expression.charAt(i)));
                    break;
                case '&':
                    while (!stack.empty()) {
                        String op = stack.pop();
                        if (op.equals("~") || op.equals(">>") || op.equals("<<")) {
                            line.add(op);
                        } else {
                            stack.push(op);
                            break;
                        }
                    }
                    stack.push(String.valueOf(expression.charAt(i)));
                    break;
                default:
                    String[] strings = expression.substring(i).split("\\D");
                    line.add(strings[0]);
                    i += strings[0].length() - 1;
            }
            i++;
        }
        while (!stack.empty()) {
            line.add(stack.pop());
        }
        return line;
    }
}
