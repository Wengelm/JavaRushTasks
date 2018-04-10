package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        BufferedReader file1 = new BufferedReader(new FileReader(filename1));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(filename2));
        StringBuffer string = new StringBuffer();
        String result;
        while (file1.ready()) {
            string.append((char)file1.read());
        }
        file1.close();
        result = string.toString().replaceAll("[\\pP\\s\\n]","");
        file2.write(result);
        file2.close();
    }
}
