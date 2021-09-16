package CyclicSort;

public class MissingNumber {
    public static int findMissingNumber(int[] nums) {
        if(nums.length <= 1){
            return -1;
        };

        int temp;
        int i = 0;

        while(i < nums.length){
          if(nums[i] < nums.length && nums[i] != nums[nums[i]]){
            temp = nums[i];
            nums[i] = nums[nums[i]];
            nums[temp] = temp;
          } else{
            i++;
          };

        };

        for(int j = 0; j < nums.length; j++){ // Each number will be on their index except the missing number
          if(j != nums[j]){
            return j;
          }
        };

        return -1; // No missing number
    };
};

// System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
//     System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));