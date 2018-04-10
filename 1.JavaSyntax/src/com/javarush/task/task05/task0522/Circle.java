package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    public Circle() {

    }


    public Circle(double x, double y, double radius){
        this.radius = radius;
        this.x = x;
        this.y = y;
    }


    public Circle(double x, double radius){
        this.radius = radius;
        this.x = x;

    }

    public Circle( double radius){
        this.radius = radius;

    }

    //напишите тут ваш код

    public static void main(String[] args) {

    }
}