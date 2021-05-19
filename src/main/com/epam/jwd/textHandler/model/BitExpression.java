package com.epam.jwd.textHandler.model;


import com.epam.jwd.textHandler.bitCalculating.BitCalc;

import java.util.ArrayList;

public class BitExpression implements TextComponent {
    private final ArrayList<Symbol> symbols;

    private final Long result;

    public BitExpression(ArrayList<Symbol> symbols) {
        this.symbols = symbols;
        String expressionString = "";
        for (Symbol symbol: symbols) {
            expressionString += symbol.readToString();
        }
        this.result = BitCalc.getInstance().calc(expressionString);
    }

    public ArrayList<Symbol> getSymbols() {
        return symbols;
    }

    public Long getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "BitExpression{" +
                "symbols=" + symbols +
                ", result=" + result +
                '}';
    }

    @Override
    public String readToString() {
        return String.valueOf(result);
    }
}
