package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type=type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }
    public boolean isSummer(Date date , Date summerStart, Date summerEnd) {
        return (date.after(summerStart)&&date.before(summerEnd));

    }

    public double  getWinterConsumption(int length)
    {
        return (winterFuelConsumption * length) + winterWarmingUp;
    }

    public double  getSummerConsumption(int length)
    {
        return summerFuelConsumption * length;
    }


    public static Car create(int type, int numberOfPassengers) {
        if (type==TRUCK)
            return new Truck(numberOfPassengers);
        else if (type==SEDAN)
            return new Sedan(numberOfPassengers);
        else if (type==CABRIOLET)
            return new Cabriolet(numberOfPassengers);
        else return null;

    }


    public double getTripConsumption(Date date, int length, Date summerStart, Date summerEnd) {
        if (isSummer(date, summerStart, summerEnd))
        {
            return getSummerConsumption(length);
        } else
            return getWinterConsumption(length);
    }


    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;


        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();

        }
        fastenDriverBelt();
    }
    private boolean canPassengersBeTransferred() {
        if( isDriverAvailable() &&  fuel != 0) {
            return true;
        }
        else return false;


    }
    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();





}