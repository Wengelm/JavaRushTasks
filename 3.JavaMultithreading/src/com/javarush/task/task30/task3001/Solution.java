package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args)
    {
        Number number = new Number (NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem (number, NumerationSystemType._2);
        System.out.println (result);    //expected 110

        number = new Number (NumerationSystemType._2, "1111");
        result = convertNumberToOtherNumerationSystem (number, NumerationSystemType._10);
        System.out.println (result);    //expected 110

        number = new Number (NumerationSystemType._16, "6df");
        result = convertNumberToOtherNumerationSystem (number, NumerationSystemType._8);
        System.out.println (result);    //expected 3337
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem)
    {
        //напишите тут ваш код
     /*   Number numberN;
        BigInteger bi;
        int        currentRadix = Integer.valueOf (number.getNumerationSystem ( ).toString ( ).substring (1));
        int        expectedRadix =expectedNumerationSystem.getNumerationSystemIntValue ();


        try
            {
                bi = new BigInteger (number.getDigit ( ), currentRadix);
                if (bi.intValue() < 0) throw new NumberFormatException();
                String       newValue  = Integer.toString (Integer.parseInt (String.valueOf (bi.intValue ())), expectedRadix);
                numberN=new Number (expectedNumerationSystem,newValue);
            }
        catch (NumberFormatException e)
            {   throw new NumberFormatException ( );
            }
          return numberN;

        */

        BigInteger bigInteger = new BigInteger(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
        String str = bigInteger.toString(expectedNumerationSystem.getNumerationSystemIntValue());
        return new Number(expectedNumerationSystem, str);
    }
}
