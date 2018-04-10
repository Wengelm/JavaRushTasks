package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(filename1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename2));
        String result;
        StringBuffer string = new StringBuffer();
        int i = 0;
        while (fileReader.ready()) {
            string.append((char) fileReader.read());
        }
        
        result = string.toString().replaceAll("\\.","!");
        fileWriter.write(result);
        fileReader.close();
        fileWriter.close();
    }
}