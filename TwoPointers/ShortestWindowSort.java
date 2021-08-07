package TwoPointers;

public class ShortestWindowSort {
    public static int sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int rightMax = Integer.MIN_VALUE;
        int leftMin = Integer.MAX_VALUE;
        int result;

        while(left < arr.length - 1 && arr[left] <= arr[left + 1]){
            left++; // Find starting index of subarray
        };

        if(left == arr.length - 1){
            return 0; // Array already sorted
        };

        while(right > 0 && arr[right] >= arr[right - 1]){
            right--; // Find ending index of subarray
        };

        for(int i = left; i < right; i++){ // Find min and max of subarray
            leftMin = Math.min(leftMin, arr[i]);
            rightMax = Math.max(rightMax, arr[i]);
        };

        while(left > 0 && arr[left - 1] > leftMin){
            left--; // In case the smallest number exists outside of subarray
        };

        while(right < arr.length - 1 && arr[right + 1] < rightMax){
            right++; // In case the largest number exists outside of subarray
        };

        result = right - left + 1;

        return result;
    };

    public static int sort2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int subarrayMin = Integer.MAX_VALUE;
        int subarrayMax = Integer.MIN_VALUE;

        while(left < arr.length - 1 && arr[left] <= arr[left + 1]){ // Find where array starts becoming out of order
            left++;
        };

        if(left == arr.length - 1){ // Array was already sorted
            return 0;
        };

        while(right > 0 && arr[right] >= arr[right - 1]){ // Find where array ends becoming out of order
            right--;
        };

        for(int i = left; i < right; i++){
            subarrayMin = Math.min(subarrayMin, arr[i]);
            subarrayMax = Math.max(subarrayMax, arr[i]);
        };

        while(left > 0 && arr[left - 1] > subarrayMin){ // Find if there are elements to left of subarray that are larger 
            left --;
        };

        while(right < arr.length - 1 && arr[right + 1] < subarrayMax){
            right++;
        };

        return right - left + 1;
    };
};

// System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
// System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
// System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
// System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));