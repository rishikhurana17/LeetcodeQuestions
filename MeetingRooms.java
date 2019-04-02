package LeetcodePrograms;

import java.util.*;

/**
 * Created by rkhurana on 10/16/18.
 */
public class MeetingRooms {
    public static int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // it has  to be a priority queue instead of a simple queue.. for example [[0,30],[5,10],[15,20]]

        int count = 1;
        queue.offer(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < queue.peek()) {
                count++;

            } else {
                queue.poll();
            }

            queue.offer(intervals[i].end); //this is the main point to remember
        }
        return count;
    }

    public static void main(String []args){
        Interval []interval = new Interval[5];
        interval[0] = new Interval(0,30);
        interval[1] = new Interval(5,10);
        interval[2] = new Interval(15,20);
//        interval[3] = new Interval(15,25);
//        interval[4] = new Interval(10,14);


        System.out.println(minMeetingRooms(interval));
    }
}
