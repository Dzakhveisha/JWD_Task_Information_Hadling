package com.epam.jwd.textHandler.parsing;

import com.epam.jwd.textHandler.model.Lexeme;
import com.epam.jwd.textHandler.model.Sentence;

import java.util.ArrayList;

public class SentenceParser extends Parser<Sentence> {
    private static SentenceParser instance = null;
    private final Parser nextParser;
    private static final String SEPARATOR_REGEX = "\\s+";

    private SentenceParser(Parser nextParser) {
        this.nextParser = nextParser;
    }

    public static SentenceParser getInstance(Parser nextParser) {
        if (instance == null) {
            synchronized (SentenceParser.class) {
                if (instance == null) {
                    instance = new SentenceParser(nextParser);
                }
            }
        }
        return instance;
    }

    @Override
    public Sentence parse(String text) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        String punctuation = String.valueOf(text.charAt(text.length() - 1));
        if (text.length() > 3) {
            if (text.charAt(text.length() - 2) == '.' & text.charAt(text.length() - 3) == '.') {
                punctuation = "...";
                text = text.substring(0, text.length() - 3);

            } else {
                text = text.substring(0, text.length() - 1);
            }
        }

        String[] lexemesString = text.trim().split(SEPARATOR_REGEX);
        for (String lexeme : lexemesString) {
            lexemes.add((Lexeme) nextParser.parse(lexeme));
        }
        return new Sentence(lexemes, punctuation);
    }
}
