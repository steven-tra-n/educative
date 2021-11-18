package TopKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestNumberInStream {
    public List<Integer> num = new ArrayList<>();
    public int k;

    PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

    public KthLargestNumberInStream(int[] num, int k){
        this.k = k;

        for(int i = 0; i < num.length; i++){
            // Add to main list
            this.num.add(num[i]);
            minHeap.offer(num[i]);

            // Keep heap at size k
            if(minHeap.size() > k){
                minHeap.poll();
            };
        };
    };

    public int add(int newNum){
        // Add to main list
        this.num.add(newNum);

        // Heap is kept at size k in constructor
        // Only replace the heap peek if newNum is greater
        if(newNum > minHeap.peek()){
            minHeap.poll();
            minHeap.offer(newNum);
        };

        return minHeap.peek();
    };
};

// int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
//     KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
//     System.out.println("4th largest number is: " + kthLargestNumber.add(6));
//     System.out.println("4th largest number is: " + kthLargestNumber.add(13));
//     System.out.println("4th largest number is: " + kthLargestNumber.add(4));