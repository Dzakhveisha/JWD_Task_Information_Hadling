package com.epam.jwd.textHandler.model;

import java.util.ArrayList;

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
}
