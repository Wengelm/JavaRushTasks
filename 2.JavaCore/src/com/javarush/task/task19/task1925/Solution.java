package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
             FileWriter fileWriter = new FileWriter(args[1]))
        {
            String input = "";
            String output = "";

            while(bufferedReader.ready()){

                input +=bufferedReader.readLine() +  " ";
            }
            input = input.trim();
            String [] data = input.split(" ");

            for (int i = 0; i < data.length; i++) {
                if (data[i].toCharArray().length > 6){
                    output += data[i] + ",";
                }
            }

            output = output.substring(0, output.length() - 1);

            fileWriter.write(output);

        }

    }
}
