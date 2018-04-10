package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;
        ArrayList<String> lists = new ArrayList<>();
        while ((line = fileReader.readLine()) != null){
            lists.add(line);
        }
        fileReader.close();

        if (args[0].equals("-c")){

            long maxID = Long.MIN_VALUE;

            for (String s: lists){
                int idName = Integer.parseInt(s.substring(0,8).trim());
                if (idName > maxID) maxID = idName;
            }
            String id = String.valueOf(++maxID).concat("        ").substring(0,8);
            String prodactName = "";
            for (int j = 1; j < args.length - 2; j++){
                prodactName = prodactName.concat(args[j]);
            }
            prodactName = prodactName.concat("                              ").substring(0,30);
            String price = args[args.length - 2].concat("        ").substring(0,8);
            String quantity = args[args.length - 1].concat("    ").substring(0,4);
            String result = id.concat(prodactName.concat(price.concat(quantity)));
            lists.add(result);


            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            for (String s: lists){
                fileWriter.write(s);
                fileWriter.newLine();
            }
            fileWriter.close();
        }
    }
}
