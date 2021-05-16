package com.epam.jwd.textHandler.parsing;

import com.epam.jwd.textHandler.model.Paragraph;
import com.epam.jwd.textHandler.model.Sentence;

import java.util.ArrayList;

public class ParagraphParser extends Parser<Paragraph> {
    private static ParagraphParser instance = null;
    private Parser nextParser;
    private static final String SEPARATOR_REGEX = "!|\\?|\\.{1,3}";

    private ParagraphParser(Parser nextParser) {
        this.nextParser = nextParser;
    }

    public static ParagraphParser getInstance(Parser nextParser) {
        if (instance == null) {
            synchronized (ParagraphParser.class) {
                if (instance == null) {
                    instance = new ParagraphParser(nextParser);
                }
            }
        }
        return instance;
    }

    @Override
    public Paragraph parse(String text) {
        ArrayList<Sentence> sentences = new ArrayList<>();
        String[] sentencesString = text.trim().split(SEPARATOR_REGEX);
        for (String sentence : sentencesString) {

            int separatorIndex = text.indexOf(sentence) + sentence.length();
            String separator = String.valueOf(text.charAt(separatorIndex));
            if (text.length() > (separatorIndex + 3)) {
                if (text.charAt(separatorIndex + 1) == '.' & text.charAt(separatorIndex + 2) == '.') {
                    separator = "...";
                }
            }
            sentence += separator;
            sentences.add((Sentence) nextParser.parse(sentence));
        }
        return new Paragraph(sentences);
    }
}
