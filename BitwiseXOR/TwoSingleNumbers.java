package BitwiseXOR;

public class TwoSingleNumbers {
    public static int[] findSingleNumbers(int[] arr){
        int xor = 0;

        for(int i = 0; i < arr.length; i++){
            xor ^= arr[i];
        };

        for(int i = 0; i < arr.length; i++){
            xor ^= arr[i];
        };

        return new int[] {xor, xor};
    };
};

    // int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
    // int[] result = TwoSingleNumbers.findSingleNumbers(arr);
    // System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

    // arr = new int[] { 2, 1, 3, 2 };
    // result = TwoSingleNumbers.findSingleNumbers(arr);
    // System.out.println("Single numbers are: " + result[0] + ", " + result[1]);