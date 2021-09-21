package CyclicSort;

public class FirstSmallestMissingPositive {
    public static int findNumber(int[] nums) {
        if(nums.length <= 1){
            return -1;
        };
        
        int i = 0;

        while(i < nums.length){
            if(nums[i] <= 0 || nums[i] > nums.length || nums[i] == nums[nums[i] - 1]){ // Skip negative numbers, or numbers that are larger than array size
                i++;
            } else{
                swap(nums, i, nums[i] - 1);
            };
        };

        for(i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            };
        };

        return -1;
    };

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    };
};

// System.out.println(FirstSmallestMissingPositive.findNumber(new int[] { -3, 1, 5, 4, 2 }));
// System.out.println(FirstSmallestMissingPositive.findNumber(new int[] { 3, -2, 0, 1, 2 }));
// System.out.println(FirstSmallestMissingPositive.findNumber(new int[] { 3, 2, 5, 1 }));