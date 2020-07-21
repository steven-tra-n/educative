import TwoPointers.*;

public class main {
    public static void main(String[] args){
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        DutchFlag.sort(arr);
        for (int num : arr)
          System.out.print(num + " ");
        System.out.println();
    
        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        DutchFlag.sort(arr);
        for (int num : arr)
          System.out.print(num + " ");
    };
};