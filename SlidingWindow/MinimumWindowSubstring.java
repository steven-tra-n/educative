package SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        int matched = 0;
        int windowStart = 0;
        int minLength = str.length() + 1;
        int subStrStart = 0;

        HashMap<Character, Integer> charFrequencies = new HashMap<Character, Integer>();

        for(int i = 0; i < pattern.length(); i++){
            char patternChar = pattern.charAt(i);

            charFrequencies.put(patternChar, charFrequencies.getOrDefault(patternChar, 0) + 1); // Populate map
        };

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);

            if(charFrequencies.containsKey(rightChar)){
                charFrequencies.put(rightChar, charFrequencies.get(rightChar) - 1);

                if(charFrequencies.get(rightChar) >= 0){
                    matched++; // Count every match
                };
            };

            while(matched == pattern.length()){
                if(minLength > windowEnd - windowStart + 1){ // minLength currently larger than window length
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart; // Set new substring start index
                };

                char leftChar = str.charAt(windowStart);

                if(charFrequencies.containsKey(leftChar)){
                    if(charFrequencies.get(leftChar) == 0){ // Don't decrement if char is negative
                        matched--;
                    };
    
                    charFrequencies.put(leftChar, charFrequencies.get(leftChar) + 1);
                };

                windowStart++; // Slide left window along
            };
        };

        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    };
};

// System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
// System.out.println(MinimumWindowSubstring.findSubstring("abdabca", "abc"));
// System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));