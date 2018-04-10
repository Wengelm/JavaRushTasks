package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {








        BufferedReader reader = new BufferedReader(new FileReader(new File(new BufferedReader(new InputStreamReader(System.in)).readLine())));
        while(reader.ready()){
            String line = reader.readLine();
            if(line.startsWith(args[0] + " ")){
                System.out.println(line);
            }
        }
        reader.close();
    }
}
