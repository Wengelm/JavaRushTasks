package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();

        while (fileReader.ready()) {
            String[] parts = fileReader.readLine().split(" ");
            if (map.containsKey(parts[0])) {
                Double value = map.get(parts[0]) + Double.parseDouble(parts[1]);
                map.put(parts[0], value);
            }
            else map.put(parts[0], Double.parseDouble(parts[1]));
        }

        fileReader.close();

   for (Map.Entry<String, Double> pair : map.entrySet()) {
        System.out.println(pair.getKey() + " " + pair.getValue());
       }

    }
}
