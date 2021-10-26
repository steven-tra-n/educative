package Subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> findPermutations(int[] nums){
        List<List<Integer>> subsets = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        // Start with empty set
        subsets.add(new ArrayList<>());

        // Loop through each num
        for(int i = 0; i < nums.length; i++){
            int jEnd = subsets.size();

            // Copy previous subset and add num[i] for each set inside
            for(int j = 0; j < jEnd; j++){
                List<Integer> set = new ArrayList<>(subsets.get(j));
                // Third loop to insert nums[i] into each position in the set
                for(int k = 0; k <= set.size(); k++){
                    List<Integer> set2 = new ArrayList<>(subsets.get(j));

                    set2.add(k, nums[i]);
                    subsets.add(set2);

                    // Permutation length matches
                    if(set2.size() == nums.length){
                        result.add(set2);
                    };
                };
            };
        };

        return result;
    };

    public static List<List<Integer>> generatePermutations(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationRecursive(nums, 0, new ArrayList<>(), result);

        return result;
    };

    private static void generatePermutationRecursive(int[] nums, int index, List<Integer> currentPermutation, List<List<Integer>> result){
        if(index == nums.length){
            result.add(currentPermutation);
        } else{
            // Create a new permutation by adding the current number at every position
            for(int i = 0; i <= currentPermutation.size(); i++){
                List<Integer> newPermutation = new ArrayList<>(currentPermutation);
                newPermutation.add(i, nums[index]);
                generatePermutationRecursive(nums, index + 1, newPermutation, result);
            };
        };
    };
};

// List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
//     System.out.print("Here are all the permutations: " + result);