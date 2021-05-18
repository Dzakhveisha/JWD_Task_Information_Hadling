package com.epam.jwd.textHandler.service;

import com.epam.jwd.textHandler.model.Symbol;
import com.epam.jwd.textHandler.model.Text;

public interface TextService {
    Text sortParByCountOfSent(Text text);
    Text sortSentByWordLength(Text text);
    Text sortSentByLexemeLength(Text text);
    Text sortLexemes(Text text, Symbol symbol);
}
