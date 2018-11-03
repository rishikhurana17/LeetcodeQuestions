package leetcode;

import leetcode.*;
import leetcode.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rkhurana on 10/16/18.
 */
public class MeetingRooms {
    public static int minMeetingRooms(leetcode.Interval[] intervals) {
        if(intervals==null||intervals.length==0)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start-i2.start;

            }
        });

        //PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        Queue<Integer> queue = new LinkedList<>();
        int count=1;
        queue.offer(intervals[0].end);

        for(int i=1; i<intervals.length; i++){
            if(intervals[i].start<queue.peek()){
                count++;

            }else{
                queue.poll();
            }

            queue.offer(intervals[i].end);
        }
        return count;
    }

    public static void main(String []args){
//        Interval interval[] = {{0,30}, {5,10} ,{15,20} };
//        System.out.println(minMeetingRooms(interval));
    }
}
