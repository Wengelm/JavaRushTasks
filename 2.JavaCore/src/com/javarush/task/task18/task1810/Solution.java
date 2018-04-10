package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
            String fileName=reader.readLine();
            FileInputStream filere=new FileInputStream(fileName);

            if(filere.available()<1000){
                reader.close();
                filere.close();

                throw new DownloadException();
            }filere.close(); }

        }
        catch (IOException e) {

        } }





    public static class DownloadException extends Exception {

    }
}
