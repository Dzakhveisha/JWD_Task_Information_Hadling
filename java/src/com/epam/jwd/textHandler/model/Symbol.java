package com.epam.jwd.textHandler.model;

public class Symbol implements TextComponent{
    private final char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "symbol=" + symbol +
                '}';
    }

    @Override
    public String readToString() {
        return String.valueOf(getSymbol());
    }
}
