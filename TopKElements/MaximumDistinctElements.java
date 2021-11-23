package TopKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumDistinctElements {
    public static int findMaximumDistinctElements(int[] nums, int k){
        HashMap<Integer, Integer> numberFrequencies = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((n1, n2) -> n1.getValue() - n2.getValue());
        int result = 0;

        for(int i = 0; i < nums.length; i++){
            numberFrequencies.put(nums[i], numberFrequencies.getOrDefault(nums[i], 0) + 1);
        };

        // Add all current distinct elements
        for(Map.Entry<Integer, Integer> entry : numberFrequencies.entrySet()){
            if(entry.getValue() > 1){
                minHeap.offer(entry);
            } else if(entry.getValue() == 1){
                result++;
            };
        };

        while(!minHeap.isEmpty() && k > 0){
            Map.Entry<Integer, Integer> entry = minHeap.poll();

            // Subtract all but 1 instance of that number
            k = k - (entry.getValue() - 1); 

            // All duplicates of that number were removed, but k elements still need to go
            // We can count this number as a new distinct element
            if(k >= 0){
                result++;
            };
        };

        // All duplicates were removed, but k elements still need to go
        // Decrement the total count of distinct elements so far
        if(k > 0){
            result = result - k;
        };

        return result;
    };
};

// int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
//     System.out.println("Maximum distinct numbers after removing K numbers: " + result);

//     result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
//     System.out.println("Maximum distinct numbers after removing K numbers: " + result);

//     result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
//     System.out.println("Maximum distinct numbers after removing K numbers: " + result);