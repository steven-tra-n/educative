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
};