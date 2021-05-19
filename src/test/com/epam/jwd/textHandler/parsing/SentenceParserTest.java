package com.epam.jwd.textHandler.parsing;

import com.epam.jwd.textHandler.model.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SentenceParserTest {

    @Test
    public void parse_returnSentence() {
        String sentence = "hello, world!";
        Sentence actual = SentenceParser.getInstance(LexemeParser.getInstance()).parse(sentence);

        ArrayList<Symbol> expectedSymbols = new ArrayList<>();
        expectedSymbols.add(new Symbol('h'));
        expectedSymbols.add(new Symbol('e'));
        expectedSymbols.add(new Symbol('l'));
        expectedSymbols.add(new Symbol('l'));
        expectedSymbols.add(new Symbol('o'));
        ArrayList<TextComponent> expectedComponents = new ArrayList<>();
        expectedComponents.add(new Word(expectedSymbols));
        expectedComponents.add(new Symbol(','));

        ArrayList<Lexeme> expectedLexemes = new ArrayList<>();
        expectedLexemes.add(new Lexeme(expectedComponents));

        expectedSymbols = new ArrayList<>();
        expectedSymbols.add(new Symbol('w'));
        expectedSymbols.add(new Symbol('o'));
        expectedSymbols.add(new Symbol('r'));
        expectedSymbols.add(new Symbol('l'));
        expectedSymbols.add(new Symbol('d'));
        expectedComponents = new ArrayList<>();
        expectedComponents.add(new Word(expectedSymbols));

        expectedLexemes.add(new Lexeme(expectedComponents));

        assertEquals(expectedLexemes, actual.getLexemes());
        assertEquals("!", actual.getPunctuation());
    }
}