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

    public static int findLength2(String str) {
        int maxLength = 0;
        int windowStart = 0;
        char leftChar;
        char rightChar;

        HashMap<Character, Integer> charHash = new HashMap<Character, Integer>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            rightChar = str.charAt(windowEnd);

            charHash.put(rightChar, charHash.getOrDefault(rightChar, 0) + 1);

            while(charHash.get(rightChar) > 1){
                leftChar = str.charAt(windowStart);
                charHash.put(leftChar, charHash.get(leftChar) - 1);

                if(charHash.get(leftChar) == 0){
                    charHash.remove(leftChar);
                };

                windowStart++;
            };

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        };

        return maxLength;
    };
};

// System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
// System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
// System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
// System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abcba"));