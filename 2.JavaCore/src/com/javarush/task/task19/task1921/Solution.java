package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try(BufferedReader reader=new BufferedReader(new FileReader(args[0]))){
            StringBuilder name=new StringBuilder();
            while(reader.ready()){
                String[] line=reader.readLine().split(" ");
                for(int i=0,j=line.length-3; i<j; name.append(line[i++]).append(" "));
                name.setLength(name.length()-1);
                PEOPLE.add(new Person(name.toString(),new Date(Integer.parseInt(line[line.length-1])-1900,Integer.parseInt(line[line.length-2])-1,Integer.parseInt(line[line.length-3]))));
                name.setLength(0);
            }
        }catch(IOException e){}


    }
}
