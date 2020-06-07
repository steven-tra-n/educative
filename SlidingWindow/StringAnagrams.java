package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        int windowStart = 0;
        int matched = 0;

        List<Integer> resultIndices = new ArrayList<Integer>();
        HashMap<Character, Integer> charFrequencies = new HashMap<Character, Integer>();

        for(int i = 0; i < pattern.length(); i++){ // Populate map
            char patternChar = pattern.charAt(i);
            charFrequencies.put(patternChar, charFrequencies.getOrDefault(patternChar, 0) + 1);
        };

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);

            if(charFrequencies.containsKey(rightChar)){
                charFrequencies.put(rightChar, charFrequencies.get(rightChar) - 1); // Decrement char

                if(charFrequencies.get(rightChar) == 0){
                    matched++; // Keep track of matched chars
                };

                if(matched == charFrequencies.size()){
                    resultIndices.add(windowStart);
                };

                if(windowEnd >= pattern.length() - 1){ // Window is longer than pattern, scenario invalid
                    char leftChar = str.charAt(windowStart);

                    if(charFrequencies.containsKey(leftChar)){
                        if(charFrequencies.get(leftChar) == 0){
                            matched--; // Decrement matched since we are putting char back into map
                        };

                        charFrequencies.put(leftChar, charFrequencies.get(leftChar) + 1);
                    };

                    windowStart++; // Slide front window along
                };
            };
        };

        return resultIndices;
      };
};

// System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
// System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));