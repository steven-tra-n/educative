import java.util.List;

import TwoPointers.*;

public class main {
    public static void main(String[] args){
        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
        System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
        System.out.print(num + " ");
        System.out.println();
    };
};