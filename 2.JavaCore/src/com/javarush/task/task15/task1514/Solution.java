package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(2.0,"sd");
        labels.put(2.2,"ssd");
        labels.put(2.3,"sds");
        labels.put(2.1,"ssd");
        labels.put(2.4,"sdd");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
