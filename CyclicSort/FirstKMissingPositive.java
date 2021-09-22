package CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FirstKMissingPositive {
    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();

        int i = 0; 
        int max = Integer.MIN_VALUE;

        while(i < nums.length){
            max = Integer.max(max, nums[i]);

            if(nums[i] < 0 || nums[i] > nums.length || nums[i] == nums[nums[i] - 1]){ // Skip if negative, or if nums[i] is outside array, or if it doesn't need to be sorted
                i++;
            } else{
                swap(nums, i, nums[i] - 1);
            };
        };

        for(i = 0; i < nums.length; i++){ 
            if(nums[i] != i + 1){ // Doesn't include numbers that not in the array
                missingNumbers.add(i + 1);

                if(missingNumbers.size() == k){
                    break;
                };
            };
        };

        while(missingNumbers.size() < k){
            missingNumbers.add(++max);
        };

        return missingNumbers;
    };

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    };
};

// List<Integer> missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
//         System.out.println("Missing numbers: " + missingNumbers);
    
//         missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 2, 3, 4 }, 3);
//         System.out.println("Missing numbers: " + missingNumbers);
    
//         missingNumbers = FirstKMissingPositive.findNumbers(new int[] { -2, -3, 4 }, 2);
//         System.out.println("Missing numbers: " + missingNumbers);