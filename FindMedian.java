package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by rkhurana on 7/24/18.
 */
public class FindMedian {
    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private boolean even = true;
    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }
    public void addNum(int num) {
        if (even) {

            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
        System.out.println("Small " + small.peek());
        System.out.println("large " + large.peek());

    }

    public static void main(String [] args){
        FindMedian findMedian = new FindMedian();
        findMedian.addNum(2);
        findMedian.addNum(3);
        findMedian.addNum(1);
        findMedian.addNum(5);
        System.out.println(findMedian.findMedian());



    }
}
