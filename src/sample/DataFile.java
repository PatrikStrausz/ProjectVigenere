package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataFile {


    public String printFileData(String sourceFile) {

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

    public String encrypt(String sourceFile, String targetFile, String text, String key) throws IOException {
        StringBuilder res = new StringBuilder();
        File source = new File(sourceFile);
        File target = new File(targetFile);
        FileWriter writer = new FileWriter(target);
        Scanner reader = new Scanner(source);


        while (reader.hasNextLine()) {

            text = reader.nextLine();
            text = text.toUpperCase();
            key = key.toUpperCase();

            for (int i = 0, j = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (c < 'A' || c > 'Z') {
                    res.append(c);
                    continue;

                }
                res.append((char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A'));
                j = ++j % key.length();

            }


        }
        writer.write(res.toString());

        System.out.println("Original text: " + text);
        System.out.println("Key: " + key);
        System.out.println("Encrypted: " + res);


        reader.close();
        writer.close();
        return res.toString();
    }

    public String decrypt(String sourceFile, String targetFile, String text, String key) throws IOException {


        StringBuilder res = new StringBuilder();


        File source = new File(sourceFile);
        File target = new File(targetFile);
        FileWriter writer = new FileWriter(target);
        Scanner reader = new Scanner(source);


        while (reader.hasNextLine()) {

            text = reader.nextLine();

            key = key.toUpperCase();
            text = text.toUpperCase();
            for (int i = 0, j = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (c < 'A' || c > 'Z') {
                    res.append(c);
                    continue;
                }
                res.append((char) ((c - key.charAt(j) + 26) % 26 + 'A'));
                j = ++j % key.length();
            }

        }
        writer.write(res.toString());

        System.out.println("Original text: " + text);
        System.out.println("Key: " + key);
        System.out.println("Decrypted: " + res);


        reader.close();
        writer.close();
        return res.toString();

    }


}
