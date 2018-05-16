package com.stroganova.io;

import org.junit.*;
import java.time.LocalDateTime;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogAnalyzerTest {

    private String path = "test.log";
    private List<LogAnalyzer.LogToken> listExp;
    private LogAnalyzer.HttpMethod get = LogAnalyzer.HttpMethod.GET;

    @Before
    public void before() {
        listExp = new ArrayList<>();
    }

    @Test
    public void testScanLogFromEqualsTo() {
        LocalDateTime from = LocalDateTime.of(2004, 03, 07, 16, 05, 49);
        LocalDateTime to = LocalDateTime.of(2004, 03, 07, 16, 05, 49);
        listExp.add(new LogAnalyzer.LogToken(
                LocalDateTime.of(2004, 03, 07, 16, 05, 49),
                get,
                "/twiki/bin/edit/Main/Double_bounce_sender?topicparent=Main.ConfigurationVariables HTTP/1.1\" 401 12846"));
        List<LogAnalyzer.LogToken> listActual = LogAnalyzer.scanLog(path, from, to);
        assertTrue(listExp.equals(listActual));
    }

    @Test
    public void testScanLogBetweenFromAndTo() {
        LocalDateTime from = LocalDateTime.of(2004, 03, 07, 16, 05, 49);
        LocalDateTime to = LocalDateTime.of(2004, 03, 11, 11, 54, 59);
        listExp.add(new LogAnalyzer.LogToken(
                from,
                get,
                "/twiki/bin/edit/Main/Double_bounce_sender?topicparent=Main.ConfigurationVariables HTTP/1.1\" 401 12846"));
        listExp.add(new LogAnalyzer.LogToken(
                LocalDateTime.of(2004, 03, 11, 11, 49, 51),
                get,
                "/ HTTP/1.1\" 304 -"));
        listExp.add(new LogAnalyzer.LogToken(
                to,
                get,
                "/ HTTP/1.1\" 200 3169"));
        List<LogAnalyzer.LogToken> listActual = LogAnalyzer.scanLog(path, from, to);
        assertTrue(listExp.equals(listActual));
    }

    @Test
    public void testScanLogFromTo() {
        LocalDateTime from = LocalDateTime.of(2004, 03, 07, 16, 05, 49);
        LocalDateTime to = LocalDateTime.of(2004, 03, 11, 11, 49, 51);
        listExp.add(new LogAnalyzer.LogToken(
                from,
                get,
                "/twiki/bin/edit/Main/Double_bounce_sender?topicparent=Main.ConfigurationVariables HTTP/1.1\" 401 12846"));
        listExp.add(new LogAnalyzer.LogToken(
                to,
                get,
                "/ HTTP/1.1\" 304 -"));
        List<LogAnalyzer.LogToken> listActual = LogAnalyzer.scanLog(path, from, to);
        assertTrue(listExp.equals(listActual));
    }

    @Test
    public void testScanLogFromBeforeFirstToAfterEnd() {
        LocalDateTime from = LocalDateTime.of(2004, 03, 07, 16, 05, 48);
        LocalDateTime to = LocalDateTime.of(2004, 03, 11, 11, 55, 00);
        listExp.add(new LogAnalyzer.LogToken(
                LocalDateTime.of(2004, 03, 07, 16, 05, 49),
                get,
                "/twiki/bin/edit/Main/Double_bounce_sender?topicparent=Main.ConfigurationVariables HTTP/1.1\" 401 12846"));
        listExp.add(new LogAnalyzer.LogToken(
                LocalDateTime.of(2004, 03, 11, 11, 49, 51),
                get,
                "/ HTTP/1.1\" 304 -"));
        listExp.add(new LogAnalyzer.LogToken(
                LocalDateTime.of(2004, 03, 11, 11, 54, 59),
                get,
                "/ HTTP/1.1\" 200 3169"));
        List<LogAnalyzer.LogToken> listActual = LogAnalyzer.scanLog(path, from, to);
        assertTrue(listExp.equals(listActual));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testScanLogToFrom() {
        LocalDateTime from = LocalDateTime.of(2004, 03, 07, 16, 05, 49);
        LocalDateTime to = LocalDateTime.of(2004, 03, 07, 16, 05, 48);
        List<LogAnalyzer.LogToken> listActual = LogAnalyzer.scanLog(path, from, to);
        assertTrue(listExp.equals(listActual));
    }


    @Test
    public void testGetTime() {
        LocalDateTime ldt = LocalDateTime.of(2004, 03, 07, 16, 10, 02);
        LocalDateTime time = LogAnalyzer.getTime("07/Mar/2004:16:10:02 -0800");
        assertEquals(ldt, time);
    }

    @Test
    public void testIsBetweenFromEqualsTo() {
        LocalDateTime time = LogAnalyzer.getTime("07/Mar/2004:16:10:02 -0800");
        LocalDateTime from = LocalDateTime.of(2004, 03, 07, 16, 10, 02);
        LocalDateTime to = LocalDateTime.of(2004, 03, 07, 16, 10, 02);
        assertTrue(LogAnalyzer.isBetween(time, from, to));
    }

    @Test
    public void testTimeIsBetweenFromAndTo() {
        LocalDateTime time = LogAnalyzer.getTime("07/Mar/2004:16:10:02 -0800");
        LocalDateTime from = LocalDateTime.of(2004, 03, 07, 16, 10, 01);
        LocalDateTime to = LocalDateTime.of(2004, 03, 07, 16, 10, 03);
        assertTrue(LogAnalyzer.isBetween(time, from, to));
        from = LocalDateTime.of(2003, 03, 07, 16, 9, 02);
        to = LocalDateTime.of(2005, 03, 07, 16, 11, 02);
        assertTrue(LogAnalyzer.isBetween(time, from, to));
    }

    @Test
    public void testIsBetweenTimeEqualsFrom() {
        LocalDateTime time = LogAnalyzer.getTime("07/Mar/2004:16:10:02 -0800");
        LocalDateTime from = LocalDateTime.of(2004, 03, 07, 16, 10, 02);
        LocalDateTime to = LocalDateTime.of(2004, 03, 07, 16, 10, 03);
        assertTrue(LogAnalyzer.isBetween(time, from, to));
    }

    @Test
    public void testIsBetweenTimeEqualsTo() {
        LocalDateTime time = LogAnalyzer.getTime("07/Mar/2004:16:10:02 -0800");
        LocalDateTime from = LocalDateTime.of(2004, 03, 07, 16, 10, 01);
        LocalDateTime to = LocalDateTime.of(2004, 03, 07, 16, 10, 02);
        assertTrue(LogAnalyzer.isBetween(time, from, to));
    }

    @Test
    public void testIsNotBetweenFromTo() {
        LocalDateTime time = LogAnalyzer.getTime("07/Mar/2004:16:10:02 -0800");
        LocalDateTime from = LocalDateTime.of(2004, 03, 07, 16, 10, 03);
        LocalDateTime to = LocalDateTime.of(2004, 03, 07, 16, 10, 04);
        assertTrue(!LogAnalyzer.isBetween(time, from, to));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsBetweenFromAfterTo() {
        LocalDateTime time = LogAnalyzer.getTime("07/Mar/2004:16:10:02 -0800");
        LocalDateTime from = LocalDateTime.of(2004, 03, 07, 16, 10, 03);
        LocalDateTime to = LocalDateTime.of(2004, 03, 07, 16, 10, 01);
        assertTrue(!LogAnalyzer.isBetween(time, from, to));
    }


}
