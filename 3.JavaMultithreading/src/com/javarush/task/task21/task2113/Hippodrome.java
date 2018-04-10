package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    private static List<Horse> horses;
    static Hippodrome game;

    public Hippodrome() {

    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }



    public void run() throws InterruptedException {

        for (int i =0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){

        for (int i =0; i < horses.size(); i++) {
            horses.get(i).move();
        }

    }
    public void print(){

        for (int i =0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public Horse getWinner(){
        return horses.stream()
                .max((h1, h2) -> Double.compare(h1.getDistance(), h2.getDistance()))
                .get();
    }
    public void printWinner(){
        System.out.printf("Winner is %s!%n",getWinner().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        horses = new ArrayList<>();
        game = new Hippodrome(horses);
        Horse one = new Horse("Plotva", 3,0);
        Horse two = new Horse("Plotva1", 3,0);
        Horse three = new Horse("Plotva2",3,0);
        horses.add(one);
        horses.add(two);
        horses.add(three);
        game.run();
        game.printWinner();
        
    }
}
