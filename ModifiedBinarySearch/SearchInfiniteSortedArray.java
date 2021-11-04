package ModifiedBinarySearch;

public class SearchInfiniteSortedArray {
    public static int search(ArrayReader reader, int key){
        int start = 0;
        int end = 1;
        int mid;
        int midNumber;
        int result = -1;

        if(key < reader.get(start)){
            return result;
        };

        // Attempt to find ending bound for search
        while(key > reader.get(end)){
            end = end * 2;
        };

        while(start <= end){
            mid = start + (end - start) / 2;

            midNumber = reader.get(mid);

            if(key == midNumber){
                result = mid;
                break;
            } else if(key < midNumber){
                end = mid - 1;
            } else{
                start = mid + 1;
            };
        };

        return result;
    };
};

// ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
//     System.out.println(SearchInfiniteSortedArray.search(reader, 16));
//     System.out.println(SearchInfiniteSortedArray.search(reader, 11));
//     reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
//     System.out.println(SearchInfiniteSortedArray.search(reader, 15));
//     System.out.println(SearchInfiniteSortedArray.search(reader, 200));