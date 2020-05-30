package SlidingWindow;
import java.util.*;

public class NoRepeatSubstring {
    public static int findLength(String str) {
        int windowStart = 0;
        int maxLength = Integer.MIN_VALUE;

        HashMap<Character, Integer> uniqueChars = new HashMap<Character, Integer>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);

            if(uniqueChars.containsKey(rightChar)){
                windowStart = Math.max(windowStart, uniqueChars.get(rightChar) + 1); // Slide window up to where the duplicate char is to start the count over
            };

            uniqueChars.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, (windowEnd - windowStart) + 1);
        };

        return maxLength;
    };
};