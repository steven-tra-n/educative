package TwoPointers;

public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] result = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            if (Math.abs(arr[left]) < Math.abs(arr[right]))
            {
                result[right - left] = arr[right] * arr[right];
                right--;
            } else {
                result[right - left] = arr[left] * arr[left];
                left++;
            };
        };
        
        return result;
    };

    
    public static int[] makeSquares1(int[] arr) {
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