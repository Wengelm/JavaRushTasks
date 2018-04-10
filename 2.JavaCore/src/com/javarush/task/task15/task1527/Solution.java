package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        URL url = new URL(reader.readLine());
        String input = url.getQuery();
        String[] parts = input.split("&");
        String[] result = new String[parts.length];


        for (int i = 0; i < parts.length; i++) {

            if (parts[i].contains("obj")) {
                result[i] = parts[i].substring(0, parts[i].indexOf("="));
                System.out.print(result[i] + " ");
            } else if (parts[i].contains("=")) {
                result[i] = parts[i].substring(0, parts[i].indexOf("="));
                System.out.print(result[i] + " ");

            } else {result[i] = parts[i];
                System.out.print(result[i] + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].contains("obj")) {
                String objResult;
                objResult = parts[i].substring(parts[i].indexOf("=") + 1);

                try {
                    alert(Double.parseDouble(objResult));
                } catch (Exception e) {
                    alert(objResult);
                }
            }
        }
    }  //add your code here


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
