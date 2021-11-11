package BitwiseXOR;

public class SingleNumber {
    public static int findSingleNumber(int[] arr){
        int xor = 0;

        for(int i = 0; i < arr.length; i++){
            xor ^= arr[i];
        };

        return xor;
    };
};

// System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));