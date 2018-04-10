package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        StringWriter writer = getAllDataFromInputStream (new FileInputStream ("c:/111.txt"));
        System.out.println (writer.toString ( ));
    }

    public static StringWriter getAllDataFromInputStream(InputStream is)
    {
        StringWriter stringWriter = new StringWriter ( );
        int           ch;
        StringBuilder sb = new StringBuilder ( );
        try
        {
            while ((ch = is.read ( )) != -1)
            {
                sb.append ((char) ch);
            }
            stringWriter.write (sb.toString ( ));
        }
        catch (Exception e)
        {
            return new StringWriter ( );
        }
        return stringWriter;
    }
}