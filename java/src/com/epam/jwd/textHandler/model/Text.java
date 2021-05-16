package com.epam.jwd.textHandler.model;

import java.util.ArrayList;

public class Text implements TextComponent{
    private final ArrayList<Paragraph> paragraphs;

    public Text(ArrayList<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public ArrayList<Paragraph> getParagraph() {
        return paragraphs;
    }

    @Override
    public String toString() {
        return "Text{" +
                "paragraphs=" + paragraphs +
                '}';
    }

    @Override
    public String readToString() {
        String result = "";
        for (Paragraph ph: paragraphs) {
            result += ph.readToString();
        }
        return result;
    }
}
