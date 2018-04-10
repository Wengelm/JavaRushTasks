package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        FileReader file1 = new FileReader(filename1);
        FileWriter file2 = new FileWriter(filename2);
        int d;
        for (int i =1; file1.ready(); i++) {
            d = file1.read();
            if ( i%2 ==0) {
                file2.write(d);
            }


        }


        file1.close();
        file2.close();
    }
}
