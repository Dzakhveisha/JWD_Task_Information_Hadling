package com.epam.jwd.textHandler.service;

import com.epam.jwd.textHandler.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TextServiceImpl implements TextService {

    private static TextServiceImpl instance;

    private TextServiceImpl() {
    }

    public static TextService getInstance() {
        if (instance == null) {
            synchronized (TextServiceImpl.class) {
                if (instance == null) {
                    instance = new TextServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public Text sortParByCountOfSent(Text text) {
        ArrayList<Paragraph> paragraphs = text.getParagraph();
        Collections.sort(paragraphs, new Comparator<Paragraph>() {
            @Override
            public int compare(Paragraph o1, Paragraph o2) {
                if (o1.getSentences().size() > o2.getSentences().size())
                    return 1;
                else if (o1.getSentences().size() < o2.getSentences().size())
                    return -1;
                else return 0;
            }
        });
        return new Text(paragraphs);
    }

    @Override
    public Text sortSentByWordLength(Text text) {
        text.getParagraph().forEach(paragraph -> {
            Collections.sort(paragraph.getSentences(), new Comparator<Sentence>() {
                @Override
                public int compare(Sentence o1, Sentence o2) {         // sort sentences by lexeme length = sort sentences by it's length??
                    int wordsLength1 = wordsLength(o1);
                    int wordsLength2 = wordsLength(o2);
                    return Integer.compare(wordsLength1, wordsLength2);
                }
            });
        });
        return text;
    }

    private int wordsLength(Sentence sentence) {
        int result = 0;
        ArrayList<Lexeme> lexemes = sentence.getLexemes();
        for (Lexeme lexeme : lexemes) {
            ArrayList<TextComponent> components = lexeme.getLexemeComponents();
            for (TextComponent component : components) {
                if (component.getClass() == Word.class) {
                    result += component.readToString().length();
                }
            }
        }
        return result;
    }

    @Override
    public Text sortSentByLexemeLength(Text text) {
        ArrayList<Paragraph> paragraphs = text.getParagraph();
        paragraphs.forEach(paragraph -> {
            Collections.sort(paragraph.getSentences(), new Comparator<Sentence>() {
                @Override
                public int compare(Sentence o1, Sentence o2) {         // sort sentences by lexeme length = sort sentences by it's length??
                    if (o1.readToString().length() > o2.readToString().length())
                        return 1;
                    else if (o1.readToString().length() < o2.readToString().length())
                        return -1;
                    else return 0;
                }
            });
        });
        return new Text(paragraphs);
    }

    @Override
    public Text sortLexemes(Text text, final Symbol symbol) {
        ArrayList<Paragraph> paragraphs = text.getParagraph();
        paragraphs.forEach(paragraph -> {
            paragraph.getSentences().forEach(sentence -> {
                Collections.sort(sentence.getLexemes(), new Comparator<Lexeme>() {
                    @Override
                    public int compare(Lexeme o1, Lexeme o2) {
                        int count1 = countOfSymbols(o1, symbol);
                        int count2 = countOfSymbols(o2, symbol);
                        if (count1 < count2)
                            return 1;
                        else if (count1 > count2)
                            return -1;
                        else if (count1 == 0)
                            return o1.readToString().compareTo(o2.readToString());
                        else return 0;
                    }
                });
            });
        });
        return new Text(paragraphs);
    }

    private int countOfSymbols(Lexeme lexeme, Symbol soughtSymbol) {
        int result = 0;
        String lexemeString = lexeme.readToString();
        for (char symbol : lexemeString.toCharArray()) {
            if (symbol == soughtSymbol.getSymbol()) {
                result++;
            }
        }
        return result;
    }
}
