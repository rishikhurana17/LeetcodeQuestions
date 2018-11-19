package LeetcodePrograms;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by rkhurana on 10/26/18.
 */
public class Maximum3Product {
    public static int maximumProductHeap(int[] nums) {

        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(3);

        PriorityQueue<Integer> smallHeap = new PriorityQueue<>(3 , Collections.reverseOrder());

        for(int num : nums) {

            smallHeap.offer(num);
            bigHeap.offer(num);

//            if(smallHeap.size() > 3)
//                System.out.println("polling from small " + smallHeap.poll());
//            if(bigHeap.size() > 3)
//                System.out.println("polling from big " + bigHeap.poll());



            System.out.println("current status");

        }
        System.out.println("check values now");
        return 0;
    }

    public static void main(String []args){
        int []num = {6,4,3,-1,-5,-3,-8};
        System.out.println(maximumProductHeap(num));
    }
}
