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

    public static String findSubstring2(String str, String pattern) {
        int windowStart = 0;
        int matched = 0;
        int minLength = str.length() + 1;
        int subStrStart = 0;
        char leftChar;
        char rightChar;

        HashMap<Character, Integer> patternHash = new HashMap<Character, Integer>();
        StringBuilder resultString = new StringBuilder();

        for (char c : pattern.toCharArray()) { // Populate hash
            patternHash.put(c, patternHash.getOrDefault(c, 0) + 1);    
        };

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){ // Iterate str
            rightChar = str.charAt(windowEnd);

            if(patternHash.containsKey(rightChar)){ // Char found in hash. Decrement hash count
                patternHash.put(rightChar, patternHash.get(rightChar) - 1);

                if(patternHash.get(rightChar) >= 0){ // Count each match
                    matched++;
                };
            };

            while(matched == pattern.length()){ // Full pattern match. Start to shrink window
                if(minLength > windowEnd - windowStart + 1){ // minLength larger than window
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart; // Set substring start index
                };
                
                leftChar = str.charAt(windowStart);

                if(patternHash.containsKey(leftChar)){
                    if(patternHash.get(leftChar) == 0){ // Letter in pattern is no longer matched
                        matched--;
                    };

                    patternHash.put(leftChar, patternHash.get(leftChar) + 1); // Increment hash
                };

                windowStart++;
            };
        };

        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    };
};

// System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
// System.out.println(MinimumWindowSubstring.findSubstring("abdbca", "abc"));
// System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));