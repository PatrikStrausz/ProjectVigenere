package sample;

import java.io.*;
import java.util.Scanner;

public class DataFile {


    public String printFile(String sourceFile) {


        StringBuilder data = new StringBuilder();
        try {
            File myFile = new File(sourceFile);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                data.append("\n").append(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data.toString();


    }


    public String encrypt(String sourceFile, String destFile, String plaintext, String keyword) throws IOException {


        plaintext = plaintext.toUpperCase();
        keyword = keyword.toUpperCase();
        char msg[] = plaintext.toCharArray();
        int msgLen = msg.length;
        int i, j;

        char key[] = new char[msgLen];
        char encryptedMsg[] = new char[msgLen];

        File source = new File(sourceFile);
        File dest = new File(destFile);

        FileWriter writer = new FileWriter(dest);
        Scanner reader = new Scanner(source);

        while (reader.hasNextLine()) {
            plaintext = reader.nextLine();


            for (i = 0, j = 0; i < msgLen; ++i, ++j) {
                if (j == keyword.length()) {
                    j =0;
                }
                key[i] = keyword.charAt(j);
            }


            for (i = 0; i < msgLen; ++i)
                encryptedMsg[i] = (char) (((msg[i] + key[i]) % 26) + 'A');

            writer.write(String.valueOf(encryptedMsg));
        }

        System.out.println("Original Message: " + plaintext);
        System.out.println("Keyword: " + keyword);

        System.out.println("Key: " + String.valueOf(key));
        System.out.println();
        System.out.println("Encrypted Message: " + String.valueOf(encryptedMsg));
        writer.close();
        reader.close();

        return String.valueOf(encryptedMsg);
    }


    public void ddd(String plaintext, String keyword){



        plaintext = plaintext.toUpperCase();
        keyword = keyword.toUpperCase();
        char msg[] = plaintext.toCharArray();
        int msgLen = msg.length;
        int i, j;

        char key[] = new char[msgLen];
        char encryptedMsg[] = new char[msgLen];


        for (i = 0, j = 0; i < msgLen; ++i, ++j) {
            if (j == keyword.length()) {
                j =0;
            }
            key[i] = keyword.charAt(j);
        }


        for (i = 0; i < msgLen; ++i)
            encryptedMsg[i] = (char) (((msg[i] + key[i]) % 26) + 'A');

        System.out.println("Original Message: " + plaintext);
        System.out.println("Keyword: " + keyword);

        System.out.println("Key: " + String.valueOf(key));
        System.out.println();
        System.out.println("Encrypted Message: " + String.valueOf(encryptedMsg));

    }

}
