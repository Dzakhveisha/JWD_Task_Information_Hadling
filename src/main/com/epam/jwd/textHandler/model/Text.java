package com.epam.jwd.textHandler.model;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;
        Text text = (Text) o;
        return Objects.equals(paragraphs, text.paragraphs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paragraphs);
    }
}
