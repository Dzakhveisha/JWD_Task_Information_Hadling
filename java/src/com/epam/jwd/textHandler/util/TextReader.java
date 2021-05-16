package com.epam.jwd.textHandler.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {
    private static TextReader instance = null;

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
            e.printStackTrace();
        }
        return stringBuffer;
    }
}
