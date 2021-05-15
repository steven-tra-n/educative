package SlidingWindow;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr){
        int sum = 0;
        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            sum += arr[windowEnd];

            while(sum >= S){
                minLength = Math.min(minLength, (windowEnd - windowStart) + 1); // +1 because windowEnd starts from 0
                sum -= arr[windowStart]; // Slide the window along
                windowStart++;
            };
        };

        return minLength;
    };

    public static int findMinSubArray2(int S, int[] arr){
        int sum = 0;
        int windowStart = 0;
        int minLength = arr.length;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            sum += arr[windowEnd];

            while(sum >= S){
                if((windowEnd - windowStart) < minLength){
                    minLength = windowEnd - windowStart + 1;
                };

                sum -= arr[windowStart];
                windowStart++;
            };
        };

        return minLength;
    };
};

// int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
// System.out.println("Smallest subarray length: " + result);
// result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
// System.out.println("Smallest subarray length: " + result);
// result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
// System.out.println("Smallest subarray length: " + result);