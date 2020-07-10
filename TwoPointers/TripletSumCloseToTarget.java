package TwoPointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static int searchTriplet(int[] arr, int targetSum) {
        int result = Integer.MIN_VALUE;
        int closestSum = 0; // Temporary placeholder
        int left;
        int right;
        
        Arrays.sort(arr); // Unnecessary sort

        for(int i = 0; i < arr.length - 2; i++){
            left = i + 1;
            right = arr.length - 1;

            while(left < right){
                closestSum = arr[i] + arr[left] + arr[right];

                if(closestSum == targetSum){ // Found the exact sum
                    return closestSum;
                } else if(closestSum > result & closestSum <= targetSum){ // Need a larger sum
                    result = closestSum;
                    left++;
                } else{ // result is larget than closestSum. No need to set any variables
                    right--;
                };
            };
        };

        return result;
    };
};

// System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
// System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
// System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));