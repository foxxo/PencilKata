package com.kata;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PencilTest {

    @Test
    public void PencilWritesTextToBlankPage()
    {
        Paper testPage = new Paper();
        Pencil testPencil =  new Pencil();

        testPencil.writeToPage(testPage, "TEST");
        assertEquals("TEST", testPage.pageText);
    }
}
