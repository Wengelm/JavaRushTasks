package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new OneThread());
        threads.add(new TwoThread());
        threads.add(new ThreeThread());
        threads.add(new FourThread());
        threads.add(new FiveThread());

    }

    public static void main(String[] args) {
    }

    public static class OneThread extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {

            }
        }
    }

    public static class TwoThread extends Thread {
        @Override
        public void run() {
            while (true) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                    break;
                }

            }
        }
    }

    public static class ThreeThread extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class FourThread extends Thread implements Message {

        private boolean isCancel = true;

        @Override
        public void run() {
            while (isCancel) {

            }
        }

        @Override
        public void showWarning() {
            isCancel = false;
        }
    }

    public static class FiveThread extends Thread {


        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {

                int sum = 0;



                while (!isInterrupted()) { // throws IOException

                    String line = reader.readLine();

                    if (line.equals("N")) {

                        break;

                    }

                    try {

                        Integer n = Integer.parseInt(line);

                        sum += n;

                    } catch (NumberFormatException e) {


                    }

                }

                System.out.println(sum);


            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }
}
