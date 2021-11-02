package ModifiedBinarySearch;

public class BinarySearch {
    public static int search(int[] arr, int key){
        int start = 0;
        int end = arr.length - 1;
        boolean isAscending = arr[start] < arr[end];
        int middle = start + (end - start) / 2;

        while(start <= end){
            if(key == arr[middle]){
                return middle;
            };

            if(isAscending){
                if(key < arr[middle]){
                    end = middle - 1;
                } else{
                    start = middle + 1;
                };
            } else{
                if(key > arr[middle]){
                    end = middle - 1;
                } else{
                    start = middle + 1;
                };
            };

            middle = start + (end - start) / 2;
        };

        return -1;
    };
};

// System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
// System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
// System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
// System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
