package com.javarush.task.task35.task3501;

public class GenericStatic {
    public static <T> Object someStaticMethod(Object genericObject) {
        System.out.println(genericObject);
        return genericObject;
    }
}
