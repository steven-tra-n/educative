package TopKElements;

import java.util.PriorityQueue;

public class SumOfElements {
      public static int findSumOfElements(int[] nums, int k1, int k2){
          // Add all numbers to a min heap
          // Iterate through and poll the min heap k1 times
          // Start to add each element to a running sum
          // Poll from k1 to k2
          PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
          int sum = 0;

          for(int i = 0; i < nums.length; i++){
              minHeap.offer(nums[i]);
          };

          while(k1 > 0){
              minHeap.poll();
              k1--;
              k2--;
          };

          // Don't count the last element
          while(k2 > 1){
              sum += minHeap.poll();
              k2--;
          };

          return sum;
      };
};

// int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
//     System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

//     result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
//     System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);