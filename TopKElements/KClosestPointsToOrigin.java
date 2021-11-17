package TopKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static List<Point> findClosestPoints(Point[] points, int k){
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((n1, n2) -> n2.distFromOrigin() - n1.distFromOrigin());

        for(int i = 0; i < k; i++){
            maxHeap.offer(points[i]);
        };

        for(int i = k; i < points.length; i++){
            if(points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()){
                maxHeap.poll();
                maxHeap.offer(points[i]);
            };
        };

        return new ArrayList<>(maxHeap);
    };
};

// Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
//     List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
//     System.out.print("Here are the k points closest the origin: ");
//     for (Point p : result)
//       System.out.print("[" + p.x + " , " + p.y + "] ");