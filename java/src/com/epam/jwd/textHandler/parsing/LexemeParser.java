package com.epam.jwd.textHandler.parsing;

import com.epam.jwd.textHandler.model.*;
import com.epam.jwd.textHandler.bitCalculating.BitCalc;

import java.util.ArrayList;

public class LexemeParser extends Parser<Lexeme> {
    private static LexemeParser instance = null;

    private LexemeParser() {
    }

    public static LexemeParser getInstance() {
        if (instance == null) {
            synchronized (LexemeParser.class) {
                if (instance == null) {
                    instance = new LexemeParser();
                }
            }
        }
        return instance;
    }

    @Override
    public Lexeme parse(String text) {
        ArrayList<TextComponent> lexemeComponents = new ArrayList<>();

        if (BitCalc.getInstance().isBitExpression(text)){
            ArrayList<Symbol> expression = new ArrayList<>();
            int i = 0;
            while (i < text.length()) {
                expression.add(new Symbol(text.charAt(i)));
                i++;
            }
            lexemeComponents.add(new BitExpression(expression));
        }
        else {
            ArrayList<Symbol> word = new ArrayList<>();
            int i = 0;
            while (i < text.length()) {
                if (text.charAt(i) == ',' || text.charAt(i) == ':' || text.charAt(i) == '(' || text.charAt(i) == ')' || text.charAt(i) == '-') {
                    lexemeComponents.add(new Word(word));
                    word = new ArrayList<>();
                    lexemeComponents.add(new Symbol(text.charAt(i)));
                } else {
                    word.add(new Symbol(text.charAt(i)));
                }
                i++;
            }
            if (!word.isEmpty()) {
                lexemeComponents.add(new Word(word));
            }
        }
        return new Lexeme(lexemeComponents);
    }
}
