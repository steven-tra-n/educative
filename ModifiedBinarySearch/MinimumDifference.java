package ModifiedBinarySearch;

public class MinimumDifference {
    public static int searchMinDiffElement(int[] arr, int key){
        int start = 0;
        int end = arr.length - 1;
        int mid;
        int midNumber;

        if(key < arr[start]){
            return arr[start];
        } else if(key > arr[end]){
            return arr[end];
        };

        while(start <= end){
            mid = start + (end - start) / 2;

            midNumber = arr[mid];

            if(key == midNumber){
                return midNumber;
            } else if(key < midNumber){
                end = mid - 1;
            } else{
                start = mid + 1;
            };
        };

        // At the end of the loop, start == end + 1
        if(arr[start] - key < key - arr[end]){
            return arr[start];
        };
        
        return arr[end];
    };
};

    // System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
    // System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
    // System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
    // System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));