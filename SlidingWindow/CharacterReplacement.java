package SlidingWindow;
import java.util.HashMap;

public class CharacterReplacement {
    public static int findLength(String str, int k) {
        int windowStart = 0;
        int kCount = 0;
        int maxLength = Integer.MIN_VALUE;
        char sameLetter = str.charAt(0); // Start by comparing first char

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);

            if(rightChar != sameLetter){
                if(kCount < k){
                    kCount++;
                } else{
                    kCount = 0; // k has been exceeded, reset kCount
                    windowStart++; // Slide the beginning of the window forward
                    windowEnd = windowStart; // Push the end of the window back

                    sameLetter = str.charAt(windowStart); // Start checking for the next letter
                };
            };

            maxLength = Math.max(maxLength, (windowEnd - windowStart) + 1);
        };

        return maxLength;
    };

    public static int findLength1(String str, int k) {
        int maxLength = 0;
        int maxCharLength = 0;
        int windowStart = 0;

        HashMap<Character, Integer> charFrequency = new HashMap<Character, Integer>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);
            maxCharLength = Math.max(maxCharLength, charFrequency.get(rightChar)); // Keep track of longest repeating char so far

            if(((windowEnd - windowStart) + 1) - maxCharLength > k){ // Sliding window size minus the longest char so far is greater than k?
                char leftChar = str.charAt(windowStart);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1); // Decrement char count by 1
                windowStart++; // Slide beginning of window up to satisfy k condition
            };

            maxLength = Math.max(maxLength, (windowEnd - windowStart) + 1);
        };

        return maxLength;
    };

    public static int findLength2(String str, int k) {
        int maxLength = 0;
        int windowStart = 0;
        int maxLengthRepeating = 0;
        char leftChar;
        char rightChar;

        HashMap<Character, Integer> charHash = new HashMap<Character, Integer>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            rightChar = str.charAt(windowEnd);

            charHash.put(rightChar, charHash.getOrDefault(rightChar, 0) + 1);
            maxLengthRepeating = Math.max(maxLengthRepeating, charHash.get(rightChar));

            // if(charHash.size() > k){
            //     leftChar = str.charAt(windowStart);
            //     windowStart = Math.max(windowStart, charHash.get(rightChar) + 1);

            //     charHash.remove(leftChar);
            // };
            
            if((windowEnd - windowStart) + 1 - maxLengthRepeating > k){ // If this is greater than k, then we cannot replace all the chars. Shrink window
                leftChar = str.charAt(windowStart);

                charHash.put(leftChar, charHash.get(leftChar) - 1);
                windowStart++;
            };

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        };

        return maxLength;
    };
};

// System.out.println(CharacterReplacement.findLength1("aabccbb", 2));
// System.out.println(CharacterReplacement.findLength1("abbcb", 1));
// System.out.println(CharacterReplacement.findLength1("abccde", 1));