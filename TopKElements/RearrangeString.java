package TopKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {
    public static String rearrangeString(String str){
        // 1. Add all characters into a hash map
        // 2. Add the hash map into a max heap
        // 3. Poll and append the key of the heap onto a running string
        // 4. Decrement the value of that key and offer it back to the heap

        HashMap<Character, Integer> charFrequencies = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((n1, n2) -> n2.getValue() - n1.getValue());
        String result = "";

        // 1.
        for(int i = 0; i < str.length(); i++){
            charFrequencies.put(str.charAt(i), charFrequencies.getOrDefault(str.charAt(i), 0) + 1);
        };

        // 2.
        maxHeap.addAll(charFrequencies.entrySet());

        while(maxHeap.size() >= 2){
            Map.Entry<Character, Integer> character = maxHeap.poll();
            Map.Entry<Character, Integer> character2 = maxHeap.poll();

            // 3.
            result += character.getKey();
            result += character2.getKey();

            // 4.
            character.setValue(charFrequencies.get(character.getKey()) - 1);
            character2.setValue(charFrequencies.get(character2.getKey()) - 1);

            if(character.getValue() > 0){
                maxHeap.offer(character);
            };
            
            if(character2.getValue() > 0){
                maxHeap.offer(character2);
            };
        };

        // 3. again 
        Map.Entry<Character, Integer> character = maxHeap.poll();
        result += character.getKey();

        // 4. again
        character.setValue(charFrequencies.get(character.getKey()) - 1);

        if(character.getValue() > 0){
            maxHeap.offer(character);
        };

        // Invalid input
        if(maxHeap.size() > 0){
            result = "";
        };

        return result;
    };
};

// System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
//     System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
//     System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));