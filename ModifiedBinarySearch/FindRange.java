package ModifiedBinarySearch;

public class FindRange {
    public static int[] findRange(int[] arr, int key){
        int[] result = new int[]{-1, -1};

        result[0] = binarySearch(arr, key, true); // Starting index
        result[1] = binarySearch(arr, key, false); // Ending index

        return result;
    };

    public static int binarySearch(int[] arr, int key, boolean isFirstPosition){
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;
        int keyIndex = -1;
        int midNumber;

        if(key < arr[start] || key > arr[end]){
            return keyIndex;
        };

        while(start <= end){
            midNumber = arr[mid];

            if(key < midNumber){
                end = mid - 1;
            } else if(key > midNumber){
                start = mid + 1;
            } else{
                keyIndex = mid;

                
                if(isFirstPosition){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                };
            };

            mid = start + (end - start) / 2;
        };

        return keyIndex;
    };
};

// int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
// System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
// result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
// System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
// result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
// System.out.println("Range: [" + result[0] + ", " + result[1] + "]");