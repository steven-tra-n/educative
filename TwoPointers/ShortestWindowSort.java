package TwoPointers;

public class ShortestWindowSort {
    public static int sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while(left < right && arr[left] <= arr[left + 1]){
            left++;
        };

        return - 1;
    };
};