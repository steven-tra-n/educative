package SlidingWindow;

import java.util.HashMap;

public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        int windowStart = 0;

        HashMap<Character, Integer> charFrequency = new HashMap<Character, Integer>();

        for(int i = 0; i < pattern.length(); i++){ // Populate the map
            char patternChar = pattern.charAt(i);
            charFrequency.put(patternChar, charFrequency.getOrDefault(patternChar, 0) + 1);
        };

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            
            if(charFrequency.containsKey(rightChar)){ // str char exists in map
                charFrequency.put(rightChar, -1);
            } else{
                char leftChar = str.charAt(windowStart);
                if(charFrequency.containsKey(leftChar)){
                    charFrequency.put(leftChar, charFrequency.getOrDefault(leftChar, 0) + 1);
                };

                windowStart++;
            };
        };

        if(charFrequency.size() == 0){
            return true;
        } else{
            return false;
        }
    };
};