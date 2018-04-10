package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public Properties propert = new Properties();

    public void fillInPropertiesMap() throws Exception {
        //1. Метод fillInPropertiesMap должен считывать данные с консоли.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine(); // c:/tmp/properties.txt
        reader.close();

        // 2. Метод fillInPropertiesMap должен создавать FileInputStream, передавая считанную строку в качестве параметра.
        FileInputStream fileInputStream = new FileInputStream(fileName);

        // 3. Метод fillInPropertiesMap должен вызывать метод load передавая только что созданный FileInputStream в качестве параметра.
        load(fileInputStream);

    }


    // 4. Метод save должен сохранять карту properties в полученный в качестве параметра объект типа OutputStream.
    public void save(OutputStream outputStream) throws Exception {
        for (Map.Entry pair : this.properties.entrySet()) {
            propert.setProperty((String)pair.getKey(),(String) pair.getValue());
        }
        propert.store(outputStream, null);
    }

    //5. Метод load должен восстанавливать состояние карты properties из полученного в качестве параметра объекта типа InputStream.
    public void load(InputStream inputStream) throws Exception {
        propert.load(inputStream);
        for (Map.Entry pair : propert.entrySet()){
            properties.put((String)pair.getKey(), (String) pair.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();

        for (Map.Entry pair : solution.properties.entrySet()) {
            System.out.println(pair);
        }

        FileOutputStream fileOutputStream = new FileOutputStream("c:/tmp/55555.txt");
        solution.save(fileOutputStream);
        fileOutputStream.close();

    }
}
