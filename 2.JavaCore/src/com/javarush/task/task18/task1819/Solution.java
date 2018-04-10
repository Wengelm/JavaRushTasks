package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader n1 = new BufferedReader(new InputStreamReader(System.in));

        String file1 = n1.readLine();
        String file2 = n1.readLine();

        n1.close();

        FileInputStream in = new FileInputStream(file1);
        byte[] data = new byte[in.available()];
        in.read(data);
        in.close();

        FileOutputStream out = new FileOutputStream(file1);
        FileInputStream in2 = new FileInputStream(file2);
        byte[] data2 = new byte[in2.available()];
        in2.read(data2);
        out.write(data2);

        out.write(data);
        out.close();
        in2.close();


    }
}
