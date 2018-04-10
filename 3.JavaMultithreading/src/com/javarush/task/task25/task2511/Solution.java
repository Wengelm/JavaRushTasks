package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {

            /**
             * Method invoked when the given thread terminates due to the
             * given uncaught exception.
             * <p>Any exception thrown by this method will be ignored by the
             * Java Virtual Machine.
             *
             * @param t the thread
             * @param e the exception
             */
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                e = new Exception(e.getMessage().replace(t.getName(),starmask(t.getName())),e);
                System.out.println(e.getMessage());
            }
        };    //init handler here
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + starmask(currentThread.getName()) + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
    }

    private String starmask(String s) {

        return s.replaceAll(".","*");
    }
}