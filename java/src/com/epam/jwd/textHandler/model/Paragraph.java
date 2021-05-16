package com.epam.jwd.textHandler.model;

import java.util.ArrayList;

public class Paragraph implements TextComponent{

    private final ArrayList<Sentence> sentences;

    public Paragraph(ArrayList<Sentence> sentences) {
        this.sentences = sentences;
    }

    public ArrayList<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        return "\nParagraph{" +
                "sentences=" + sentences +
                "}";
    }

    @Override
    public String readToString() {
        String result = "    ";
        for (Sentence sent: sentences) {
            result += sent.readToString();
        }
        return result + "\n";
    }
}
