package com.javarush.task.task32.task3204;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        StringBuilder passwordBuilder = new StringBuilder();
        int flagNumbers = 0;//флаг на числа
        int flagUpperCase = 0;// флаг на буквы в UpperCase
        int flagLowerCase = 0;// флаг на буквы в LowerCase
        int passwordLength = 8;//длина пароля из условия
        int azLength = 26; // ддлина алфавита по ASCII
        int startAzUp = 97;// начало алфавита по ASCII в UpperCase
        int startAzLo = 65;//начало алфавита по ASCII в в LowerCase
        int count = 0;
        while (true) {//начало цикла генерации пароля
            double randomNumbers = Math.random() * passwordLength;// случайное число в диапазоне цифр 0-9
            double randomASCII = Math.random() * azLength;//случайный указатель на букву в диапазоне a-z || A-Z
            int k = (int) randomASCII;
            char c;
            if (count % 2 == 0) {// если счетчик четный
                if (count > randomNumbers) {// и если счетчик больше случайного числа в диапазоне цифр 0-9
                    c = (char) (int) (startAzUp + k);// присвоение чару случайного значения из UpperCase
                    flagUpperCase++;// отметка об использовании диапазона UpperCase
                } else {
                    c = (char) (int) (startAzLo + k);// иначе  чару присваивается случайное значения из LowerCase
                    flagLowerCase++;// отметка об использовании диапазона LowerCase
                }
                passwordBuilder.append(c);// добавляется чар
            } else {// иначе если счетчик нечетный
                passwordBuilder.append(passwordLength - (int) randomNumbers);// добавляется разница между длиной пароля и случайным числом из диапазона 0 - длина пароля
                flagNumbers++;// отметка об использовании диапазона цифр
            }
            count++;// плюсуем счетчик
            if (flagLowerCase > 0 && flagUpperCase > 0 && flagNumbers > 0 && passwordBuilder.toString().length() == passwordLength) {// если все три диапазона в наличии и длина соответствует условию
                break;// выход из цикла
            }
            if (passwordBuilder.toString().length() > passwordLength) {// если длина больше условия, обнуляются флаги, счетчик, passwordBuilder и все начинается заново
                flagLowerCase = 0;
                flagUpperCase = 0;
                flagNumbers = 0;
                count = 0;
                passwordBuilder.delete(0, passwordBuilder.length());
            }
        }
        if (Math.random() * 10 > 5) {// случайное условие с вероятностью около 50%
            passwordBuilder.reverse();// реверсим получившийся пароль
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(passwordBuilder.toString().getBytes());// загоняем итог в ByteArrayInputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int data;
        while ((data = byteArrayInputStream.read()) != -1) {//считываем побайтно в ByteArrayOutputStream
            byteArrayOutputStream.write(data);
        }
        return byteArrayOutputStream;// возвращаем итог
    }
}