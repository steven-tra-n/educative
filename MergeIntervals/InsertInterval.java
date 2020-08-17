package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || intervals.isEmpty()){
            return Arrays.asList(newInterval);
        };

        List<Interval> mergedIntervals = new ArrayList<>();

        int i = 0;

        while(i < intervals.size() && intervals.get(i).end < newInterval.start){ // Filter out intervals which end before newInterval start
            mergedIntervals.add(intervals.get(i++));
        };

        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){ // Intervals overlap at at least one point
            newInterval.start = Integer.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Integer.max(newInterval.end, intervals.get(i).end);

            i++;
        };

        mergedIntervals.add(newInterval);

        while(i < intervals.size()){
            mergedIntervals.add(intervals.get(i++));
        };

        return mergedIntervals; 
    };
};

// List<Interval> input = new ArrayList<Interval>();
// input.add(new Interval(1, 3));
// input.add(new Interval(5, 7));
// input.add(new Interval(8, 12));
// System.out.print("Intervals after inserting the new interval: ");
// for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
//   System.out.print("[" + interval.start + "," + interval.end + "] ");
// System.out.println();

// input = new ArrayList<Interval>();
// input.add(new Interval(1, 3));
// input.add(new Interval(5, 7));
// input.add(new Interval(8, 12));
// System.out.print("Intervals after inserting the new interval: ");
// for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
//   System.out.print("[" + interval.start + "," + interval.end + "] ");
// System.out.println();

// input = new ArrayList<Interval>();
// input.add(new Interval(2, 3));
// input.add(new Interval(5, 7));
// System.out.print("Intervals after inserting the new interval: ");
// for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
//   System.out.print("[" + interval.start + "," + interval.end + "] ");
// System.out.println();