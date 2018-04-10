package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        Map <String, String> addresses = new HashMap<String, String>();
        while (true) {
            String city = reader.readLine();
            if(city.isEmpty())break;
            String family = reader.readLine();
            if(family.isEmpty() ) break;

            addresses.put(city, family);
        }

        //read home number
        String houseCity = reader.readLine();

        Iterator <Map.Entry<String, String>> iterator = addresses.entrySet().iterator();
        while (iterator.hasNext())
        {  Map.Entry <String,String > addr =iterator.next();
            String keyCity= addr.getKey();
            String valueName= addr.getValue();
            if (keyCity.equals(houseCity))
                System.out.println(valueName);

        }
    }
}
