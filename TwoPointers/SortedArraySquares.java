package TwoPointers;

public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int positiveIndex, leftPointer, rightPointer;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 0){
                positiveIndex = i;
                leftPointer = i - 1;
                rightPointer = i + 1;
                
                break;
            };
        };

        

        return squares;
    };
};