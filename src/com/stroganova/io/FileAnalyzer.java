package com.stroganova.io;

import java.io.*;
import java.util.*;

public class FileAnalyzer {
    private static String path;
    private static String word;

    public static void main(String[] args) throws IOException {
        path = args[0];
        word = args[1];
        printCountOfWords();
        printSentencesWithWord();
    }

    private static void printCountOfWords() {
        int count = countOfWords(path, word);
        System.out.println("Count of words \"" + word + "\": " + count);
    }

    private static void printSentencesWithWord() {
        List<String> sentences = sentencesWithWord(sentences(path), word);
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }

    static int countInCurrent(String currentStr, String word) {
        String[] array = currentStr.split(word);
        int lengthWithoutWords = 0;
        for (String string : array) {
            lengthWithoutWords += string.length();
        }
        return (currentStr.length() - lengthWithoutWords) / word.length();
    }

    static int countOfWords(String path, String word) {
        List<String> sentences = sentencesWithWord(sentences(path), word);
        int counter = 0;
        for (String sentence : sentences) {
            counter += countInCurrent(sentence, word);
        }
        return counter;
    }

    static List<String> sentencesWithWord(List<String> list, String word) {
        List<String> newList = new ArrayList<>();
        for(String currentSentence : list) {
            if (currentSentence.contains(word)) {
                newList.add(currentSentence);
            }
        }
        return newList;
    }

    static List<String> sentences(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            List<String> lines = new ArrayList<>();
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                lines.add(currentLine);
            }
            String sentence = String.join(" ", lines);
            String[] array = sentence.split("(?<=\\.)|(?<=!)|(?<=\\?)");
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i].trim();
            }
            return Arrays.asList(array);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("error while finding file, ", e);
        } catch (IOException e) {
            throw new RuntimeException("something wrong, ", e);
        }
    }
}
