package ModifiedBinarySearch;

public class SearchRotatedArray {
    public static int search(int[] arr, int key){
        int start = 0;
        int end = arr.length - 1; 
        int mid;


        while(start < end){
            mid = start + (end - start) / 2;

            if(arr[mid] > arr[end]){
                start = mid + 1;
            } else{
                end = mid;
            };
        };

        // After while loop, peak of array will be found
        // Determine which part of the array to search
        // Start on first half
        if(key > arr[start]){ 
            end = start;
            start = 0;
        } else{
            end = arr.length - 1;
        };

        // Perform standard binary search
        while(start <= end){
            mid = start + (end - start) / 2;

            if(key == arr[mid]){
                return mid;
            } else if(key < arr[mid]){
                end = mid - 1;
            } else{
                start = mid + 1;
            };
        };

        return -1;
    };
};

    // System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
    // System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));