package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recursion(int n) {
        // базовый случай
        int a = 2;
        while (a<=n){
            if (n%a==0){
                if (a!=n){
                    System.out.print(a+" ");
                    recursion(n/a);
                }else System.out.print(a);
                return; }
            a++;
        }

    }
    public static void main(String[] args){

        Solution solution = new Solution();
        solution.recursion(50);



    }
}
