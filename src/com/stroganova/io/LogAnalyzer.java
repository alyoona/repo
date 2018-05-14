package com.stroganova.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class LogAnalyzer {

    public List<LogToken> scanLog(String path, java.time.LocalDateTime timeFrom, LocalDateTime timeTo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
           String currentLine;
            while((currentLine = reader.readLine()) != null) {
                String partLine = currentLine.split("\\[", 1)[1];
                String[] temp = partLine.split(" ");
                LocalDateTime parse;

            }




        } catch (FileNotFoundException e) {
            throw new RuntimeException("err while finding file: ", e);
        } catch (IOException e) {
            throw new RuntimeException("something wrong, ", e);
        }
        return null;

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

        ;


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




