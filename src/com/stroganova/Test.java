package com.stroganova;

import com.stroganova.reflection.methods.E;
import com.stroganova.reflection.methods.ReflectionMethods;

import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ReflectionMethods.printParentsAndInterfaces(E.class);
        String line;
        while((line = reader.readLine()) !=null) {

            line = reader.readLine();
        }




    }


}

