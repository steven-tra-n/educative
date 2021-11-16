package TopKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestNumbers {
    public static List<Integer> findKLargestNumbers(int[] nums, int k){
        // Brute force
        // List<Integer> result = new ArrayList<>();

        // Arrays.sort(nums);

        // for(int i = nums.length - 1; i > nums.length - 1 - k; i--){
        //     result.add(nums[i]);
        // };

        // return result;

        PriorityQueue<Integer> minHeap;
        minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        // Add k nums to the heap
        for(int i = 0; i < k; i++){
            minHeap.offer(nums[i]);
        };
        
        for(int i = k; i < nums.length; i++){
            if(nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(nums[i]);
            };
        };

        return new ArrayList<>(minHeap);
    };
};

// List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
//     System.out.println("Here are the top K numbers: " + result);

//     result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
//     System.out.println("Here are the top K numbers: " + result);