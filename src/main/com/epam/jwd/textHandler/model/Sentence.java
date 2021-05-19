package com.epam.jwd.textHandler.model;

import java.util.ArrayList;
import java.util.Objects;

public class Sentence implements TextComponent {

    private final ArrayList<Lexeme> lexemes;
    private final String punctuation;

    public Sentence(ArrayList<Lexeme> lexemes, String punctuation) {
        this.lexemes = lexemes;
        this.punctuation = punctuation;
    }

    public ArrayList<Lexeme> getLexemes() {
        return lexemes;
    }

    public String getPunctuation() {
        return punctuation;
    }

    @Override
    public String toString() {
        return "\n  Sentence{" +
                "lexemes=" + lexemes +
                ", \n     punctuation='" + punctuation + '\'' +
                "}";
    }

    @Override
    public String readToString() {
        String result = "";
        for (Lexeme lexeme: lexemes) {
            result += " " + lexeme.readToString();
        }
        result.replaceFirst(" ", "");
        return result + punctuation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(lexemes, sentence.lexemes) && Objects.equals(punctuation, sentence.punctuation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lexemes, punctuation);
    }
}
