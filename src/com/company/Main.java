package com.company;
import java.lang.String;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("PlainText: ");
        String text = input.nextLine();

        System.out.println("Provide the key: ");
        int key = input.nextInt();

        System.out.println("Cipher text:" + Encrypt(text, key));
    }


    public static String Encrypt(String text, int shift)
    {
        StringBuilder encryptedText= new StringBuilder();
        int length = text.length();

        if(shift > 26)
            shift = shift % 26;

        else if(shift < 0)
            shift = (shift % 26) + 26;

        for (int i = 0; i < length; i++)
        {
            char charr = text.charAt(i);
            if (Character.isLetter(charr))
            {
                if(Character.isUpperCase(charr))
                {
                    char ch = (char)(charr + shift);
                    if(ch > 'Z')
                        encryptedText.append((char) (charr - (26 - shift)));

                    else
                        encryptedText.append(ch);
                }

                else if (Character.isLowerCase(charr))
                {
                    char ch = (char)(charr + shift);
                    if(ch > 'z')
                        encryptedText.append((char) (charr - (26 - shift)));

                    else
                        encryptedText.append(ch);
                }

            }

            else
                encryptedText.append(charr);

        }

        return encryptedText.toString();
    }
}
