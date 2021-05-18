package com.epam.jwd.textHandler;

import com.epam.jwd.textHandler.model.Symbol;
import com.epam.jwd.textHandler.model.Text;
import com.epam.jwd.textHandler.parsing.ParserProcessor;
import com.epam.jwd.textHandler.service.TextServiceImpl;
import com.epam.jwd.textHandler.util.TextReader;

public class Main {
    public static void main(String[] args) {
        TextReader textReader = TextReader.getInstance();
        String text  = textReader.read("java/resources/input/text.txt");

        Text textObj = ParserProcessor.getInstance().runParsing(text);
        System.out.println(textObj + "\n");

        System.out.println(TextServiceImpl.getInstance().sortLexemes(textObj, new Symbol('a')).readToString());
    }
}
