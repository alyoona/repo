package com.stroganova.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class LogAnalyzer {

    public List<LogToken> scanLog(String path, java.time.LocalDateTime timeFrom, LocalDateTime timeTo) {
        try (BufferedReader reader = new BufferedReader(new FileReader("test.log"))) {
            List<LogToken> list = new ArrayList<>();
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] temp = currentLine.split(" ", 7);
                LocalDateTime time = getLocalDateTime(temp[3]);
                if (time.isEqual(timeFrom) || time.isEqual(timeTo) || (time.isAfter(timeFrom) && time.isBefore(timeTo))) {
                    HttpMethod method = HttpMethod.getByName(temp[5].substring(1));
                    String message = temp[6];
                    LogToken logToken = new LogToken(time, method, message);
                    list.add(logToken);
                }
            }
            return list;
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

    private static class LogToken {
        LocalDateTime time;
        HttpMethod method;
        String message;

        LogToken(LocalDateTime time, HttpMethod method, String message) {
            this.time = time;
            this.method = method;
            this.message = message;
        }
    }

    private enum HttpMethod {
        GET, POST;

        private static HttpMethod getByName(String name) {
            HttpMethod httpMethod;
            if (name.equalsIgnoreCase("GET")) {
                httpMethod = HttpMethod.GET;
            } else if (name.equalsIgnoreCase("POST")) {
                httpMethod = HttpMethod.POST;
            } else {
                throw new IllegalArgumentException("No method for name: " + name);
            }
            return httpMethod;
        }
    }
}




