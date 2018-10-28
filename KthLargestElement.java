package leetcode;

import java.util.PriorityQueue;

/**
 * Created by rkhurana on 10/27/18.
 */
public class KthLargestElement {
    public  static int findKthLargest(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
    public static void main(String []args) {
        int []nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums , 2));
    }
}
