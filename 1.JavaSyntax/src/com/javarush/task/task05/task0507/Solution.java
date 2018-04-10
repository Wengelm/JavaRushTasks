package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0;
        int count = 0;

        for (; true ;) {
            int a = Integer.parseInt(reader.readLine());
            if ( a != -1 ) {
                sum += a;
                count++;
            } else break;

        }//напишите тут ваш код
   System.out.println(sum / count); }
}

