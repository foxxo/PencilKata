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
        testPencil = new Pencil(4, 1, 1);
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
        assertEquals(testPencil.durability, 0);

    }

    @Test
    public void PencilDurabilityLossExemptedForWhiteSpace()
    {
        testPencil.writeToPage(testPage, "t \nt");
        assertEquals(testPencil.durability, 2);
    }

    @Test
    public void PencilAtZeroDurabilityWritesWhitespace()
    {
        testPencil.writeToPage(testPage, "testtest");
        assertEquals(testPage.pageText, "test    ");
    }

    @Test
    public void PencilLosesDoubleDurabilityForUpperCase()
    {
        testPencil.writeToPage(testPage, "Test");
        assertEquals(0, testPencil.durability);
    }

    @Test
    public void PencilSharpeningReturnsToFullDurability()
    {
        testPencil.writeToPage(testPage, "Test");
        testPencil.sharpen();
        assertEquals(4, testPencil.durability);
    }

    @Test
    public void PencilSharpenedToStubGainsNoDurability()
    {
        testPencil.writeToPage(testPage, "Test");
        testPencil.sharpen();
        testPencil.writeToPage(testPage, "Test");
        testPencil.sharpen();
        assertEquals(0, testPencil.durability);
    }

    @Test
    public void PencilCanEraseLastIncidenceOfText()
    {
        testPencil.writeToPage(testPage,"test");
        testPencil.eraseFromPage(testPage, "t");

        assertEquals("tes ", testPage.pageText);
    }

    @Test public void PencilEraserLosesDurabilityBackwards()
    {
        testPencil.writeToPage(testPage, "test");
        testPencil.eraseFromPage(testPage, "test");

        assertEquals("tes ", testPage.pageText);
        assertEquals(0, testPencil.eraserDurability);
    }

    @Test public void PencilEraserIgnoresWhitespaceDegradation()
    {
        testPencil.writeToPage(testPage, "t e s t");
        testPencil.eraseFromPage(testPage, "s ");

        assertEquals("t e   t", testPage.pageText);
    }

    @Test public void PencilCanEnterNewLettersOverErased()
    {
        testPencil.eraserDurability = 2;
        testPencil.writeToPage(testPage, "abcd");
        testPencil.sharpen();
        testPencil.eraseAndEdit(testPage, "bc", "x");
        assertEquals("ax d", testPage.pageText);
    }

    @Test public void EraseAndReplaceCollisionsBecomeAmpersands()
    {
        testPencil.writeToPage(testPage, "abcd");
        testPencil.sharpen();
        testPencil.eraseAndEdit(testPage, "a", "xx");
        assertEquals("x@cd", testPage.pageText);
    }
}