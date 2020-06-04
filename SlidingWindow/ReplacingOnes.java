package SlidingWindow;
import java.util.HashMap;

public class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int maxLength = Integer.MIN_VALUE;
        int maxBitLength = 0;
        int windowStart = 0;

        HashMap<Integer, Integer> bitFrequency = new HashMap<Integer, Integer>();

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            int rightInt = arr[windowEnd];
            bitFrequency.put(rightInt, bitFrequency.getOrDefault(rightInt, 0) + 1); // Increment count of bits by 1
            maxBitLength = Math.max(maxBitLength, bitFrequency.get(rightInt)); // Store max bit count so far

            if(((windowEnd - windowStart) + 1) - maxBitLength > k){ // Sliding window size minus maxBitLength is greater than k?
                int leftInt = arr[windowStart];
                bitFrequency.put(leftInt, bitFrequency.get(leftInt) - 1); // Decrement the frequency
                windowStart++; // Shrink the window
            };

            maxLength = Math.max(maxLength, (windowEnd - windowStart) + 1);
        };

        return maxLength;
    };
    
    public static int findLength1(int[] arr, int k) {
        int maxLength = Integer.MIN_VALUE;
        int onesCount = 0;
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            if(arr[windowEnd] == 1){
                onesCount++; // One is found, so increment
            };

            if(((windowEnd - windowStart) + 1) - onesCount > k){ // Window size minus onesCount is bigger than allowed limit
                if(arr[windowStart] == 1){
                    onesCount--; // Since left window is sliding up, onesCount is decremented if the first in on the left is a 1
                };

                windowStart++; // Slide the left window up
            };

            maxLength = Math.max(maxLength, (windowEnd - windowStart) + 1);
        };

        return maxLength;
    };
};

// System.out.println(ReplacingOnes.findLength1(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
// System.out.println(ReplacingOnes.findLength1(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));