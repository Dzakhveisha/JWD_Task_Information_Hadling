package com.epam.jwd.textHandler.model;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lexeme)) return false;
        Lexeme lexeme = (Lexeme) o;
        return Objects.equals(lexemeComponents, lexeme.lexemeComponents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lexemeComponents);
    }
}
