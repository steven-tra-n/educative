package Subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> findSubsets(int[] nums){
        List<List<Integer>> subsets = new ArrayList<>();

        // Start with the empty subset
        subsets.add(new ArrayList<>());

        // Loop through nums
        for(int i = 0; i < nums.length; i++){
            int n = subsets.size();

            // Loop through the subsets
            for(int j = 0; j < n; j++){
                // Fetch existing set, append new num to each iteration
                List<Integer> set = new ArrayList<>(subsets.get(j));

                set.add(nums[i]);
                subsets.add(set);
            };
        };

        return subsets;
    };
};

// List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
//     System.out.println("Here is the list of subsets: " + result);

//     result = Subsets.findSubsets(new int[] { 1, 5, 3 });
//     System.out.println("Here is the list of subsets: " + result);