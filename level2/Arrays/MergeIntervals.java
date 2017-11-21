package com.dr.level2.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
Make sure the returned intervals are also sorted.*/
public class MergeIntervals {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval.start > newInterval.end){
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }
        int n = intervals.size();
        if(intervals == null || intervals.size() < 1)
            intervals.add(newInterval);
        else if(newInterval.start <= intervals.get(0).start)
            intervals.add(0, newInterval);
        else if(newInterval.start >= intervals.get(n-1).start)
            intervals.add(n, newInterval);
        else{
            for(int i = 0; i < intervals.size()-1; i++){
                if(intervals.get(i).start < newInterval.start && newInterval.start < intervals.get(i+1).start){
                    intervals.add(i+1, newInterval);
                    break;
                }

            }
        }
        return merge(intervals);
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals.size() == 0)
            return intervals;
        if(intervals.size() == 1)
            return intervals;

        Collections.sort(intervals, new IntervalComparator());

        Interval first = intervals.get(0);
        int start = first.start;
        int end = first.end;

        ArrayList<Interval> result = new ArrayList<Interval>();

        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            if(current.start <= end)
                end = Math.max(current.end, end);
            else {
                result.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
        }
        result.add(new Interval(start, end));

        return result;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(6,9));
        //intervals.add(new Interval(6,7));
        //intervals.add(new Interval(8,10));
        //intervals.add(new Interval(12,16));
        Interval newInterval = new Interval(2, 5);

        ArrayList<Interval> result = new MergeIntervals().insert(intervals, newInterval);

        for(int i =0; i < result.size(); i++)
            System.out.printf("[%d, %d] ", result.get(i).start, result.get(i).end);

        /*Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(2,6);
        Interval i3 = new Interval(8,10);
        Interval i4 = new Interval(15,18);

        ArrayList<Interval> x = new ArrayList<Interval>();
        x.add(i1);x.add(i2);x.add(i3);x.add(i4);
        ArrayList<Interval> r = new MergeIntervals().merge(x);

        for(Interval i : r)
            System.out.println(i.start+" "+i.end);
        */

    }
}


class IntervalComparator implements Comparator{
    public int compare(Object o1, Object o2){
        Interval i1 = (Interval)o1;
        Interval i2 = (Interval)o2;
        return i1.start - i2.start;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

