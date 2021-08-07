package TwoPointers;

public class DutchFlag {
    public static void sort(int[] arr) {
        int low = 0; 
        int high = arr.length - 1;

        for(int i = low; i <= high;){
            if(arr[i] == 0){ // All 0s will be swapped with low index
                swap(arr, low, i);

                i++;
                low++;
            } else if(arr[i] == 2){ // All 2s will be swapped with high index
                swap(arr, high, i);

                high--;
            } else{ // All 1s will be inbetween 0s and 2s, no logic needed
                i++;
            };
        };
    };

    private static void swap(int[] arr, int a, int b){
        int placeHolder = arr[a];

        arr[a] = arr[b];
        arr[b] = placeHolder;
    };

    public static void sort2(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int index = 0;

        while(index <= end && start < end){
            if(arr[index] == 0){
                arr[index] = arr[start];
                arr[start] = 0;

                start++;
                index++;
            } else if(arr[index] == 2){
                arr[index] = arr[end];
                arr[end] = 2;
                end--;
            } else{
                index++;
            };
        };
    };

    public static void sort3(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int index = 0;

        while(index < end && start < end){
            if(arr[index] == 0){
                arr[index] = arr[start];
                arr[start] = 0;

                start++;
                index++;
            } else if(arr[index] == 2){
                arr[index] = arr[end];
                arr[end] = 2;
                
                end--;
                // index++;
            } else{
                index++;
            };
        };
    };
};

// int[] arr = new int[] { 1, 0, 2, 1, 0 };
// DutchFlag.sort(arr);
// for (int num : arr)
//   System.out.print(num + " ");
// System.out.println();

// arr = new int[] { 2, 2, 0, 1, 2, 0 };
// DutchFlag.sort(arr);
// for (int num : arr)
//   System.out.print(num + " ");