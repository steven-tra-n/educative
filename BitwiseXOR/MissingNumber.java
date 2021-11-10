package BitwiseXOR;

public class MissingNumber {
    public static int findMissingNumber(int[] arr){
        int n = arr.length + 1;
        int s1 = 0;

        for(int i = 1; i <= n; i++){
            s1 += i;
        };

        for(int num : arr){
            s1 -= num;
        };

        return s1;
    };

    public static int findMissingNumber2(int[] arr){
        int x1 = 1;

        for(int i = 2; i <= arr.length + 1; i++){
            x1 ^= i;
        };

        int x2 = arr[0];

        // Start from 1 because we already have the initialized x2
        for(int i = 1; i < arr.length; i++){
            x2 ^= arr[i];
        };

        return x1 ^ x2;
    };
};


// int[] arr = new int[] { 1, 5, 2, 6, 4 };
// System.out.print("Missing number is: " + MissingNumber.findMissingNumber(arr));