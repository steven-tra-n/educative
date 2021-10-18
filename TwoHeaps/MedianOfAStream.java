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
        addToMinHeap(num);
        checkLengths();
    };

    public void addToMinHeap(int num){
        if(minHeap.size() == 0 || num < minHeap.peek()){
            minHeap.add(num);
        } else{
            maxHeap.add(num);
        };
    };

    public void checkLengths(){
        // minHeap has more than 1 elements, so shift it over
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
        } else{
            return maxHeap.peek();
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