import SlidingWindow.*;

public class main {
    public static void main(String[] args){
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println(SlidingWindow.MaxSumSubArrayOfSizeK.findMaxSumSubArray(k, arr));
    };
};