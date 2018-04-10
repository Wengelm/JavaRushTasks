package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("file");
        words.add("type");
        words.add("V");
        words.add("B");
        words.add("string");
        words.add("строку");
        words.add("и");
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "cp1251"));
        int number = 0;

        while (br.ready()) {
            String str = br.readLine();
            String[] tmp = str.split(" ");
            for (int i = 0; i < tmp.length; i++) {
                for (int j = 0; j < words.size(); j++) {
                    if (tmp[i].equals(words.get(j))) {
                        number++;
                    }
                }
            }
            if (number == 2) {
                System.out.println(str);
            }
            number = 0;
        }
        br.close();
    }
}
