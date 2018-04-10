package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {


    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Person person = null;
            String[] a = fileScanner.nextLine().split(" ");
            String firstname = a[1];
            String middlename = a[2];
            String lastname = a[0];
            String date3 = a[3] + a[4] + a[5];
            Calendar calendar = new GregorianCalendar(Integer.parseInt(a[5]),Integer.parseInt(a[4])-1,Integer.parseInt(a[3]));
            Date date = calendar.getTime();

            person = new Person(firstname, middlename,lastname, date);


            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }

}
