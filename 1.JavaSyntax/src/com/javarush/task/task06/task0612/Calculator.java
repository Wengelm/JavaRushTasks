package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        int sum = a + b;//напишите тут ваш код
        return sum;
    }

    public static int minus(int a, int b) {
        int minus = a - b;//напишите тут ваш код
        return minus;
    }

    public static int multiply(int a, int b) {
        int mul = a * b;  //напишите тут ваш код
        return mul;
    }

    public static double division(int a, int b) {
        double i = (double) a / b; //напишите тут ваш код
        return i;
    }

    public static double percent(int a, int b) {
        double p = a * b / 100; //напишите тут ваш код
        return p;
    }

    public static void main(String[] args) {

    }
}