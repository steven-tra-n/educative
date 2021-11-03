package ModifiedBinarySearch;

public class CeilingOfANumber {
    public static int searchCeilingOfANumber(int[] arr, int key){
        int start = 0;
        int end = arr.length - 1;
        int middle = start + (end - start) / 2;

        if(key > arr[end]){
            return -1;
        };

        while(start <= end){
            if(key == arr[middle]){
                return middle;
            } else if(key > arr[middle]){
                start = middle + 1;
            } else{
                end = middle - 1;
            };

            middle = start + (end - start) / 2;
        };

        // Once the while loop completes, start index will be the minimum largest number
        return start;
    };

    public static int searchFloorOfANumber(int[] arr, int key){
        int start = 0;
        int end = arr.length - 1;
        int middle = start + (end - start) / 2;

        if(key < arr[start]){
            return -1;
        };

        while(start <= end){
            if(key == arr[middle]){
                return middle;
            } else if(key > arr[middle]){
                start = middle + 1;
            } else{
                end = middle - 1;
            };

            middle = start + (end - start) / 2;
        };

        return end;
    };
};

// System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
//     System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
//     System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
//     System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));