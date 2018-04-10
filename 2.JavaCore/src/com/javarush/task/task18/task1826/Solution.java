package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws Exception {

        switch (args[0]){
            case "-e":
                encrypt(args[1], args[2]);
                break;
            case "-d":
                decrypt(args[1], args[2]);
                break;
        }
    }

    public static void encrypt(String fileName, String fileOutputName) throws Exception{

        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileOutputName);

        byte[] by = new byte[inputStream.available()];
        inputStream.read(by);

        for (int i = 0; i < by.length/2; i=i+2){
            byte temp = by[i];
            by[i] = by[by.length-1-i];
            by[by.length-1-i] = temp;
        }

        outputStream.write(by);

        outputStream.close();
        inputStream.close();
    }

    public static void decrypt(String fileName, String fileOutputName) throws Exception{
        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileOutputName);

        byte[] by = new byte[inputStream.available()];
        inputStream.read(by);

        for (int i = 0; i < by.length/2; i=i+2){
            byte temp = by[i];
            by[i] = by[by.length-1-i];
            by[by.length-1-i] = temp;
        }

        outputStream.write(by);

        outputStream.close();
        inputStream.close();
    }

}