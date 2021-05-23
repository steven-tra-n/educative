package SlidingWindow;
import java.util.HashMap;

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
    
    public static int findLength2(String str, int k) {
        int windowStart = 0;
        int currentLength = 0;
        int maxLength = 0;
        char lastChar;
        char firstChar;
        
        HashMap<Character, Integer> strHash = new HashMap<Character, Integer>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            lastChar = str.charAt(windowEnd);

            if(strHash.containsKey(lastChar)){
                strHash.put(lastChar, strHash.get(lastChar) + 1);
            } else{
                while(strHash.size() == k){
                    firstChar = str.charAt(windowStart);
                    strHash.put(firstChar, strHash.get(firstChar) - 1);

                    if(strHash.get(firstChar) == 0){
                        strHash.remove(firstChar);
                    };

                    maxLength = Math.max(currentLength, maxLength);
                    currentLength--;
                    windowStart++;
                };

                strHash.put(lastChar, 1);
            };

            maxLength = Math.max(currentLength, maxLength);
            currentLength++;
        };

        return maxLength;
    };
};

// System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
// System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
// System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));