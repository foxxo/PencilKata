package com.kata;

public class Pencil {

    int durability;
    int maxDurability;
    int length;
    int eraserDurability;


    Pencil(int pDurability, int pLength, int pEraserDurability) {
        maxDurability = pDurability;
        durability = pDurability;
        length = pLength;
        eraserDurability = pEraserDurability;
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
        target.pageText = textToWrite;
    }

    public void sharpen()
    {
        length--;
        if(length >= 0)
            durability = maxDurability;
    }

    public void eraseFromPage(Paper target, String text)
    {
        int replacementIndex = target.pageText.lastIndexOf(text);

        String newText = target.pageText.substring(0,replacementIndex);

        char[] erasedText = new char[text.length()];
        for(int i = text.length()-1; i >= 0; i--)
        {
            if(eraserDurability > 0 && !Character.isWhitespace(text.charAt(i)))
            {
                erasedText[i] = ' ';
                eraserDurability--;
            }
            else
            {
                erasedText[i] = text.charAt(i);
            }
        }


        newText += new String(erasedText) + target.pageText.substring(replacementIndex + text.length());

        target.pageText = newText;
    }

    public void eraseAndEdit(Paper target, String text, String replacement)
    {
        int editingPosition = target.pageText.lastIndexOf(text);
        eraseFromPage(target, text);

        String newText = target.pageText.substring(0, editingPosition) + replacement + target.pageText.substring(editingPosition + text.length());
        target.pageText = newText;
    }
}
