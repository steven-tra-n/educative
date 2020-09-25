package CyclicSort;

public class CyclicSort {
    public static void sort(int[] nums) {
        int i = 0;
        int placeholder;
        int temp;

        // while(i < nums.length){
        //     if(nums[i] != i + 1){
        //         placeholder = nums[nums[i]];
        //         nums[nums[i]] = nums[i];
        //         nums[i] = placeholder;
        //     };

        //     i++;
        // };

        // for(int i = 0; i < nums.length; i++){
        //     while(nums[i] != i + 1){
        //         if(nums[i] >= nums.length){
        //             placeholder = nums[nums.length - 1];
        //         } else{
        //             placeholder = nums[nums[i]];
        //         };

        //         nums[nums[i]] = nums[i];
        //         nums[i] = placeholder;
        //     };
        // };

        while(i < nums.length){
            placeholder = nums[i] - 1;

            if(nums[i] != nums[placeholder]){
                temp = nums[i];
                nums[i] = nums[placeholder];
                nums[placeholder] = temp;
            } else{
                i++;
            };
        };
    };
};

// int[] arr = new int[] { 3, 1, 5, 4, 2 };
//     CyclicSort.sort(arr);
//     for (int num : arr)
//       System.out.print(num + " ");
//     System.out.println();

//     arr = new int[] { 2, 6, 4, 3, 1, 5 };
//     CyclicSort.sort(arr);
//     for (int num : arr)
//       System.out.print(num + " ");
//     System.out.println();

//     arr = new int[] { 1, 5, 6, 4, 3, 2 };
//     CyclicSort.sort(arr);
//     for (int num : arr)
//       System.out.print(num + " ");
//     System.out.println();