package TwoHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfAStream {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianOfAStream(){
        minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap = new PriorityQueue<>();
    };

    public void insertNum(int num){
        // Add by default to minHeap
        minHeap.add(num);
        
        checkSizing();
        checkLengths();
    };

    public void checkSizing(){
        // minHeap has an element that isn't less than or equal to maxHeap
        if(maxHeap.size() > 0 && minHeap.peek() > maxHeap.peek()){
            maxHeap.add(minHeap.poll());
        };
    };

    public void checkLengths(){
        // Heap size differences are too much
        if(minHeap.size() - maxHeap.size() > 1){
            maxHeap.add(minHeap.poll());
        } else if(maxHeap.size() - minHeap.size() > 1){
            minHeap.add(maxHeap.poll());
        };
    };

    public double findMedian(){
        // Heap sizes are the same, take the average of the first two from each
        if(minHeap.size() == maxHeap.size()){
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if(maxHeap.size() - minHeap.size() == 1){
            return maxHeap.peek();
        } else{
            return minHeap.peek();
        }
    };
};

// MedianOfAStream medianOfAStream = new MedianOfAStream();
// medianOfAStream.insertNum(3);
// medianOfAStream.insertNum(1);
// System.out.println("The median is: " + medianOfAStream.findMedian());
// medianOfAStream.insertNum(5);
// System.out.println("The median is: " + medianOfAStream.findMedian());
// medianOfAStream.insertNum(4);
// System.out.println("The median is: " + medianOfAStream.findMedian());