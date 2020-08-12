package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class InsertInterval {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || intervals.isEmpty()){
            return Arrays.asList(newInterval);
        };

        List<Interval> mergedIntervals = new ArrayList<>();

        int i = 0;
        int start, end;

        while(i < intervals.size() && intervals.get(i).end <= newInterval.start){ // Filter out intervals which end before newInterval start
            mergedIntervals.add(intervals.get(i++));
        };

        while(i < intervals.size() && newInterval.start <= intervals.get(i).end){
            start = Integer.min(newInterval.start, intervals.get(i).start);
            end = Integer.max(newInterval.end, intervals.get(i).end);

            i++;
        };

        return mergedIntervals; 
    };
};