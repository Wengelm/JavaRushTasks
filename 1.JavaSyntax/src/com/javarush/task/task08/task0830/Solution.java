package com.javarush.task.task08.task0830;


import java.io.BufferedReader;

import java.io.InputStreamReader;



/* Задача по алгоритмам

Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.

*/


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)

    {
        /*используем самый обычный метод сортировки "пузырьком" и ничего не выдумываем более*/

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (isGreaterThan(array[j], array[j + 1])) {
                    String t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
        //напишите тут ваш код
    }


    //Метод для сравнения строк: 'а' больше чем 'b'

    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}