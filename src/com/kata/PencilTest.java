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
        testPencil = new Pencil(4);
    }

    @Test
    public void PencilWritesTextToBlankPage() {
        testPencil.writeToPage(testPage, "test");
        assertEquals("test", testPage.pageText);
    }


    @Test
    public void PencilAttendTextToWrittenPage() {
        testPage.pageText = "test";
        testPencil.writeToPage(testPage, "test");
        assertEquals("testtest", testPage.pageText);

    }

    @Test
    public void PencilLosesDurabilityWhenWriting()
    {
        testPencil.writeToPage(testPage, "test");
        assertEquals(0,testPencil.durability);

    }

    @Test
    public void PencilDurabilityLossExemptedForWhiteSpace()
    {
        testPencil.writeToPage(testPage, "t \nt");
        assertEquals(2, testPencil.durability);
    }

    @Test
    public void PencilAtZeroDurabilityWritesWhitespace()
    {
        testPencil.writeToPage(testPage, "testtest");
        assertEquals("test    ", testPage.pageText);
    }

    @Test
    public void PencilLosesDoubleDurabilityForUpperCase()
    {
        testPencil.writeToPage(testPage, "Test");
        assertEquals(testPencil.durability, 0);
    }



}