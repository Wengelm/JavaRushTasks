package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        //1
        try {
            float i = 1 / 0;

        } catch (ArithmeticException e) {
            exceptions.add(e);
        }
        //2
        try
        {    String szShortString = "123";
            char chr = szShortString.charAt(10);
        }
        catch(StringIndexOutOfBoundsException ex)
        {
            exceptions.add(ex);
        }
        //3
        try  {
            FileInputStream fis = null;
            fis = new FileInputStream("B:/myfile.txt");

        } catch (FileNotFoundException et) {
            exceptions.add(et);
        }
        //4
        try {
            int[] array = new int[2];
            array[0] = 2;
            array[1] = 3;
            array[3] = 3;
        }
        catch (ArrayIndexOutOfBoundsException ew) {
            exceptions.add(ew);
        }

        //5
        try
        {   Object szStr[] = new String[10];
            szStr[0] = new Character('*');
        }
        catch(ArrayStoreException ex)
        {
            exceptions.add(ex);
        }


        //6
        try
        {  Object ch = new Character('*');
            System.out.println((Byte)ch);
        }
        catch(ClassCastException ex)
        {
            exceptions.add(ex);
        }
        //7
        try
        {
            int[] nNegArray = new int[-5];
        }
        catch(NegativeArraySizeException ex)
        {
            exceptions.add(ex);
        }

        //8
        try
        {

            int[] nNulArray = new int[5];
            nNulArray = null;
          int  i = nNulArray.length;
        }
        catch(NullPointerException ex)
        {
            exceptions.add(ex);
        }
        //9
        try {
            int i = -1 * 100;
        } catch (IllegalArgumentException e) {
            exceptions.add(e);
        }
        //10
        try {
            throw new Exception();
        } catch (Exception e){
            exceptions.add(e);
        }
        //11
        try {
            int num = Integer.parseInt("XYZ");
            System.out.println(num);}
        catch (NumberFormatException e) {
            exceptions.add(e);
        }
    }

    }









