package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();

        for (int i = 0; i < 4; i++) {
            result.add(new Cat());
        }

        return result;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> dogs = new HashSet<Dog>();

        for (int i = 0; i < 3; i++) {
            dogs.add(new Dog());
        }//напишите тут ваш код
        return dogs;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        HashSet<Object> all = new HashSet<Object>();
        all.addAll(cats);
        all.addAll(dogs);
        return all;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        pets.removeAll(cats);//напишите тут ваш код
    }

    public static void printPets(Set<Object> pets) {

        for (Object b : pets) {
            System.out.println(b.toString());
        }//напишите тут ваш код
    }

    public static class Cat {
        public Cat() {
        }
    }


    public static class Dog {
        public Dog() {
        }
    }//напишите тут ваш код
}
