package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int sum = 0;
        String sNumber = String.valueOf(number);
        int length = sNumber.length();
        for (int i = 0; i < length; i++) {
            int a = Character.getNumericValue(sNumber.charAt(i));
            if (a > 0) {
                sum += a;
            }
        }
        return sum;
    }
}