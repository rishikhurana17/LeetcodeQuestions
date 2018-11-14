package leetcode;

import leetcode.Point;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by rkhurana on 10/19/18.
 */
public class KclosestPointToOrigin {
    public static Point[] findKClosestPoints(Point[] points, int k, Point target) {
        if (points == null || points.length == 0 || k < 1 || k > points.length)   return points;
        Queue<Point> pq = new PriorityQueue<>(k, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2) {
                int d1 = (p1.x - target.x) * (p1.x - target.x) + (p1.y - target.y) * (p1.y - target.y);
                int d2 = (p2.x - target.x) * (p2.x - target.x) + (p2.y - target.y) * (p2.y - target.y);
                return d2 - d1;
            }
        });
        for (Point p : points) {
            pq.offer(p);
            if (pq.size() > k)
                pq.poll();
        }
        Point[] res = new Point[k];
        for (int i = k - 1; i >= 0; i--)
            res[i] = pq.poll();
        return res;
    }

    public static void main(String []args){
      Point []points = new Point[5];

      points[0].setX(2);
      points[0].setY(3);

        points[1].setX(1);
        points[1].setY(4);

        points[2].setX(7);
        points[2].setY(8);

        points[3].setX(1);
        points[3].setY(1);

        points[4].setX(5);
        points[4].setY(5);

        Point target = new Point(0,0);
//        target.setX(0);
//        target.setY(0);
        System.out.println(findKClosestPoints(points,2,target));
    }
}
