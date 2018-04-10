package com.javarush.task.task08.task0817;

import java.util.Collections;
import java.util.HashMap;

import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put("Ivanov1", "Ivan");
        map.put("Ivanov", "Sergei");
        map.put("Ivan5ov3", "Ivan");
        map.put("Iva4nov", "Lolita");
        map.put("Ivanov2", "Anna");
        map.put("Iva2nov", "Pavel");
        map.put("Iva22nov", "Bogdan");
        map.put("Iva3nov", "Sasha");
        map.put("Ivan1ov", "Tailer");
        map.put("Iva15nov", "Ivan");

        return map;

        //напишите тут ваш код

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if ((Collections.frequency(copy.values(), pair.getValue())) > 1)
                removeItemFromMapByValue(map, pair.getValue());//напишите тут ваш код
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
