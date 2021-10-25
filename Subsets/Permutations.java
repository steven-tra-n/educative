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

                if(set.size() == 0){
                    set.add(j, nums[i]);
                    subsets.add(set);
                } else{
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
        };

        return result;
    };
}

// List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
//     System.out.print("Here are all the permutations: " + result);