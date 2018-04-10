package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat birthInfo = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void create (String[] args) throws ParseException{
        Date birth;
        Person person = null;

        for (int i = 0; i < ((args.length - 1) / 3) ; i++) {

            birth = sdf.parse(args[(i * 3) + 3]);

            if (args[(i * 3) + 2].equals("м")) {
                person = Person.createMale(args[(i * 3) + 1], birth);
                allPeople.add(person);
            }
            else if (args[(i * 3) + 2].equals("ж")) {
                person = Person.createFemale(args[(i * 3) + 1], birth);
                allPeople.add(person);
            }

            //System.out.println(person.getName() + " " + (person.getSex() == Sex.FEMALE ? "ж" : "м")
            //    + " " + birthInfo.format(person.getBirthDay()));
            System.out.print(allPeople.lastIndexOf(person) + " ");
        }

    }

    public static void update (String[] args) throws ParseException {
        Date birth;

        for (int i = 0; i < ((args.length - 1) / 3) ; i++) {
            birth = sdf.parse(args[(i * 4) + 4]);

            allPeople.get(Integer.parseInt(args[(i * 4) + 1])).setName(args[(i * 4) + 2]);
            allPeople.get(Integer.parseInt(args[(i * 4) + 1])).setBirthDay(birth);

            if (args[(i * 4) + 3].equals("м"))

                allPeople.get(Integer.parseInt(args[(i* 4) + 1])).setSex(Sex.MALE);

            else if (args[(i * 4) + 3].equals("ж"))
                allPeople.get(Integer.parseInt(args[(i * 4) + 1])).setSex(Sex.FEMALE);




        }





    }

    public static void delete (String[] args){

        for (int i = 1; i < args.length ; i++) {

            allPeople.get(Integer.parseInt(args[i])).setName(null);
            allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
            allPeople.get(Integer.parseInt(args[i])).setSex(null);

        }



    }

    public static void inform (String[] args) {

        for (int i = 1; i < args.length ; i++) {

            Person Temp = allPeople.get(Integer.parseInt(args[i]));

            System.out.println(Temp.getName() + " " + (Temp.getSex() == Sex.FEMALE ? "ж" : "м")
                    + " " + birthInfo.format(Temp.getBirthDay()));

        }



    }


    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c" :
                synchronized (allPeople){
                    create(args);}
                break;
            case "-u" :
                synchronized (allPeople){update(args);}
                break;
            case "-d" : synchronized (allPeople){delete(args);}
                break;
            case "-i" : synchronized (allPeople){inform(args);}
                break;
        }

    }
}
