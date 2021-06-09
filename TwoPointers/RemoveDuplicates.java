package TwoPointers;

public class RemoveDuplicates {
    public static int remove(int[] arr) {
        int nextNonDuplicate = 1;

        for(int i = 1; i < arr.length; i++){
            int leftNum = arr[nextNonDuplicate - 1];
            int rightNum = arr[i];

            if(arr[nextNonDuplicate - 1] != arr[i]){
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            };
        };

        return nextNonDuplicate;
    };

    public static int remove2(int[] arr) {
        int nonDupeCount = 1; // Length will always be 1
        int left = 0;
        int right = 0;

        while(right < arr.length){
            if(arr[left] != arr[right]){
                left = right;
                nonDupeCount++;
            } else{
                right++;
            };
        };

        return nonDupeCount;
    };
};

// int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
// System.out.println(RemoveDuplicates.remove(arr));

// arr = new int[] { 2, 2, 2, 11 };
// System.out.println(RemoveDuplicates.remove(arr));