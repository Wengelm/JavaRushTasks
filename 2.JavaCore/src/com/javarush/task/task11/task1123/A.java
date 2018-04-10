package com.javarush.task.task11.task1123;

public class A {
    static {
        System.out.println("Static A");
    }

    {
        System.out.println("nestatic a");
    }
    A() {
        System.out.println("A const");
    }

    public static class B extends A {
        static {
            System.out.println("Static b");
        }

        {
            System.out.println("nestatic b");
        }
        B() {
            System.out.println("b const");
        }
    }
 public static void main(String[] args) {
        B b = new B();
 }

}
