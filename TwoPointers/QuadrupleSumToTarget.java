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
            };
        };

        return quadruplets;
    };
};