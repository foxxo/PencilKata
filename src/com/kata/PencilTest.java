package com.kata;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PencilTest {

    Paper testPage;
    Pencil testPencil;

    @Before
    public void setUp() {
        testPage = new Paper();
        testPencil = new Pencil();
    }

    @Test
    public void PencilWritesTextToBlankPage() {
        testPencil.writeToPage(testPage, "TEST");
        assertEquals("TEST", testPage.pageText);
    }


    @Test
    public void PencilAttendTextToWrittenPage() {
        testPage.pageText = "test";
        testPencil.writeToPage(testPage, "TEST");
        assertEquals("testTEST", testPage.pageText);

    }

}