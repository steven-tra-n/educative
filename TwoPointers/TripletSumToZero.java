package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        
        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 2; i++){
            if(i > 0 && arr[i] == arr[i - 1]){ // Skip duplicates
                continue;
            };
            
            searchPair(arr, -arr[i], i + 1, triplets); // x + y + z = 0. So x + y = -z
        };
        
        return triplets;
    };

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int currentSum;
        int right = arr.length - 1;

        while(left < right){
            currentSum = arr[left] + arr[right];

            if(currentSum == targetSum){
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));

                left++;
                right--;

                while(left < right && arr[left] == arr[left - 1]){
                    left++;
                };
    
                while(left < right && arr[right] == arr[right + 1]){
                    right--;
                };
            } else if(currentSum > targetSum){
                right--;
            } else{
                left++;
            };
        };
    };
};

// System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
// System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));