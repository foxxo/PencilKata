package com.kata;

public class Pencil {

    int durability;
    int maxDurability;

    Pencil(int pDurability) {
        maxDurability = pDurability;
        durability = pDurability;
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
        durability = maxDurability;
    }
}
