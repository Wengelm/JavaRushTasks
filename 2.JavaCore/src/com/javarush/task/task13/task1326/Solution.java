package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inStream = new FileInputStream(reader.readLine());

        BufferedReader numdersReader = new BufferedReader(new InputStreamReader(inStream));

        numdersReader.lines()
                .mapToInt(Integer::parseInt)
                .filter(i->i%2==0)
                .sorted()
                .forEach(System.out::println);

        numdersReader.close();
        inStream.close();
        reader.close();
    }
}
