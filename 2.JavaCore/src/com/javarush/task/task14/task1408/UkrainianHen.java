package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    private String country = Country.UKRAINE;

    public int getCountOfEggsPerMonth() {
        return 30;
    }

    public String getDescription() {
        return super.getDescription() +
                " Моя страна - " +
                this.country +
                ". Я несу " +
                getCountOfEggsPerMonth() +
                " яиц в месяц.";
    }
}