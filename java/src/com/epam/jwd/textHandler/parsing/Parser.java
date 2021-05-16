package com.epam.jwd.textHandler.parsing;

public abstract class Parser<E> {
    public abstract E parse(String text);
}
