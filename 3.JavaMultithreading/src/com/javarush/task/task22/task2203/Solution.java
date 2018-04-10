package com.javarush.task.task22.task2203;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }
        Pattern pattern = Pattern.compile("[\\t]");
        Matcher matcher = pattern.matcher(string);
        int count = 0;
        while (matcher.find()){
            count++;
        }
        if (count<2){
            throw  new TooShortStringException();
        }else {
            Pattern p = Pattern.compile("\\t(.*?)\\t",Pattern.DOTALL);
            Matcher m = p.matcher(string);
            while (m.find()) {
                return m.group(1);
            }
        }
        return null;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
