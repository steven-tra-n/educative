package SlidingWindow;
import java.util.*;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        int windowStart = 0;
        int maxLength = Integer.MIN_VALUE;

        HashMap<Character, Integer> chars = new HashMap<Character, Integer>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            chars.put(rightChar, chars.getOrDefault(rightChar, 0) + 1); // If char exists in hash, increment by 1. If not, initialize to 1

            while(chars.size() > k){
                char leftChar = str.charAt(windowStart);
                chars.put(leftChar, chars.get(leftChar) - 1); // Decrement char in hash by 1

                if(chars.get(leftChar) == 0){
                    chars.remove(leftChar);
                };

                windowStart++;
            };

            maxLength = Math.max(maxLength, (windowEnd - windowStart) + 1);
        };

        return maxLength;
    };
};

// System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
// System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
// System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));