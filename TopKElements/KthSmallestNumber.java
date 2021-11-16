package TopKElements;

import java.util.PriorityQueue;

public class KthSmallestNumber {
    public static int findKthSmallestNumber(int[] nums, int k){
        // Using minHeap
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        // for(int i = 0; i < nums.length; i++){
        //     minHeap.offer(nums[i]);
        // };

        // int counter = 0;

        // while(counter < k - 1){
        //     minHeap.poll();
        //     counter++;
        // };

        // return minHeap.peek();

        // Using maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);

        for(int i = 0; i < k; i++){
            maxHeap.offer(nums[i]);
        };

        for(int i = k; i < nums.length; i++){
            if(nums[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            };
        };

        return maxHeap.peek();
    };
};

//     int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
//     System.out.println("Kth smallest number is: " + result);

//     // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
//     result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
//     System.out.println("Kth smallest number is: " + result);

//     result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
//     System.out.println("Kth smallest number is: " + result);