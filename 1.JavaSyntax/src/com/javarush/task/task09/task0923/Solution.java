package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        ArrayList<Character> vowelsArray = new ArrayList<>();
        ArrayList<Character> nonvowelsArray = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();

        for (Character character : s.toCharArray()) {
            if (character != ' ') {
                if (isVowel(character))
                    vowelsArray.add(character);
                else
                    nonvowelsArray.add(character);
            }
        }

        for (Character c : vowelsArray)
            System.out.print(c + " ");
        System.out.println();

        for (Character c : nonvowelsArray)
            System.out.print(c + " ");
        System.out.println();

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}