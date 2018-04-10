package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = null;
        Movie movie = null;


        while (true) {
            key = reader.readLine();

            if (key.equals("cartoon") || key.equals("thriller") || key.equals("soapOpera")) {

                if (key.equals("cartoon")) {

                    movie = MovieFactory.getMovie(key);
                    System.out.println(movie.getClass().getSimpleName());
                }
                if (key.equals("thriller")) {
                    movie = MovieFactory.getMovie(key);
                    System.out.println(movie.getClass().getSimpleName());
                }
                if (key.equals("soapOpera")) {
                    movie = MovieFactory.getMovie(key);
                    System.out.println(movie.getClass().getSimpleName());
                }

            } else  {
                movie = MovieFactory.getMovie(key);
                break; }




        }




        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;


            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            if("cartoon".equals(key)){
                movie = new Cartoon();
            }

            if("thriller".equals(key)){
                movie = new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    public static class Cartoon extends Movie{}
    public static class Thriller extends Movie{}
}
