package com.stroganova.io;

import org.junit.*;

import java.io.File;
import java.io.IOException;

public class FileManagerTest {

    @Test
    public void testCalculateFiles() {
        int count = FileManager.calculateFiles("D:\\_Programming\\_Yona\\repo\\parentDir");
        System.out.println(count);

    }

    @Test
    public void testCalculateDirs() {
        int count = FileManager.calculateDirs("D:\\_Programming\\_Yona\\repo\\parentDir");
        System.out.println(count);

    }
}
