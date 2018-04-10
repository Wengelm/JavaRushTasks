package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> peoples = new HashMap<String, String>();
        peoples.put("Lol", "Lol");
        peoples.put("Lol1", "Lo2l");
        peoples.put("L3ol", "Lol");
        peoples.put("L5ol", "Losl");
        peoples.put("Lo2l", "Lol");
        peoples.put("Lol", "Loal");
        peoples.put("Lo3l", "Ldsol");
        peoples.put("Lo4l", "Loaasl");
        peoples.put("Lol2", "Loaal");
        peoples.put("Lol1", "Lodl");

        return peoples;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
