package com.dr.level3.Strings;

/*Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:
0.1 < 1.1 < 1.2 < 1.13 < 1.13.4*/
public class CompareVersionNumbers {

    public int compareVersion(String a, String b) {

        String[] arr1 = a.split("\\.");
        String[] arr2 = b.split("\\.");

        int i=0;
        while(i<arr1.length || i<arr2.length){
            if(i<arr1.length && i<arr2.length){
                if(Double.parseDouble(arr1[i]) < Double.parseDouble(arr2[i])){
                    return -1;
                }else if(Double.parseDouble(arr1[i]) > Double.parseDouble(arr2[i])){
                    return 1;
                }
            } else if(i<arr1.length){
                if(Double.parseDouble(arr1[i]) != 0){
                    return 1;
                }
            } else if(i<arr2.length){
                if(Double.parseDouble(arr2[i]) != 0){
                    return -1;
                }
            }

            i++;
        }

        return 0;
    }

    public static void main(String[] args){
        String a = "4444371174137455";
        String b = "5.168";
        System.out.println(new CompareVersionNumbers().compareVersion(a, b));
    }

}

