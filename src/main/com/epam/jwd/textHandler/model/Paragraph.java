package com.epam.jwd.textHandler.model;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paragraph)) return false;
        Paragraph paragraph = (Paragraph) o;
        return Objects.equals(sentences, paragraph.sentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentences);
    }
}
