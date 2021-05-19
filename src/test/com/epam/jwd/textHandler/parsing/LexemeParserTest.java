package com.epam.jwd.textHandler.parsing;

import com.epam.jwd.textHandler.model.Lexeme;
import com.epam.jwd.textHandler.model.Symbol;
import com.epam.jwd.textHandler.model.TextComponent;
import com.epam.jwd.textHandler.model.Word;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LexemeParserTest {

    @Test
    public void parse_returnLexeme() {
        String lexeme = "hello";

        Lexeme actual = LexemeParser.getInstance().parse(lexeme);

        ArrayList<Symbol> expectedSymbols = new ArrayList<>();
        expectedSymbols.add(new Symbol('h'));
        expectedSymbols.add(new Symbol('e'));
        expectedSymbols.add(new Symbol('l'));
        expectedSymbols.add(new Symbol('l'));
        expectedSymbols.add(new Symbol('o'));

        ArrayList<TextComponent> expectedComponents = new ArrayList<>();
        expectedComponents.add(new Word(expectedSymbols));

        Lexeme expected = new Lexeme(expectedComponents);

        assertEquals(expected, actual);
    }
}