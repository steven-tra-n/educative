package TopKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static String sortCharacterByFrequency(String str){
        HashMap<Character, Integer> characterFrequencies = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((n1, n2) -> n2.getValue() - n1.getValue());
        String result = "";

        for(int i = 0; i < str.length(); i++){
            characterFrequencies.put(str.charAt(i), characterFrequencies.getOrDefault(str.charAt(i), 0) + 1);
        };

        // for(Map.Entry<Character, Integer> entry : characterFrequencies.entrySet()){
        //     maxHeap.offer(entry);
        // };

        maxHeap.addAll(characterFrequencies.entrySet());

        while(!maxHeap.isEmpty()){
            if(maxHeap.peek().getValue() > 0){
                result += maxHeap.peek().getKey();
                maxHeap.peek().setValue(maxHeap.peek().getValue() - 1);
            } else{
                maxHeap.poll();
            };
        };

        return result;
    };
};

// String result = FrequencySort.sortCharacterByFrequency("Programming");
//     System.out.println("Here is the given string after sorting characters by frequency: " + result);

//     result = FrequencySort.sortCharacterByFrequency("abcbab");
//     System.out.println("Here is the given string after sorting characters by frequency: " + result);