package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        FileInputStream fis = new FileInputStream(fileName);
        Set<Integer> s = new HashSet<>();
        while (fis.available() > 0) {
            int b = fis.read();
            s.add(b);
        }
        fis.close();
        ArrayList<Integer> a = new ArrayList<>(s);
        Collections.sort(a);
        for (int b: a ) {
            System.out.print(b + " ");
        }
    }
}