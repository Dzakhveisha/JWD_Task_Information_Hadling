package com.epam.jwd.textHandler.model;

import java.util.ArrayList;

public class Lexeme implements TextComponent {

    private final ArrayList<TextComponent> lexemeComponents;

    public Lexeme(ArrayList<TextComponent> symbols) {
        this.lexemeComponents = symbols;
    }

    public ArrayList<TextComponent> getLexemeComponents() {
        return lexemeComponents;
    }

    @Override
    public String toString() {
        return "\n     Lexeme{" +
                "components=" + lexemeComponents +
                '}';
    }

    @Override
    public String readToString() {
        String result = "";
        for (TextComponent component: lexemeComponents) {
            result += component.readToString();
        }
        return result;
    }
}
