package LeetcodePrograms;
import java.util.*;
/**
 * Created by rkhurana on 3/3/19.
 */
public class TaskScheduler {
    //T O(n log 26) = O(n)
    //S O(26) = O(1)
    public static int leastInterval(char[]tasks, int n) {
        //freq of tasks
        int[] freq = new int[26];

        for (char c : tasks) {
            freq[c - 'A']++;
        }

        //PQ maxheap
        PriorityQueue<Integer> pq = new PriorityQueue<>(26, Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0) {
                pq.offer(f);
            }
        }
        //resultant time interval
        int time = 0;

        //iterate through pq until it is empty
        while (!pq.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            //iterate upto cooling period n
            while (i <= n) {

                if (!pq.isEmpty()) {

                    if (pq.peek() > 1) {
                        //poll from pq
                        //add remaining freq instances to a temp ArrayList
                        temp.add(pq.poll() - 1);
                    } else {
                        pq.poll();
                    }

                }

                time++;

                //terminating condition for the loop
                if (pq.isEmpty() && temp.size() == 0) {
                    break;
                }

                i++;

            }

            //add remaining instances of tasks accounted for back to the pq
            for (int t : temp) {
                pq.offer(t);
            }
        }

        return time;
    }

    public static void main(String []args){

        char []task = {'A','A','A','B','B','B' , 'C','C','D'};
        System.out.println(leastInterval(task,2));
    }

}


