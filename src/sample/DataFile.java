package sample;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataFile {


    public String printFile(String sourceFile) {


        StringBuilder data = new StringBuilder();
        try{
            File myFile = new File(sourceFile);
            Scanner myReader = new Scanner(myFile);
            while(myReader.hasNextLine()){
                data.append("\n").append(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data.toString();


    }


    public String encrypt(String sourceFile, String destFile, String Message, String Key) {
        try {

            FileWriter fr = new FileWriter(destFile);
            BufferedReader myReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(sourceFile)), Charset.forName("UTF-8")));

            int c;
            while ((c = myReader.read()) != -1) {

                String EMessage = "";
                Message = Message.toLowerCase();
                for (int i = 0, j = 0; i < Message.length(); i++) {
                    char letter = Message.charAt(i);
                    EMessage += (char)(((letter - 65) + (Key.charAt(j)-65)) % 26 + 65);
                    j = ++j % Key.length();
                }
                return EMessage;
            }


            } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();

    } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
