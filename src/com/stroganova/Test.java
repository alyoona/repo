package com.stroganova;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.StringJoiner;


public class Test {

    public static void main(String[] args)  {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z").withLocale(Locale.US);
        String str = "07/Mar/2004:16:10:02 -0800";
        LocalDateTime ldt = LocalDateTime.parse(str, formatter);

        String log = "64.242.88.10 - - [07/Mar/2004:16:10:02 -0800] \"GET /mailman/listinfo/hsdivision HTTP/1.1\" 200 6291";
        String[] ar = log.split("\\[|]");
        for(String s : ar) {
            System.out.println(s);
        }

        String method = ar[2].substring(2,5);
        String message = ar[2].substring(6);
        System.out.println(method);
        System.out.println(message);



    }



}

