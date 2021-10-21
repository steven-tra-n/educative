package TwoHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NextInterval {
    public static int[] findNextInterval(Interval[] intervals){
        int n = intervals.length;
        int[] result = new int[n];

        if(intervals.length <= 0){
            return result;
        };

        PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < n; i++){
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        };

        // Go through all the intervals to find each intervals' next interval
        for(int i = 0; i < n; i++){
            // Find the next interval of the interval which has the highest end
            int topEnd = maxEndHeap.poll();
            // Defaults to -1
            result[topEnd] = -1;

            if(intervals[maxStartHeap.peek()].start >= intervals[topEnd].end){
                int topStart = maxStartHeap.poll();

                // Find the interval that has the closest start
                while(!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end){
                    topStart = maxStartHeap.poll();
                };

                result[topEnd] = topStart;
                // Put the interval back as it could be the next for others
                maxStartHeap.offer(topStart);
            };
        };

        return result;
    };
}

// Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
//     int[] result = NextInterval.findNextInterval(intervals);
//     System.out.print("Next interval indices are: ");
//     for (int index : result)
//       System.out.print(index + " ");
//     System.out.println();

//     intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
//     result = NextInterval.findNextInterval(intervals);
//     System.out.print("Next interval indices are: ");
//     for (int index : result)
//       System.out.print(index + " ");