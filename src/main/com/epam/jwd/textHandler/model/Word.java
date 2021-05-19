package com.epam.jwd.textHandler.model;

import java.util.ArrayList;
import java.util.Objects;

public class Word implements TextComponent{
    private final ArrayList<Symbol> symbols;

    public Word(ArrayList<Symbol> symbols) {
        this.symbols = symbols;
    }

    public ArrayList<Symbol> getSymbols() {
        return symbols;
    }

    @Override
    public String toString() {
        return "Word{" +
                "symbols=" + symbols +
                '}';
    }

    @Override
    public String readToString() {
        String result = "";
        for (Symbol symbol: symbols) {
            result += symbol.readToString();
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word = (Word) o;
        return Objects.equals(symbols, word.symbols);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbols);
    }
}
