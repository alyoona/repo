package com.stroganova.io;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.io.*;

public class BufferedOutputStreamTest {

    private OutputStream outputStream;
    private BufferedReader reader;

    @Before
    public void before() {
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream("test.log"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("error during openning file for writing", e);
        }

        try {
            reader = new BufferedReader(new FileReader("test.log"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("error during openning file for reading", e);
        }
    }

    @After
    public void after() {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException("something wrong while closing after reading");
        }

        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
            throw new RuntimeException("something wrong while closing after writing");
        }

        File file = new File("test.log");
        file.delete();
    }

    @Test
    public void testWriteByte() throws IOException {
        outputStream.write(72);
        outputStream.flush();
        assertEquals("H", reader.readLine());
        assertEquals(null, reader.readLine());
        reader.close();
    }

    @Test
    public void testWriteByteArray() throws IOException {
        String str = "0123456789";
        outputStream.write(str.getBytes());
        outputStream.flush();
        assertEquals("0123456789", reader.readLine());
        assertEquals(null, reader.readLine());
    }

    @Test
    public void testWriteByteArrayFirstEnd() throws IOException {
        String str = "0123456789";
        outputStream.write(str.getBytes(), 0, 10);
        outputStream.flush();
        assertEquals("0123456789", reader.readLine());
        assertEquals(null, reader.readLine());
    }

    @Test
    public void testWriteByteArrayFirst() throws IOException {
        String str = "0123456789";
        outputStream.write(str.getBytes(), 0, 1);
        outputStream.flush();
        assertEquals("0", reader.readLine());
        assertEquals(null, reader.readLine());
    }

    @Test
    public void testWriteByteArrayEnd() throws IOException {
        String str = "0123456789";
        outputStream.write(str.getBytes(), 9, 1);
        outputStream.flush();
        assertEquals("9", reader.readLine());
        assertEquals(null, reader.readLine());
    }

    @Test
    public void testWriteByteArrayBetweenFirstEnd() throws IOException {
        String str = "0123456789";
        outputStream.write(str.getBytes(), 3, 2);
        outputStream.flush();
        assertEquals("34", reader.readLine());
        assertEquals(null, reader.readLine());
    }


    @Test
    public void testFlush() throws IOException {
        outputStream.write(72);
        assertEquals(null, reader.readLine());
        outputStream.flush();
        assertEquals("H", reader.readLine());
    }

    @Test
    public void testClose() throws IOException {
        outputStream.write(72);
        assertEquals(null, reader.readLine());
        outputStream.close();
        assertEquals("H", reader.readLine());
        assertEquals(null, reader.readLine());
    }
}
