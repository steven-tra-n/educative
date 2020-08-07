package TwoPointers;

public class TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        int count = 0;
        int left;
        int right;

        for(int i = 0; i < arr.length - 2; i++){
            left = i + 1;
            right = arr.length - 1;

            while(left < right){
                if(arr[i] + arr[left] + arr[right] < target){ 
                    count += right - left; // Since array is ordered, any number between arr[right] and arr[left] will satisfy
                    left++; // Since sum is less, increment left to see if next iteration also satisfies
                } else{
                    right--;
                };
            };
        };

        return count;
    };
};

// System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
// System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));