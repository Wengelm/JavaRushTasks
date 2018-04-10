package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Date readDate = new Date(reader.readLine());
        SimpleDateFormat newDateForm = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        String result = newDateForm.format(readDate);
        System.out.println(result.toUpperCase());
    }
}
