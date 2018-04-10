package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream defaultStream = System.out; //стрим дефолт

        ByteArrayOutputStream byteArrStream = new ByteArrayOutputStream(); // массив
        PrintStream arrStream = new PrintStream(byteArrStream); //поток с массивом
        System.setOut(arrStream); //вывод в массив
        testString.printSomething(); // вывели в массив
        String s = byteArrStream.toString(); // массив к строке
        System.setOut(defaultStream); // вернуть всё взад

        System.out.println(s.replaceAll("\\D", "")); //убрать нецифры
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
