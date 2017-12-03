package com.dr.level3.Strings;
/*Given two binary strings, return their sum (also a binary string).

Example:

a = "100"

b = "11"
Return a + b = “111”.*/
public class AddBinaryString {

    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            // adding number from back
            //System.out.println("(a.charAt(i) - '0') "+(a.charAt(i) - '0'));

            int n1 = i >= 0 ? (a.charAt(i) - '0') : 0;
            int n2 = j >= 0 ? (b.charAt(j) - '0') : 0;
            int num = n1 + n2 + carry;
            str.insert(0, num % 2);
            carry = num / 2;
            i--;
            j--;
        }
        return str.toString();
    }

    public static void main(String[] args){
        String a = "1110000000010110111010100100111";
        String b = "101001";

        a="100";
        b="11";
        System.out.println(new AddBinaryString().addBinary(a,  b));
    }

}
