package com.epam.jwd.textHandler.model;

import java.util.ArrayList;

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
}
