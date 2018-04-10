package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Lolka", 501);
        map.put("Lol2ka", 511);
        map.put("Lol5ka", 5021);
        map.put("Lol3ka", 700);
        map.put("1Lolka", 400);
        map.put("Lol1ka", 500);
        map.put("Lo4lka", 506);
        map.put("2Lolka", 502);
        map.put("Lo2lka", 250);
        map.put("Lol34ka", 300);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            if (it.next().getValue() < 500) {
                it.remove();
            }
        }


    }

    public static void main(String[] args) {

    }
}