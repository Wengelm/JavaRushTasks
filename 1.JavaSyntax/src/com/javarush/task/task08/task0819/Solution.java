package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        cats.remove(cats.toArray()[0]);
        printCats(cats);

    }

    public static Set<Cat> createCats() {
        Set<Cat> cats = new HashSet<>();

        for (int i = 0; i < 3; i++) {

            cats.add(new Cat());
        }
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        for (Cat c : cats) {
            System.out.println(c.toString());
        } // step 4 - пункт 4
    }

    public static class Cat {

        public Cat() {

        }


    }// step 1 - пункт 1
}
