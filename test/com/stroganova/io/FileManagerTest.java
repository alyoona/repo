package com.stroganova.io;

import org.junit.*;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class FileManagerTest {

    @Before
    public void before()throws IOException {
        File parentDir = new File("parentDir");
        parentDir.mkdir();
        File newFile = new File("parentDir\\file.log");
        newFile.createNewFile();
        for(int i = 0; i < 5; i++) {
            String path = parentDir.getAbsolutePath() + "\\dir_" + i;
            parentDir = new File(path);
            parentDir.mkdir();
            String pathFile = path + "\\file_"+ i + ".log";
            newFile = new File(pathFile);
            newFile.createNewFile();
        }
    }

    @After
    public void after(){
        FileManager.remove("parentDir");
        FileManager.remove("parentDir3");
    }

    @Test
    public void testCalculateFiles() {
        assertEquals(6, FileManager.calculateFiles("parentDir"));
    }

    @Test
    public void testCalculateDirs() {
        assertEquals(5, FileManager.calculateDirs("parentDir"));
    }

    @Test
    public void testCopy() {
        FileManager.copy("parentDir", "parentDir2");
        assertEquals(6, FileManager.calculateFiles("parentDir"));
        assertEquals(5, FileManager.calculateDirs("parentDir"));
        assertEquals(6, FileManager.calculateFiles("parentDir2"));
        assertEquals(5, FileManager.calculateDirs("parentDir2"));
    }

    @Test
    public void testMove() {
        FileManager.move("parentDir2", "parentDir3");
        assertEquals(6, FileManager.calculateFiles("parentDir3"));
        assertEquals(5, FileManager.calculateDirs("parentDir3"));
        File parentDir2 = new File("parentDir2");
        assertEquals(false, parentDir2.exists());
    }
}
