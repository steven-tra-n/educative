package MergeIntervals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();

        if(intervals.size() == 1){
            return intervals;
        };

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // Loop through and find the lowest value when comparing two intervals

        for(int i = 0; i < intervals.size(); i++){
            System.out.println(intervals.get(i).start);
        };

        return mergedIntervals;
    };
};