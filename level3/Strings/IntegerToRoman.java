package com.dr.level3.Strings;
import java.util.HashMap;
/*
Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version

Input is guaranteed to be within the range from 1 to 3999.

Example :

Input : 5
Return : "V"

Input : 14
Return : "XIV"

https://projecteuler.net/about=roman_numerals*/
public class IntegerToRoman {

    private static int[] bases = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9,
            5, 4, 1 };
    private static HashMap<Integer, String> map = new HashMap<Integer, String>();

    private static void setup() {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }
    public String intToRoman(int A) {

        setup();
        String result = new String();
        for (int i : bases) {
            while (A >= i) {
                result += map.get(i);
                A -= i;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new IntegerToRoman().intToRoman(3));
    }

}
