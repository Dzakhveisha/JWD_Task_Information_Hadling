package com.epam.jwd.textHandler.parsing;


import com.epam.jwd.textHandler.model.Text;

public class ParserProcessor {

    private static ParserProcessor instance = null;

    public static ParserProcessor getInstance() {
        if (instance == null) {
            synchronized (ParserProcessor.class) {
                if (instance == null) {
                    instance = new ParserProcessor();
                }
            }
        }
        return instance;
    }

    public Text runParsing(String text) {
        return TextParser.getInstance(
                ParagraphParser.getInstance(
                        SentenceParser.getInstance(
                                LexemeParser.getInstance()))).parse(text);
    }
}
