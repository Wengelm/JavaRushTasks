package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        //String file = "c:/test/nn.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        reader.close();
        StringBuilder sb = new StringBuilder();
        while (br.ready()) {
            sb.append(br.readLine());
            sb.append(" ");
        }
        br.close();
        //...
        StringBuilder result = getLine(sb.toString().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0)
            return sb;
        sb.append(words[0]);

        //int nulls = 0;
        //while (nulls < words.length-1){
        for (int e = 0; e < words.length; e++) {
            for (int i = 0; i < words.length; i++) {
                String first = sb.toString().substring(0, 1).toLowerCase();
                String second = sb.toString().substring(sb.length()-1, sb.length()).toLowerCase();

                if (words[i] != null){
                    //System.out.println(first + "*" + second + "---" +words[i].toString().substring(0, 1).toLowerCase() + "*" + words[i].substring(words[i].length()-1));
                    if (words[i].substring(words[i].length()-1, words[i].length()).toLowerCase().equals(first)){
                        String s = words[i] + " " + sb.toString();

                        sb = new StringBuilder(s);
                        //nulls++;
                    }else if (words[i].toString().substring(0, 1).toLowerCase().equals(second)){
                        sb.append(" " + words[i]);

                        //nulls++;
                    }
                }
            }
        }

        return sb;
    }
}
