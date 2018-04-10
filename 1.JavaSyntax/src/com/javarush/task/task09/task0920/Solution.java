package com.javarush.task.task09.task0920;

/* 
Обратный отсчёт
*/

public class Solution {
    public static void main(String[] args) {
      try {  for (int i = 10; i >= 0; i--) {
            Thread.sleep(100);
            System.out.println(i);

            //напишите тут ваш код
        } } catch (InterruptedException e) {
          e.printStackTrace();
      }
    }
}
