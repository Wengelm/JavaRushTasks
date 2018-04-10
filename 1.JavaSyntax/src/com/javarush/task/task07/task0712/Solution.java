package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int min1 = 10;
        int max1 = 0;

        int length;
        ArrayList<String> stroki = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            stroki.add(s = reader.readLine());
        }
        int min = 0;
        int max = 0;

        for (int i = 0; i < stroki.size(); i++) {
            length = stroki.get(i).length();
            if (length < min1) {
                min1 = length;
                min = i;
            }
            if (length > max1) {
                max1 = length;
                max = i;
            }


        }
        if (min > max) {
            System.out.println(stroki.get(max));

        } else System.out.println(stroki.get(min));
        //напишите тут ваш код
    }
}
