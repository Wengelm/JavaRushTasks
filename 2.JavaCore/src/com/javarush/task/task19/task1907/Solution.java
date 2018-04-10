package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        FileReader file = new FileReader(filename);
        Pattern p =  Pattern.compile("\\bworld\\b");
        StringBuffer string = new StringBuffer();
        while (file.ready()) {
            string.append((char) file.read());

        }
        file.close();

        Matcher m = p.matcher(string);
        int count =0;
        while (m.find()) {
            count++;

        }
        System.out.println(count);
    }
}
