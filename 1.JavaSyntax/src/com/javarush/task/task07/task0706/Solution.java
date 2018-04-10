package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] house = new int[15];
        int chet = 0;
        int nechet = 0;
        for (int i = 0; i < house.length; i++) {
            int r = Integer.parseInt(reader.readLine());
            house[i] = r;
        }
        for (int i = 0; i < house.length; i++) {

            if (i % 2 == 0) {
                chet = chet + house[i];
            } else nechet = nechet + house[i];
        }
        if (chet > nechet) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else if (chet < nechet) {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }//напишите тут ваш код
    }
}
