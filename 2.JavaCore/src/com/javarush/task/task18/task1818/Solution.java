package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();


        FileOutputStream file1 = new FileOutputStream(name1,true);
        FileInputStream file2 = new FileInputStream(name2);
        FileInputStream file3 = new FileInputStream(name3);
        int count1 = 0;
        int count2 = 0;

        reader.close();


        byte[] buffer1 = new byte[file2.available()];
        byte[] buffer2 = new byte[file3.available()];

        while (file2.available() > 0) count1 = file2.read(buffer1);
        while (file3.available() > 0) count2 = file3.read(buffer2);
        file2.close();
        file3.close();

        file1.write(buffer1);
        file1.write(buffer2);
        file1.close();


    }
}
