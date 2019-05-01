package LeetcodePrograms;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by rkhurana on 10/19/18.
 */
public class KclosestPointToOrigin {
    public static Point[] findKClosestPoints(Point[] points, int k, Point target) {
        if (points == null || points.length == 0 || k < 1 || k > points.length)
            return points;
        Queue<Point> pq = new PriorityQueue<>(k, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2) {
                int d1 = (p1.x - target.x) * (p1.x - target.x) + (p1.y - target.y) * (p1.y - target.y);
                int d2 = (p2.x - target.x) * (p2.x - target.x) + (p2.y - target.y) * (p2.y - target.y);
                return d2 - d1;  // will keep the smaller elements in the list
            }
        });
        for (Point p : points) {

            pq.offer(p);

            if (pq.size() > k)
                pq.poll(); //removes the element which is the biggest element there

        }
        Point[] res = new Point[k];
        for (int i = k - 1; i >= 0; i--)
            res[i] = pq.poll();
        return res;
    }

    public static int findKthLargest(int[] nums, int k) {
         PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);
            if (pq.size() > k) {
                System.out.println(pq.peek());

                pq.poll();
            }
        }
        return pq.peek();
    }


    public static void main(String []args){
        Point []points = new Point[5];
        points[0] = new Point(0,5);
        points[1] = new Point(0,6);
        points[2] = new Point(1,1);
        points[3] = new Point(0,3);
        points[4] = new Point(0,4);
        Point target = new Point(0,0);
        Point []result = findKClosestPoints(points,3,target);
        System.out.println("hey ");
      //  int[] arr = { 12, 5, 23, 9, 30, 2, 50, 1, 14, 7, 24, 51 };
      //  System.out.println(findKthLargest(arr,2));
    }
}
