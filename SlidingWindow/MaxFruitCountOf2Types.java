package SlidingWindow;

import java.util.HashMap;

public class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        int maxLength = Integer.MIN_VALUE;
        int windowStart = 0;

        HashMap<Character, Integer> fruits = new HashMap<Character, Integer>();

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            char rightFruit = arr[windowEnd];
            fruits.put(rightFruit, fruits.getOrDefault(rightFruit, 0) + 1); // If fruit exists, increment by 1. If not, initialize to 1

            while(fruits.size() > 2){
                char leftFruit = arr[windowStart];
                fruits.put(leftFruit, fruits.get(leftFruit) - 1); // Decrement left fruit count

                if(fruits.get(leftFruit) == 0){
                    fruits.remove(leftFruit);
                };

                windowStart++;
            };

            maxLength = Math.max(maxLength, (windowEnd - windowStart) + 1);

            for(int i = 0; i < arr.length; i++){
                System.out.println(i);
            };
        };

        return maxLength;
    };
};

// System.out.println("Maximum number of fruits: " + 
// MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
// System.out.println("Maximum number of fruits: " + 
// MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));