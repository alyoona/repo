package com.stroganova.io;



import java.io.InputStream;
import java.io.FileInputStream;
        import java.io.FileNotFoundException;


public class FileUtils {
    public static InputStream getStreamForFile(String path) {
        try {
            return new BufferedInputStream(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("error during openning file", e);
        }
    }
}