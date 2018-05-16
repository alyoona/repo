package com.stroganova;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.StringJoiner;


public class Test {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("test.log"))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] temp = currentLine.split(" ",7);
                for(String s : temp) {
                    System.out.println(s);
                }
                System.out.println(temp[5].substring(1));

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException("err while finding file: ", e);
        } catch (IOException e) {
            throw new RuntimeException("something wrong, ", e);
        }
    }


    static LocalDateTime getLocalDateTime(String dateTimeFromLog) {
        String[] dt = dateTimeFromLog.split("\\[|/|:",5);
        StringJoiner joiner = new StringJoiner("-");
        for (int i = dt.length - 2; i >= 1 ; i--) {
            joiner.add(dt[i]);
        }
        String date = joiner.toString();
        String time = dt[dt.length - 1];
        String dtForLocalDateTime =  date + "T" +time;
        return LocalDateTime.parse(dtForLocalDateTime);
    }


}

