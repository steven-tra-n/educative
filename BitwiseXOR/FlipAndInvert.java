package BitwiseXOR;

public class FlipAndInvert {
    public static int[][] flipAndInvertImage(int[][] arr){
        for(int i = 0; i < arr[0].length; i++){
            int start = 0;
            int end = arr[0].length - 1;

            // Swap indicies
            while(start < end){
                int temp = arr[i][start];
                arr[i][start] = arr[i][end];
                arr[i][end] = temp;

                arr[i][start] ^= 1;
                arr[i][end] ^= 1;

                start++;
                end--;
            };

            // Middle of array
            if(start == end){
                arr[i][start] ^= 1;
            };
        };

        return arr;
    };

    public static void print(int[][] arr) {
        for(int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            };
            
            System.out.println();
        };
    };
};

// int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
//     print(flipAndInvertImage(arr));
//     System.out.println();

//     int[][]arr2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
//     print(flipAndInvertImage(arr2));

