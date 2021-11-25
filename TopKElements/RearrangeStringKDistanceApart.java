package TopKElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeStringKDistanceApart {
    public static String reorganizeString(String str, int k){
        // 1. Add all characters into a hash map
        // 2. Add the hash map into a max heap
        // 3. Poll the max heap k times and store those values in a list
        // 4. Decrement the polls and append to a string
        // 5. Add them back in if their value is more than 0
        // 6. After the while loop, check if remaining heap is within k of the last k characters

        HashMap<Character, Integer> characterFrequencies = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((n1, n2) -> n2.getValue() - n1.getValue());
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>();
        String result = "";

        // 1.
        for(int i = 0; i < str.length(); i++){
            characterFrequencies.put(str.charAt(i), characterFrequencies.getOrDefault(str.charAt(i), 0) + 1);
        };

        // 2.
        maxHeap.addAll(characterFrequencies.entrySet());

        // 3.
        while(maxHeap.size() >= k){
            for(int i = 0; i < k; i++){
                entryList.add(maxHeap.poll());
            };

            // 4.
            for(int i = 0; i < entryList.size(); i++){
                Map.Entry<Character, Integer> entry = entryList.get(i);      

                result += entry.getKey();
            };

            // 5.
            for(int i = 0; i < entryList.size(); i++){
                Map.Entry<Character, Integer> entry = entryList.get(i);                
                entry.setValue(entry.getValue() - 1); 

                if(entry.getValue() > 0){
                    maxHeap.offer(entry);
                };
            };

            entryList.clear();
        };

        // 6.
        while(!maxHeap.isEmpty()){
            // Edge case
            if(result.length() < k){
                break;
            };

            Map.Entry<Character, Integer> entry = maxHeap.poll();

            for(int i = result.length() - 1; i > maxHeap.size(); i--){
                if(result.charAt(i) == entry.getValue()){
                    result = "";

                    break;
                };
            };

            result += entry.getKey();

            entry.setValue(entry.getValue() - 1); 

            if(entry.getValue() > 0){
                maxHeap.offer(entry);
            };
        };

        return result;
    };
};

// System.out.println("Reorganized string: " + 
//             RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
//     System.out.println("Reorganized string: " + 
//             RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
//     System.out.println("Reorganized string: " + 
//             RearrangeStringKDistanceApart.reorganizeString("aab", 2));
//     System.out.println("Reorganized string: " + 
//             RearrangeStringKDistanceApart.reorganizeString("aappa", 3));