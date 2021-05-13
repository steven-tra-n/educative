package SlidingWindow;

public class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    int sum = 0;
    int maxSum = 0;

    for(int i = 0; i < arr.length - k; i++){
        sum = 0;

        for(int j = i; j < i + k; j++){ // Loop until K elements, starting from i
            sum += arr[j];
        };

        if(maxSum < sum){
            maxSum = sum;
        };
    };

    return maxSum;
  };

  public static int findMaxSumSubArray1(int k, int[] arr) {
    int sum = 0;
    int maxSum = 0;
    int windowStart = 0;

    for(int windowEnd = 0; windowEnd < arr.length - 1; windowEnd++){
        sum += arr[windowEnd];

        if(windowEnd >= k - 1){ // Start sliding window once k elements are reached
            if(maxSum < sum){
                maxSum = sum;
            };

            sum -= arr[windowStart]; // Subtract start of the window
            windowStart++;
        };
    };

    return maxSum;
  };

  public static int findMaxSumSubArray2(int k, int[] arr) {
    int sum = 0;
    int max = 0;
    int windowStart = 0;

    for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
      sum += arr[windowEnd];

      if(windowEnd >= k - 1){
        if(sum > max){
          max = sum;
        };

        sum -= arr[windowStart];
        windowStart++;
      };
    };

    return max;
  };
};

// System.out.println("Maximum sum of a subarray of size K: "
//         + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
// System.out.println("Maximum sum of a subarray of size K: "
//         + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));