package com.dr.level2.Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*Given an array of integers, sort the array into a wave like array and return it,
        In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

        Example
        Given [1, 2, 3, 4]

        One possible answer : [2, 1, 4, 3]
        Another possible answer : [4, 1, 3, 2]
        NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
        So, in example case, you will return [2, 1, 4, 3]*/
public class WaveArray {

    public static int[] wave(int[] A){
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
        System.out.println();

        for(int i = 0; i < A.length; i = i+2){
            int temp = A[i];
            A[i] = A[i+1];
            A[i+1] = temp;
        }
        for(int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
        return A;
    }

    public static int[] sortWave(int[] A){
        for(int i = 0; i < A.length; i = i + 2){
            if(i > 0 && A[i] < A[i-1]){
                int temp = A[i];
                A[i] = A[i-1];
                A[i-1] = temp;
            }
            if(i < A.length - 1 && A[i] < A[i+1]){
                int temp = A[i];
                A[i] = A[i+1];
                A[i+1] = temp;
            }

        }
        return A;
    }

    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        for(int i = 0; i < a.size(); i = i + 2){
            if(i > 0 && a.get(i) < a.get(i-1)){
                swap(a,i, i-1);
            }
            if(i < a.size()-1 && a.get(i) < a.get(i+1)){
                swap(a, i, i+1);
            }
        }
        return a;
    }

    void swap(ArrayList<Integer> A, int a,int b){
        int temp = A.get(a);
        A.set(a,A.get(b));
        A.set(b, temp);
    }

    public static void main(String[] args){
        //int[] A =  {1, 2, 3, 4};//{3, 6, 5, 10, 7, 20};
        //A = sortWave(A);
        //for(int i = 0; i < A.length; i++)
        //    System.out.print(A[i] + " ");

        ArrayList<Integer> B = new ArrayList<Integer>();
        //B.add(3);B.add(6);B.add(5);B.add(10);B.add(7);B.add(20);
        B.add(1);B.add(2);B.add(3);B.add(4);
        ArrayList<Integer> result = new WaveArray().wave(B);

        for(int i = 0; i < result.size(); i++)
            System.out.print(result.get(i) + " ");
    }
}
