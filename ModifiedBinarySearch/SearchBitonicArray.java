package ModifiedBinarySearch;

public class SearchBitonicArray {
    public static int search(int[] arr, int key){
        int start = 0;
        int end = arr.length - 1;
        int mid;
        int result;

        // Modified binary search for bitonic array to find peak
        while(start < end){
            mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid + 1]){
                end = mid;
            } else{
                start = mid + 1;
            };
        };

        // Once while loop finishes, we have the peak
        // Reset start
        // Store the peak to use later, split the array into two
        start = 0;
        int peak = end;

        // Standard binary search
        result = binarySearch(start, end, arr, key);

        if(result != -1){
            return result;
        };

        // Key was not found in first half of bitonic array
        // Search the second half
        start = peak + 1;
        end = arr.length - 1;

        result = binarySearch(start, end, arr, key);

        return result;
    };

    public static int binarySearch(int start, int end, int[] arr, int key){
        int mid;

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

// System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
// System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
// System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
// System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));