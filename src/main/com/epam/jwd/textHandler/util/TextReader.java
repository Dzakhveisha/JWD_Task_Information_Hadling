package com.epam.jwd.textHandler.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {
    private static TextReader instance = null;
    private static final Logger LOGGER = LogManager.getLogger(TextReader.class);

    private TextReader() {}

    public static TextReader getInstance() {
        if (instance == null) {
            synchronized (TextReader.class) {
                if (instance == null) {
                    instance = new TextReader();
                }
            }
        }
        return instance;
    }

    public String read(String fileName) {
        File resFile = new File(fileName);
        String stringBuffer = "";
        try (FileReader reader = new FileReader(resFile); BufferedReader br = new BufferedReader(reader)) {
            String line = br.readLine();
            while (line != null) {
                stringBuffer += line;
                line = br.readLine();
            }
        } catch (IOException e) {
            LOGGER.error("File is not read.");
        }
        return stringBuffer;
    }
}
