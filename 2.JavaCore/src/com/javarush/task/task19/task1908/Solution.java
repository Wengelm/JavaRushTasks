package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1=reader.readLine();
        String fileName2=reader.readLine();
        reader.close();
        BufferedReader fread=new BufferedReader(new FileReader(fileName1));
        BufferedWriter fwrite=new BufferedWriter(new FileWriter(fileName2));
        Pattern pattern=Pattern.compile("\\d+");
        String strLine=fread.readLine();
        ArrayList<Integer> list=new ArrayList<Integer>();
        while (strLine!=null){
            Matcher m=pattern.matcher(strLine);
            while (m.find()) list.add(Integer.parseInt(m.group()));
            strLine=fread.readLine();
        }
        fread.close();
        for (int i=0;i<list.size();i++){
            if (i+1!=list.size()) fwrite.write(list.get(i)+" "); //если не последний, то добавляем пробел
            else fwrite.write(list.get(i)); //если последний элемент, то просто запсиываем без пробела
        }
        fwrite.close();

    }


}
