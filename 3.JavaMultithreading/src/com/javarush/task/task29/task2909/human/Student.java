package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson{
    private int course;
    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;

    public Student(String name, int age, double averageGrade) {
        super(name,age);
              this.averageGrade = averageGrade;
    }
    public void setAverageGrade(double averageGrade){
        this.averageGrade = averageGrade;

    }
    public void setCourse(int course) {
        this.course = course;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    @Override
    public String getPosition(){
        return "Студент";
    }

   public void incAverageGrade(double delta) {
       setAverageGrade(getAverageGrade() + delta);
   }

    public void setCourse(String name){

    }



    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}