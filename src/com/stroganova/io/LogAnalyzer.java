package com.stroganova.io;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LogAnalyzer {

    public static List<LogToken> scanLog(String path, java.time.LocalDateTime timeFrom, LocalDateTime timeTo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            List<LogToken> list = new ArrayList<>();
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] temp = currentLine.split("\\[|]");
                LocalDateTime time = getTime(temp[1]);
                if (isBetween(time, timeFrom, timeTo)) {
                    HttpMethod method = HttpMethod.getByName(temp[2].substring(2, 5));
                    String message = temp[2].substring(6);
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

    static LocalDateTime getTime(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/uuuu:HH:mm:ss Z").withLocale(Locale.US);
        return LocalDateTime.parse(str, formatter);
    }

    static boolean isBetween(LocalDateTime time, LocalDateTime timeFrom, LocalDateTime timeTo) {
        if (timeFrom.isAfter(timeTo)) {
            throw new IllegalArgumentException("dateTimeFrom(" + timeFrom + ") should be equals or to be before dateTimeTo(" + timeTo + ")");
        }
        return time.isEqual(timeFrom) || time.isEqual(timeTo) || (time.isAfter(timeFrom) && time.isBefore(timeTo));
    }

    public static class LogToken {
        private LocalDateTime time;
        private HttpMethod method;
        private String message;

        LogToken(LocalDateTime time, HttpMethod method, String message) {
            this.time = time;
            this.method = method;
            this.message = message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LogToken that = (LogToken) o;

            return Objects.equals(time, that.time)
                    && method.equals(that.method)
                    && Objects.equals(message, that.message);
        }

        @Override
        public int hashCode() {
            int result = time != null ? time.hashCode() : 0;
            result = 31 * result + (method != null ? method.hashCode() : 0);
            result = 31 * result + (message != null ? message.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("LogToken{");
            sb.append("time=").append(time);
            sb.append(", method=").append(method);
            sb.append(", message='").append(message).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    enum HttpMethod {
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




