package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        String line;
        while((line = reader.readLine()) != null){
            Pattern p = Pattern.compile("\\S*\\d+\\S*");
            Matcher m = p.matcher(line);

            while (m.find()){
                writer.write(m.group() + " ");
            }
        }

        reader.close();
        writer.close();
    }
}
