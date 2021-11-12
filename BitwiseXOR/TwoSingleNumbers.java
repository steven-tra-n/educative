package BitwiseXOR;

public class TwoSingleNumbers {
    public static int[] findSingleNumbers(int[] arr){
        int xor = 0;
        int num1 = 0;
        int num2 = 0;

        // XOR the array to get num1 ^ num2
        for(int i = 0; i < arr.length; i++){
            xor ^= arr[i];
        };

        // Shortcut to get rigth most set bit
        int rightMostSetBit = xor & (-xor);

        // Only one number in the array XORd with the rightMostSetBit will equal 0
        // The other XORd will equal 1
        for(int i = 0; i < arr.length; i++){
            if((rightMostSetBit & arr[i]) != 0){
                num1 ^= arr[i];
            };
        };

        num2 ^= (num1 ^ xor);

        return new int[] {num1, num2};
    };
};

    // int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
    // int[] result = TwoSingleNumbers.findSingleNumbers(arr);
    // System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

    // arr = new int[] { 2, 1, 3, 2 };
    // result = TwoSingleNumbers.findSingleNumbers(arr);
    // System.out.println("Single numbers are: " + result[0] + ", " + result[1]);