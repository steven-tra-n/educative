package TopKElements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;


public class KClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x){
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> closestElements = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for(int i = 0; i < k; i++){
            closestElements.offer(arr[i]);
        };

        for(int i = k; i < arr.length; i++){
            if(Math.abs(x - arr[i]) < Math.abs(x - closestElements.peek())){                
                closestElements.poll();
                closestElements.offer(arr[i]);
            };
        };

        Iterator<Integer> iterator = closestElements.iterator();

        while(iterator.hasNext()){
            result.add(iterator.next());
        };

        return result;
    };

    public static List<Integer> findClosestElements2(int[] arr, int k, int x){
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        int index = binarySearch(arr, x);
        int start = index - k;
        int end = index + k;

        // Start and end should remain in bounds of the array
        start = Math.max(start, 0);
        end = Math.min(end, arr.length - 1);

        for(int i = start; i <= end; i++){
            if(minHeap.size() < k){
                minHeap.offer(arr[i]);
            } else{
                if(Math.abs(x - arr[i]) < Math.abs(x - minHeap.peek())){
                    minHeap.poll();
                    minHeap.offer(arr[i]);
                };
            };
        };

        Iterator<Integer> iterator = minHeap.iterator();

        while(iterator.hasNext()){
            result.add(iterator.next());
        };

        return result;
    };

    private static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int middle = 0;

        while(start <= end){
            middle = start + (end - start) / 2;

            if(arr[middle] == target){
                return middle;
            } else if(arr[middle] < target){
                start = middle + 1;
            } else{
                end = middle - 1;
            };
        };

        return middle;
    };
};

// List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
//     System.out.println("'K' closest numbers to 'X' are: " + result);

//     result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
//     System.out.println("'K' closest numbers to 'X' are: " + result);

//     result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
//     System.out.println("'K' closest numbers to 'X' are: " + result);