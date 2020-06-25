package TwoPointers;

public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int length = arr.length;
        int[] result = new int[length];
        int left = 0;
        int right = length - 1; // Need to subtract by one to match array indicies
        int highestSquareIndex = length - 1;
        int leftSquare, rightSquare;

        while(left <= right){
            leftSquare = arr[left] * arr[left];
            rightSquare = arr[right] * arr[right];

            if(leftSquare > rightSquare){
                result[highestSquareIndex] = leftSquare;
                left++;
            } else{
                result[highestSquareIndex] = rightSquare;
                right--;
            };

            highestSquareIndex--;
        };

        return result;
    };
};

// int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 2, 3 });
// for (int num : result)
// System.out.print(num + " ");
// System.out.println();

// result = SortedArraySquares.makeSquares(new int[] { -3, -1, 1, 2 });
// for (int num : result)
// System.out.print(num + " ");
// System.out.println();