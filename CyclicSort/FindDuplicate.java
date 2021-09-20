package CyclicSort;

public class FindDuplicate {
    public static int findNumber(int[] nums) {
        int i = 0;
        int placeholder;

        while(i < nums.length){
            placeholder = nums[i] - 1;

            if(nums[i] != nums[placeholder]){
                swap(nums, i, placeholder);
            } else{
                i++;
            };
        };

        for(int j = 0; j < nums.length; j++){
            if(j != nums[j] - 1){
                return nums[j];
            };
        };

        return -1;
    };

    public static int findNumber2(int[] nums){
        int i = 0;

        while(i < nums.length){
            if(i != nums[i] - 1){ // Index does not match value
                if(nums[i] != nums[nums[i] - 1]){ // Value does not match
                    swap(nums, i, nums[i] - 1);
                } else{
                    return nums[i];
                };
            } else{
                i++;
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

// System.out.println(FindDuplicate.findNumber(new int[] { 1, 4, 4, 3, 2 }));
//     System.out.println(FindDuplicate.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
//     System.out.println(FindDuplicate.findNumber(new int[] { 2, 4, 1, 4, 4 }));