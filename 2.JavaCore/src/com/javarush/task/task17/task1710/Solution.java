package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    private static void update(int id, String name, Sex sex, String bd) throws ParseException {
        Person person = allPeople.get(id);
        person.setName(name);
        person.setSex(sex);
        person.setBirthDay(date.parse(bd));
    }

    private static void delete(int id) throws ParseException {
        Person person = allPeople.get(id);
        person.setName(null);
        person.setBirthDay(null);
        person.setSex(null);
    }

    private static void show(int id) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
        Person person = allPeople.get(id);
        System.out.println(String.format("%s %s %s", person.getName(), person.getSex() == Sex.MALE ? "м" : "ж", format.format(person.getBirthDay())));
    }


    public static void main(String[] args) throws ParseException {
        String name;
        Person person = null;
        Date bd;

        if (args.length != 0)
            switch (args[0]) {
                case "-c":
                    name = args[1];
                    bd = date.parse(args[3]);
                    if (args[2].equals("м")) {
                        person = Person.createMale(name, bd);

                    } else if (args[2].equals("ж")) {
                        person = Person.createFemale(name, bd);
                    }
                    allPeople.add(person);
                    System.out.println(allPeople.indexOf(person));
                    break;
                case "-u":
                    if (args[3].equals("м")) {
                        update(Integer.parseInt(args[1]), args[2], Sex.MALE, args[4]);
                    }
                    if (args[3].equals("ж")) {
                        update(Integer.parseInt(args[1]), args[2], Sex.FEMALE, args[4]);
                    }
                    break;
                case "-d":
                    delete(Integer.parseInt(args[1]));
                    break;

                case "-i":
                    show(Integer.parseInt(args[1]));
                    break;


            }
    }
}
