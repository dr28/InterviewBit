package com.dr.level3.Strings;
/*Please Note:

Note: It is intended for some problems to be ambiguous. You should gather all requirements up front before implementing one.

Please think of all the corner cases and clarifications yourself.

Validate if a given string is numeric.

Examples:

"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Clarify the question using “See Expected Output”

Is 1u ( which may be a representation for unsigned integers valid?
For this problem, no.
Is 0.1e10 valid?
Yes
-01.1e-10?
Yes
Hexadecimal numbers like 0xFF?
Not for the purpose of this problem
3. (. not followed by a digit)?
No
Can exponent have decimal numbers? 3e0.1?
Not for this problem.
Is 1f ( floating point number with f as prefix ) valid?
Not for this problem.
How about 1000LL or 1000L ( C++ representation for long and long long numbers )?
Not for this problem.
How about integers preceded by 00 or 0? like 008?
Yes for this problem*/
public class ValidNumber {

    public int isNumber(final String a) {

        if(a == null || a.length() == 0 || a.charAt(a.length()-1) == '.' )
            return 0;
        int i = 0;
        int dot = 0;
        int e = 0;
        int num = 0;
        char temp = a.charAt(i);
        //System.out.println(a.length());
        if(temp == '+' || temp == '-' || temp == ' ')
            i++;
        while(i < a.length()){
            temp = a.charAt(i);
            //System.out.print(temp + " ");
            if((temp >= '0' && temp <= '9') ){
                num++;
            }
            else if(temp == '+' || temp == '-'|| temp == ' '){

            }
            else if(temp == '.' && i < a.length()-1 && (a.charAt(i+1) >= '0' && a.charAt(i+1) <= '9')){
                if(e > 0)
                    return 0;
                else
                    dot++;
            }
            else if(temp == 'e'){
                e++;
            }
            else
                return 0;
            i++;
        }

        if(num < 1) return 0;
        if(dot > 1 || e > 1) return 0;

        return 1;
    }


    public static void main(String[] args) {
        String input = " 0.1";
        System.out.println(new ValidNumber().isNumber(input));
    }
}
