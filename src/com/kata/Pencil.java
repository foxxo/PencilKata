package com.kata;

public class Pencil {

    int durability;
    int maxDurability;
    int length;

    Pencil(int pDurability, int pLength) {
        maxDurability = pDurability;
        durability = pDurability;
        length = pLength;
    }

    public void writeToPage(Paper target, String text)
    {
        String textToWrite = "";
        for (char c : text.toCharArray())
        {
            if(durability > 0)
            {
                textToWrite += c;
                if(c != ' ' && c != '\n')
                {
                    if (Character.isUpperCase(c))
                        durability -= 2;
                    else
                        durability--;
                }
            }
            else
                textToWrite += " ";
        }
        target.pageText += textToWrite;
    }

    public void sharpen()
    {
        length--;
        if(length >= 0)
            durability = maxDurability;
    }
}
