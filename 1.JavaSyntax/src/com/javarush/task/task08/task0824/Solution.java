package com.javarush.task.task08.task0824;

import java.util.ArrayList;
/*
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        Human sasha = new Human();
        sasha.age = 2;
        sasha.sex = true;
        sasha.name = "Sasha";

        Human masha = new Human();
        masha.age = 1;
        masha.sex = true;
        masha.name = "Masha";

        Human glasha = new Human();
        glasha.age = 3;
        glasha.sex = true;
        glasha.name = "Glasha";

        Human father = new Human();
        father.age = 29;
        father.sex = true;
        father.name = "Папа";
        father.children.add(glasha);
        father.children.add(sasha);
        father.children.add(masha);

        Human mam = new Human();
        mam.age = 33;
        mam.sex = false;
        mam.name = "Мама";
        mam.children.add(glasha);
        mam.children.add(sasha);
        mam.children.add(masha);

        Human gpapp = new Human();
        gpapp.age = 63;
        gpapp.sex = true;
        gpapp.name = "Petrovna";
        gpapp.children.add(father);


        Human gmamp = new Human();
        gmamp.age = 63;
        gmamp.sex = false;
        gmamp.name = "Petrovna";
        gmamp.children.add(father);

        Human gpapm = new Human();
        gpapm.age = 63;
        gpapm.sex = true;
        gpapm.name = "Petrovna";
        gpapm.children.add(mam);

        Human gmamm = new Human();
        gmamm.age = 63;
        gmamm.sex = false;
        gmamm.name = "Petrovna";
        gmamm.children.add(mam);

        System.out.println(gpapp);
        System.out.println(gmamp);
        System.out.println(gpapm);
        System.out.println(gmamm);


        System.out.println(father);
        System.out.println(mam);
        System.out.println(masha);
        System.out.println(sasha);
        System.out.println(glasha);


        //напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        //напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}