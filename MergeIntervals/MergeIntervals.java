package MergeIntervals;

import java.util.Collections;
import java.util.Iterator;
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
        
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next(); // Fetch first interval
        int start = interval.start; // Initial start and end
        int end = interval.end;

        while(intervalItr.hasNext()){
            interval = intervalItr.next();

            if(interval.start <= end){ // Overlap found
                end = Integer.max(interval.end, end); // We know start is already <= interval.start, since list is sorted on start. Find new end
            } else{
                mergedIntervals.add(new Interval(start, end)); // No overlap, add previous interval

                start = interval.start; // Reset placeholders
                end = interval.end;
            };
        };

        mergedIntervals.add(new Interval(start, end)); // Add last interval

        return mergedIntervals;
    };
};