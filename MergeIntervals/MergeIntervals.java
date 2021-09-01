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

        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next(); // Fetch first interval
        int start = interval.start; // Initial start and end
        int end = interval.end;

        while(intervalItr.hasNext()){ // Loop through and find the lowest value when comparing two intervals
            interval = intervalItr.next();

            if(interval.start <= end){ // Overlap found
                end = Integer.max(interval.end, end); // We know start is already <= interval.start, since list is sorted on start. Find new end
            } else{
                mergedIntervals.add(new Interval(start, end)); // No overlap, add previous interval

                start = interval.start; // Reset placeholders to previous interval
                end = interval.end;
            };
        };

        mergedIntervals.add(new Interval(start, end)); // Add last interval, since while loop does not account for last interval

        return mergedIntervals;
    };

    public static List<Interval> merge2(List<Interval> intervals) {
        List<Interval> mergedInterval = new LinkedList<Interval>();

        if(intervals.size() == 1){
            return intervals;
        };

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        Iterator<Interval> intervalIterator = intervals.iterator();     
        Interval interval = intervalIterator.next();

        int start = interval.start;
        int end = interval.end;

        while(intervalIterator.hasNext()){
            interval = intervalIterator.next();

            if(interval.start <= end){
                end = Integer.max(end, interval.end);
            } else{
                mergedInterval.add(new Interval(start, end));

                start = interval.start;
                end = interval.end;
            };
        };

        mergedInterval.add(new Interval(start, end));

        return mergedInterval;
    };
};

// List<Interval> input = new ArrayList<Interval>();
//     input.add(new Interval(1, 4));
//     input.add(new Interval(2, 5));
//     input.add(new Interval(7, 9));
//     System.out.print("Merged intervals: ");
//     for (Interval interval : MergeIntervals.merge(input))
//       System.out.print("[" + interval.start + "," + interval.end + "] ");
//     System.out.println();

//     input = new ArrayList<Interval>();
//     input.add(new Interval(6, 7));
//     input.add(new Interval(2, 4));
//     input.add(new Interval(5, 9));
//     System.out.print("Merged intervals: ");
//     for (Interval interval : MergeIntervals.merge(input))
//       System.out.print("[" + interval.start + "," + interval.end + "] ");
//     System.out.println();

//     input = new ArrayList<Interval>();
//     input.add(new Interval(1, 4));
//     input.add(new Interval(2, 6));
//     input.add(new Interval(3, 5));
//     System.out.print("Merged intervals: ");
//     for (Interval interval : MergeIntervals.merge(input))
//       System.out.print("[" + interval.start + "," + interval.end + "] ");
//     System.out.println();
//     };