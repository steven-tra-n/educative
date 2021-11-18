package TopKElements;

import java.util.PriorityQueue;

public class ConnectRopes {
    public static int minimumCostToConnectRopes(int[] ropeLengths){
        int result = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for(int i = 0; i < ropeLengths.length; i++){
            minHeap.offer(ropeLengths[i]);
        };

        for(int i = 0; i < ropeLengths.length - 1; i++){
            int ropeSum = minHeap.poll() + minHeap.poll();
            minHeap.offer(ropeSum);

            result += ropeSum;
        };

        return result;
    };
};

// int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
//     System.out.println("Minimum cost to connect ropes: " + result);
//     result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
//     System.out.println("Minimum cost to connect ropes: " + result);
//     result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
//     System.out.println("Minimum cost to connect ropes: " + result);
