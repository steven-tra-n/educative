package ModifiedBinarySearch;

public class MaxInBitonicArray {
    public static int findMax(int[] arr)  {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while(start < end){
            mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid + 1]){
                end = mid;
            } else{ //arr[mid] < arr[mid + 1]
                start = mid + 1;
            };
        };

        // start == end at this point
        return arr[start];
    };
};

    // System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
    // System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
    // System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
    // System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));