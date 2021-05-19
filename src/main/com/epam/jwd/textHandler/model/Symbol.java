package com.epam.jwd.textHandler.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Symbol)) return false;
        Symbol symbol1 = (Symbol) o;
        return symbol == symbol1.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}
