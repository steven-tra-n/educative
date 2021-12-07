package TopKElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    // 1. Greedy approach. Start with the most occurrring task first for lowest chance of overlap
    // 2. Iterate through the input and put everything into a hash map
    // 3. Add the hash map to a max heap
    // 4. Iterate through the heap until it's empty, checking for every k times
    // 5. Pop the max heap element into an array list and decrement
    // 6. If heap is empty, "idle" and continue
    // 7. Re add the array list back into the max heap
    // 8. Edge cases?

    public static int scheduleTasks(char[] tasks, int k){
        int result = 0;

        // 8.
        if(k == 0){
            return result;
        };

        HashMap<Character, Integer> taskMap = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((c1, c2) -> c2.getValue() - c1.getValue());
        ArrayList<Map.Entry<Character, Integer>> tempEntries = new ArrayList<>();
        int kCounter = k + 1;

        // 2.
        for(int i = 0; i < tasks.length; i++){
            taskMap.put(tasks[i], taskMap.getOrDefault(tasks[i], 0) + 1);
        };

        // 3.
        maxHeap.addAll(taskMap.entrySet());

        // 4.
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> entry = maxHeap.poll();

            // 5.
            entry.setValue(entry.getValue() - 1);

            if(entry.getValue() > 0){
                tempEntries.add(entry);
            };

            kCounter--;
            result++;

            if(kCounter == 0){
                kCounter = k + 1;

                maxHeap.addAll(tempEntries);
                tempEntries.clear();
            };

            if(maxHeap.isEmpty() && kCounter > 0 && !tempEntries.isEmpty()){
                for(int i = kCounter; i < k + 1; i++){
                    kCounter--;
                    result++;

                    if(kCounter <= 0){
                        break;
                    };
                };

                // Start re-adding entries
                kCounter = k + 1;

                maxHeap.addAll(tempEntries);
                tempEntries.clear();
            };
        };

        
        return result;
    };
};

// char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
//     System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

//     tasks = new char[] { 'a', 'b', 'a' };
//     System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));