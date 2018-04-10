package com.javarush.task.task39.task3909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/*
Одно изменение
*/
public class Solution {

    static LinkedList<Character> firstList;

    static LinkedList<Character> secondList;

    public static void main(String[] args) throws IOException

    {



        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(isOneEditAway(bufferedReader.readLine(),bufferedReader.readLine()));



    }



    public static boolean isOneEditAway(String first, String second)

    {

        firstList = new LinkedList<Character>();

        secondList = new LinkedList<Character>();

        //листы нужны  для Collections.frequency

        for (Character character : first.toCharArray()) firstList.add(character);

        for (Character character : second.toCharArray()) secondList.add(character);



        if (first.equals(second)) return false;

        if ( first.equals("") || second.equals("")) return false;

        //когда строчки равны по длине

        if (first.length() == second.length())

        {

            int count = 0;

            for (int i = 1; i < first.length(); i++)

            {

                if (first.charAt(i) != second.charAt(i)) {count++;}

            }

            if (count == 1) return true; else  return false;

        }

        else

            //когда первая строчка длиннее на 1 символ

            if (first.length() - second.length() == 1)

            {

                //лист позиций буквы, у которой разная частота повторений в строчках

                ArrayList<Integer> positions = new ArrayList<Integer>();

                // пробегаем и смотрим по буквам из первой строчки, где частота разная, это и есть наши кандидаты на удаление

                for (int i = 0; i < first.length(); i++)

                {

                    if (Collections.frequency(firstList,firstList.get(i)) != Collections.frequency(secondList,firstList.get(i)))

                        positions.add(i);

                }

                // пробегаем по листу с позициями, удаляем символ, сравниваем строчки, если не равны то вставляем символ обратно и го снова искать

                for( Integer i : positions){

                    Character character = firstList.get(i);

                    firstList.remove(firstList.get(i));

                    if (Arrays.equals(firstList.toArray(),secondList.toArray())) return true; else

                        firstList.add(i,character);

                }

            }

            else

                //когда вторая строчка длиннее на 1 символ

                //код аналогичный

                if (second.length() - first.length() == 1)

                {

                    ArrayList<Integer> positions2 = new ArrayList<Integer>();



                    for (int i = 0; i < second.length(); i++)

                    {

                        if (Collections.frequency(secondList,secondList.get(i)) != Collections.frequency(firstList,secondList.get(i)))

                            positions2.add(i);

                    }



                    for(Integer i : positions2){

                        Character character = secondList.get(i);

                        secondList.remove(secondList.get(i));

                        if (Arrays.equals(firstList.toArray(),secondList.toArray())) return true;

                        secondList.add(i,character);

                    }

                }



        return false;

    }

}
