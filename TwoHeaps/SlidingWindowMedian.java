package TwoHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public double[] findSlidingWindowMedian(int[] nums, int k){
        double[] result = new double[nums.length - k + 1];

        if(k == 0){
            return result;
        };

        int windowStart = 0;
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++){
            addTosHeap(nums[windowEnd]);
            checkLengths();

            // Window is reached, start adding medians and increasing windowStart
            if(windowEnd - windowStart >= k - 1){
                result[windowStart] = findMedian();
                removeFromHeap(nums[windowStart]);

                windowStart++;
            };
        };

        return result;
    };

    public void addTosHeap(int num){
        if(maxHeap.size() == 0 || num <= maxHeap.peek()){
            maxHeap.offer(num);
        } else{
            minHeap.offer(num);
        };
    };

    public void checkLengths(){
        // Either both heaps will have equal number of elements or maxHeap will have
        // one more element
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        } else if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        };
    };

    public double findMedian(){
        // 
        if(minHeap.size() == maxHeap.size()){
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else{
            return maxHeap.peek();
        }
    };

    public void removeFromHeap(int num){
        if(num <= maxHeap.peek()){
            maxHeap.remove(num);
        } else{
            minHeap.remove(num);
        }
    };
};

// SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
//     double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
//     System.out.print("Sliding window medians are: ");
//     for (double num : result)
//       System.out.print(num + " ");
//     System.out.println();

//     slidingWindowMedian = new SlidingWindowMedian();
//     result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
//     System.out.print("Sliding window medians are: ");
//     for (double num : result)
//       System.out.print(num + " ");