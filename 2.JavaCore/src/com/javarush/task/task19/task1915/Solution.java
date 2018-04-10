package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        String filePath = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            filePath = reader.readLine();
            reader.close();
        }catch (Exception e){
            System.out.println(e);
        }

        PrintStream outBackup = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream moddedPrintStream = new PrintStream(outputStream);
        System.setOut(moddedPrintStream);

        testString.printSomething();

        System.setOut(outBackup);

        try {
            // записываем в файл
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(outputStream.toByteArray());
            fileOutputStream.close();
            System.out.println(outputStream.toString());
        }catch (Exception e){
            System.out.println(e);
        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

