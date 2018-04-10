package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Elo", new Date("AUGUST 1 1980"));
        map.put("El", new Date("DECEMBER 1 1980"));
        map.put("Eli", new Date("OCTOBER 1 1980"));
        map.put("Elin", new Date("OCTOBER 1 1980"));
        map.put("Russy", new Date("May 5 1980"));
        map.put("Pups", new Date("June 1 1980"));
        map.put("Euzana", new Date("July 1 1980"));
        map.put("Tenchik", new Date("August 1 1980"));
        map.put("Yussy", new Date("September 1 1980"));


        return map;//напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {


        Iterator<HashMap.Entry<String, Date>> iterator = map.entrySet().iterator();
        Map.Entry<String, Date> map1;

        while (iterator.hasNext()) {
            map1 = iterator.next();
            if (map1.getValue().getMonth() > 4 && map1.getValue().getMonth() < 8) {
                iterator.remove();
            }
        }
    } //напишите тут ваш код


    public static void main(String[] args) {

    }
}
