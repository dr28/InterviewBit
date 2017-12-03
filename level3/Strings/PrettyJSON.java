package com.dr.level3.Strings;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/*Pretty print a json object using proper indentation.

Every inner brace should increase one indentation to the following lines.
Every close brace should decrease one indentation to the same line and the following lines.
The indents can be increased with an additional ‘\t’
Example 1:

Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
Output :
{
    A:"B",
    C:
    {
        D:"E",
        F:
        {
            G:"H",
            I:"J"
        }
    }
}
Example 2:

Input : ["foo", {"bar":["baz",null,1.0,2]}]
Output :
[
    "foo",
    {
        "bar":
        [
            "baz",
            null,
            1.0,
            2
        ]
    }
]
[] and {} are only acceptable braces in this case.

Assume for this problem that space characters can be done away with.

Your solution should return a list of strings, where each entry corresponds to a single line. The strings should not have “\n” character in them.*/
public class PrettyJSON {

    public static ArrayList<String> prettyJSON(String a) {
        //System.out.println("Entering function");
        ArrayList<String> result = new ArrayList<String>();
        int indentation = 0;
        String temp = "";
        for(int i = 0; i < a.length(); i++){
            char c = a.charAt(i);
            //System.out.println("c : " + c);
            if(c == ' ')
                continue;
            else if(c == '[' || c == '{'){
                temp += c;
                for(int j = indentation; j > 0; j--)
                    temp = "\t" + temp;
                //System.out.println("temp : " + temp);
                result.add(temp);
                temp = "";
                indentation++;
                //System.out.println("indentation : " + indentation);
            }

            else if(c == ']' || c == '}'){
                if(i < a.length()-1 && a.charAt(i+1) == ','){
                    temp += c;
                    temp += a.charAt(++i);
                    indentation--;
                    //System.out.println("indentation : " + indentation);
                    for(int j = indentation; j > 0; j--)
                        temp = "\t" + temp;
                    //System.out.println("temp : " + temp);
                    result.add(temp);
                    temp = "";
                }
                else{
                    temp += c;
                    indentation--;
                    //System.out.println("indentation : " + indentation);
                    for(int j = indentation; j > 0; j--)
                        temp = "\t" + temp;
                    //System.out.println("temp : " + temp);
                    result.add(temp);
                    temp = "";
                }
            }
            else if(c == ':' && (a.charAt(i+1) == '{' || a.charAt(i+1) == '[')){
                temp = temp + c;
                for(int j = indentation; j > 0; j--)
                    temp = "\t" + temp;
                //System.out.println("temp : " + temp);
                result.add(temp);
                temp = "";
            }
            else if(c == ':' && (a.charAt(i+1) != '{' || a.charAt(i+1) != '['))
                temp = temp + c;

            else if(c == ',' || c == ':' || a.charAt(i+1) == '}' || a.charAt(i+1) == ']'|| a.charAt(i+1) == '{' || a.charAt(i+1) == '['){
                temp = temp + c;
                //System.out.println("indentation : " + indentation);
                for(int j = indentation; j > 0; j--)
                    temp = "\t" + temp;
                //System.out.println("temp : " + temp);
                result.add(temp);
                temp = "";
            }

            else{
                temp = temp + c;
            }
        }

        for(int i = 0; i < result.size(); i++)
            System.out.println("-----"+result.get(i));

        return result;
    }

    public static void main(String[] args){
        String s = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
        new PrettyJSON().prettyJSON(s);

    }
}
