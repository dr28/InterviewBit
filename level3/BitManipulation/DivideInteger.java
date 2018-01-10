package com.dr.level3.BitManipulation;
/*Divide two integers without using multiplication, division and mod operator.

Return the floor of the result of the division.

Example:

5 / 2 = 2
Also, consider if there can be overflow cases. For overflow case, return INT_MAX.*/
public class DivideInteger {
    /* Shift the divisor left until it is smaller than dividend, further shifting makes it larger than dividend.
     * Than add the shifted value to the result and subtract the shifted value from dividend.
     * Keep doing this until dividend is smaller than divisor.
     * In fact, every integer can be represented by a set of base 2 so that shifting can be used.
     *
     * Convert integer to long type, otherwise the Math.abs() value of Integer.MIN_VALUE will be quite strange.
     * This problem can be solved based on the fact that any number can be converted to the format of the following:

     *   num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n
     *   The time complexity is O(logn).
     */
    public int divide(int A, int B) {


        if(B==0) return Integer.MAX_VALUE;
        if(B==-1 && A == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        //get positive values
        long dividend = Math.abs((long)A);
        long divisor = Math.abs((long)B);

        int result = 0;
        while(dividend>=divisor){
            //calculate number of left shifts
            int numShift = 0;
            while(dividend>=(divisor<<numShift)){
                numShift++;
            }

            //dividend minus the largest shifted divisor
            result += 1<<(numShift-1);
            dividend -= (divisor<<(numShift-1));
        }

        if((A>0 && B>0) || (A<0 && B<0)){
            return result;
        }else{
            return -result;
        }
    }
    public static void main(String[] args){
        int dividend = 2147483647;
        int divisor = 1;
        System.out.println(new DivideInteger().divide(dividend,divisor));
    }
}

