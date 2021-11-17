package TopKElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {
    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k){
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((n1, n2) -> n1.getValue() - n2.getValue());

        // Populate hash map
        for(int i = 0; i < nums.length; i++){
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        };

        // Populate min heap
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            };
        };

        // Populate result
        while(!minHeap.isEmpty()){
            result.add(minHeap.poll().getKey());
        };

        return result;
    };
};

// List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
//     System.out.println("Here are the K frequent numbers: " + result);

//     result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
//     System.out.println("Here are the K frequent numbers: " + result);