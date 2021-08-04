package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 3; i++){
            if(i > 0 && arr[i] == arr[i - 1]){ // Skip iteration if duplicate number
                continue;
            };

            for(int j = i + 1; j < arr.length - 2; j++){
                if(j > i + 1 && arr[j] == arr[j - 1]){
                    continue;
                };

                addQuads(arr, i, j, target, quadruplets);
            };
        };

        return quadruplets;
    };

    private static void addQuads(int[] arr, int i, int j, int target, List<List<Integer>> quadruplets){
        int left = j + 1;
        int right = arr.length - 1;
        int sum;

        while(left < right){
            sum = arr[i] + arr[j] + arr[left] + arr[right];

            if(sum == target){
                quadruplets.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));

                left++;
                right--;

                while(left < right && arr[left] == arr[left - 1]){
                    left++;
                };

                while(left < right && arr[right] == arr[right + 1]){
                    right--;
                };
            } else if(sum > target ){
                right--;
            } else{
                left++;
            };
        };
    };

    public static List<List<Integer>> searchQuadruplets2(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);

        int outerSum;
        int innerSum;
        int difference;

        for(int i = 0; i < arr.length - 3; i++){
            for(int j = i + 1; j < arr.length - 2; j++){
                int left = j + 1;
                int right = arr.length - 1;

                outerSum = arr[i] + arr[j];

                while(left < right){
                    innerSum = arr[left] + arr[right];
                    difference = target - outerSum;

                    if(innerSum == difference){
                        quadruplets.add(Arrays.asList(arr[left], arr[right], arr[i], arr[j]));

                        left++;
                        right--;
                    } else if(innerSum < difference){
                        left++;
                    } else{
                        right--;
                    };
                };
            };
        };

        return quadruplets;
    };
};

// System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
// System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));