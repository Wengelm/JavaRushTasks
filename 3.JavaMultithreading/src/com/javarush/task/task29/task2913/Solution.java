package com.javarush.task.task29.task2913;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        return IntStream
                .rangeClosed(a > b ? b : a, a > b ? a : b)
                .boxed()
                .sorted( (i1, i2)-> a > b ? i2.compareTo(i1) : i1.compareTo(i2) )
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}