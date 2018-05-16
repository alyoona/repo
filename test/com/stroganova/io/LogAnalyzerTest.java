package com.stroganova.io;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static java.time.Month.MARCH;
import static org.junit.Assert.assertEquals;

public class LogAnalyzerTest {

    @Test
    public void test() {
        LocalDateTime ldt = LocalDateTime.of(2004, 03, 07, 16, 10, 02);
        LocalDateTime exp = LogAnalyzer.getLocalDateTime("[07/03/2004:16:10:02");
        Month.valueOf("Mar");
        assertEquals(exp, ldt);
    }

}
