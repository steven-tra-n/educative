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
                charFrequency.put(rightChar, -1); // Decrement char
            } else{
                char leftChar = str.charAt(windowStart);
                if(charFrequency.containsKey(leftChar)){
                    charFrequency.put(leftChar, charFrequency.getOrDefault(leftChar, 0) + 1); // Put char back in
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

    public static boolean findPermutation1(String str, String pattern) {
        int windowStart = 0;
        int matched = 0;
        
        HashMap<Character, Integer> charFrequency = new HashMap<Character, Integer>();

        for(int i = 0; i < pattern.length(); i++){ // Populate the map
            char patternChar = pattern.charAt(i);

            charFrequency.put(patternChar, charFrequency.getOrDefault(patternChar, 0) + 1);
        };
        
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);

            if(charFrequency.containsKey(rightChar)){
                charFrequency.put(rightChar, charFrequency.get(rightChar) - 1);

                if(charFrequency.get(rightChar) == 0){
                    matched++;
                };
            };

            if(matched == charFrequency.size()){
                return true;
            };

            if(windowEnd > pattern.length() - 1){ // Means str is now longer than pattern
                windowStart++; // Shrink window

                char leftChar = str.charAt(windowStart);
                if(charFrequency.containsKey(leftChar)){
                    if(charFrequency.get(leftChar) == 0){
                        matched--; // Decrement since we are putting this char back into the map
                    };

                    charFrequency.put(leftChar, charFrequency.get(leftChar) + 1); // Put char back into the map
                };
            };
        };

        return false;
    };
};

// System.out.println("Permutation exist: " + StringPermutation.findPermutation1("oidbcaf", "abc"));
// System.out.println("Permutation exist: " + StringPermutation.findPermutation1("odicf", "dc"));
// System.out.println("Permutation exist: " + StringPermutation.findPermutation1("bcdxabcdy", "bcdyabcdx"));
// System.out.println("Permutation exist: " + StringPermutation.findPermutation1("aaacb", "abc"));