package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> fileList=new ArrayList<>();
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader=new BufferedReader(new FileReader(buf.readLine()));
        buf.close();
        while (reader.ready()){
            fileList.add(reader.readLine());
        }

        for ( String s:fileList
                ) {
            StringBuilder rev=new StringBuilder();
            rev.append(s);
            rev.reverse();
            System.out.println(rev.toString());
        }
        reader.close();
    }
}
