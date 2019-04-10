package com.kata;

public class Pencil {

    int durability;

    Pencil(int pDurability) {
        durability = pDurability;
    }

    public void writeToPage(Paper target, String text)
    {
        target.pageText += text;
        text = text.replaceAll("\\s+","");
        durability -= text.length();
    }
}
