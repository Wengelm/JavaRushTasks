package com.javarush.task.task01.task0133;

/* 
Не думать о секундах…
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getCountSecondsPassedInCurrentHour(12345));
    }

    public static int getCountSecondsPassedInCurrentHour(int seconds) {
        int h = (seconds / (60*60 ));
        int h1 = seconds - ( h / ( 60*60));
        return  h1; //напишите тут ваш код
    }
}