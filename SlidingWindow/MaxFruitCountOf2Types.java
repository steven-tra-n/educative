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

    public static int findLength2(char[] arr) {
        int maxLength = 0;
        int windowStart = 0;
        char leftChar;
        char rightChar;

        HashMap<Character, Integer> fruitBasket = new HashMap<Character, Integer>();

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            rightChar = arr[windowEnd];

            fruitBasket.put(rightChar, fruitBasket.getOrDefault(rightChar, 0) + 1);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            
            while(fruitBasket.size() > 2){
                leftChar = arr[windowStart];
                fruitBasket.put(leftChar, fruitBasket.get(leftChar) - 1);

                if(fruitBasket.get(leftChar) == 0){
                    fruitBasket.remove(leftChar);
                };

                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
                windowStart++;
            };
        };

        return maxLength;
    };
};

// System.out.println("Maximum number of fruits: " + 
// MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
// System.out.println("Maximum number of fruits: " + 
// MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));