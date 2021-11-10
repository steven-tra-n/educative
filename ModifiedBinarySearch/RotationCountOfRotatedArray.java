package ModifiedBinarySearch;

public class RotationCountOfRotatedArray {
    public static int countRotations(int[] arr){
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
        
        // After while loop, both start and end will point to the lowest int

        return end;
    };
};

    // System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
    // System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
    // System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));