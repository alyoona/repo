package com.stroganova.io;

import java.io.*;

public class TestConsoleInOut {

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        System.out.println(reader.ready());
        int line = reader.read();
        System.out.println(reader.ready());
        writer.write(line);
        writer.newLine();
        writer.flush();
        reader.close();
        writer.close();



    }

}
