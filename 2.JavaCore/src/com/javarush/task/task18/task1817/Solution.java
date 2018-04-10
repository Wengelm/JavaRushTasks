package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int n1 = 0;
        int n2 = 0;
        FileInputStream fis = new FileInputStream(args[0]);
        while (fis.available() > 0) {
            if (Character.compare((char)fis.read(), ' ') == 0) {
                n2++;
            }
            n1++;
        }
        fis.close();
        System.out.printf("%.2f", (float)n2/n1*100);

    }
}
