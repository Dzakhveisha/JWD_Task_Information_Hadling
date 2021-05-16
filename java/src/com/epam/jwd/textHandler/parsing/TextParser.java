package com.epam.jwd.textHandler.parsing;

import com.epam.jwd.textHandler.model.Paragraph;
import com.epam.jwd.textHandler.model.Text;

import java.util.ArrayList;

public class TextParser extends Parser<Text>{

    private static TextParser instance = null;
    private Parser nextParser;
    private static final String SEPARATOR_REGEX = "^| {4}";

    private TextParser(Parser nextParser) {
        this.nextParser = nextParser;
    }

    public static TextParser getInstance(Parser nextParser) {
        if (instance == null) {
            synchronized (TextParser.class) {
                if (instance == null) {
                    instance = new TextParser(nextParser);
                }
            }
        }
        return instance;
    }

    @Override
    public Text parse(String text) {
        ArrayList<Paragraph> paragraphs = new ArrayList<>();
        String[] paragraphsString = text.trim().split(SEPARATOR_REGEX);
        for (String paragraph : paragraphsString) {
            paragraphs.add((Paragraph) nextParser.parse(paragraph));
        }
        return new Text(paragraphs);
    }
}
