package ModifiedBinarySearch;

public class SearchRotatedWithDuplicate {
    public static int search(int[] arr, int key){
        int start = 0;
        int end = arr.length - 1;
        int mid;
        int result = -1;

        while(start <= end){
            mid = start + (end - start) / 2;

            if(arr[mid] == key){
                return mid;
            };

            if(arr[start] == arr[mid] && arr[end] == arr[mid]){
                start++;
                end--;
            // Left array is sorted
            } else if(arr[start] <= arr[end]){
                if(key >= arr[start] && key < arr[mid]){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                };
            // Right array is sorted
            } else{
                if(key <= arr[end] && key > arr[mid]){
                    start = mid + 1;
                } else{
                    end = mid - 1;
                };
            };
        };

        return result;
    }; 
};

// System.out.println(SearchRotatedWithDuplicate.search(new int[] { 3, 7, 3, 3, 3 }, 7));