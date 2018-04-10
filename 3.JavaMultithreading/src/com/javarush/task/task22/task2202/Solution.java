package com.javarush.task.task22.task2202;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
//        Pattern p = Pattern.compile(" [^ ]* [^ ]* [^ ]* [^ ]*");
//        Pattern p = Pattern.compile(" [^ ]* [^ ]* [^ ]* [^ ]+");
//        Pattern p = Pattern.compile(" [^ ]+ [^ ]+ [^ ]+ [^ ]+");
        if (string == null) {
            throw new TooShortStringException();
        }
        Pattern p = Pattern.compile(" [^ ]+ [^ ]+ [^ ]+ [^ ]*");
        Matcher m = p.matcher(string);

        if (m.find()) {
            return m.group().trim();
        } else {
            throw new  TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
