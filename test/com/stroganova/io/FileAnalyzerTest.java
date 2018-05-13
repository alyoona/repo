package com.stroganova.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileAnalyzerTest {

    private File file;
    private OutputStream out;

    @Before
    public void before() {
        try {
            file = new File("story.txt");
            file.createNewFile();
            out = new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath()));
            out.write("sen1. sen2 str!sen3strstr? sen4".getBytes());
            out.write("\n".getBytes());
            out.write(",nhh".getBytes());
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @After
    public void after() {
        file.delete();
    }

    @Test
    public void testCountInCurrent() {
        int count = FileAnalyzer.countInCurrent("alfkjalfjstr skjhskd strsgdjhg.", "str");
        assertEquals(2, count);
        count = FileAnalyzer.countInCurrent("sdfsdgs", "str");
        assertEquals(0, count);
    }

    @Test
    public void testCountOfWords() {
        int count = FileAnalyzer.countOfWords("story.txt", "str");
        assertEquals(3, count);
    }

    @Test
    public void testSentences() {
        List<String> list = FileAnalyzer.sentences("story.txt");
        assertEquals("sen1.", list.get(0));
        assertEquals("sen2 str!", list.get(1));
        assertEquals("sen3strstr?", list.get(2));
        assertEquals("sen4 ,nhh", list.get(3));
    }

    @Test
    public void testSentencesWithWord() {
        List<String> list = FileAnalyzer.sentences("story.txt");
        List<String> sentences = FileAnalyzer.sentencesWithWord(list, "str");
        assertEquals("sen2 str!", sentences.get(0));
        assertEquals("sen3strstr?", sentences.get(1));
    }
}
