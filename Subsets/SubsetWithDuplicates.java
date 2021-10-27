package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {
      public static List<List<Integer>> findSubsets(int[] nums){
          List<List<Integer>> subsets = new ArrayList<>();

          if(nums.length <= 0){
              return subsets;
          };

          // Add empty set first
          subsets.add(new ArrayList<>());

          int start = 0;
          int end = 0;

          for(int i = 0; i < nums.length; i++){
              start = 0;

              if(i > 0 && nums[i] == nums[i - 1]){
                  // Duplicate is found, only add nums[i] to previously added sets
                  start = end;
              };

              end = subsets.size();

              for(int j = start; j < end; j++){
                  List<Integer> set = new ArrayList<>(subsets.get(j));

                  set.add(nums[i]);
                  subsets.add(set);
              };
          };

          return subsets;
      };

      public static List<List<Integer>> findSubsets2(int[] nums){
          List<List<Integer>> subsets = new ArrayList<>();

          Arrays.sort(nums);
          findSubsetsRecursive(nums, 0, new ArrayList<>(), subsets);

          return subsets;
      };

      private static void findSubsetsRecursive(int[] nums, int index, List<Integer> set, List<List<Integer>> subsets){
          subsets.add(new ArrayList<>(set));

          for(int i = index; i < nums.length; i++){
              // Don't add the set in case of duplicates
              if(i > index && nums[i] == nums[i - 1]){
                  continue;
              };

              // Add to current set
              set.add(nums[i]);
              // Travel to leaf nodes
              findSubsetsRecursive(nums, i + 1, set, subsets);
              // Backtrack
              set.remove(set.size() -1);
          };
      };
};

// List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
//     System.out.println("Here is the list of subsets: " + result);

//     result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
//     System.out.println("Here is the list of subsets: " + result);