package com.javarush.task.task25.task2506;


public class LoggingStateThread extends Thread{

    private Thread targetThread;

    public LoggingStateThread(Thread thread) {
        this.targetThread = thread;
    }

    @Override
    public void run() {
        State oldState = targetThread.getState();
        System.out.println(oldState);
        super.run();
        while (targetThread.getState() != State.TERMINATED) {
            State newState = targetThread.getState();
            if (newState != oldState) {
                System.out.println(newState);
                oldState = newState;
            }
        }
        System.out.println(targetThread.getState());
    }
}