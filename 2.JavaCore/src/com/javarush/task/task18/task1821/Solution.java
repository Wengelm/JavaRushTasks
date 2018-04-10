package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.sql.SQLOutput;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        long Starting = System.currentTimeMillis();

        BufferedReader bufferedReader = new BufferedReader(new FileReader((args[0])));

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Integer count;

        while(bufferedReader.ready()){
            int a=bufferedReader.read();
            count = map.get(a);
            if (count!=null){
                count++;
            }
            else count=1;
            map.put(a, count);
        }

        bufferedReader.close();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            char k = (char)entry.getKey().byteValue();
            int v = entry.getValue();

            System.out.println(k + " " + v);
        }


    }
}
