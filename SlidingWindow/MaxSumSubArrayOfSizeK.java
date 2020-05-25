package SlidingWindow;

public class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    // TODO: Write your code here

    int sum = 0;
    int maxSum = 0;

    for(int i = 0; i < arr.length - k; i++){
        sum = 0;

        for(int j = i; j < i + k; j++){
            sum += arr[j];
        };

        if(maxSum < sum){
            maxSum = sum;
        };
    };

    return maxSum;
  };
};