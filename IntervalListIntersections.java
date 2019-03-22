package LeetcodePrograms;
import java.util.*;

/**
 * Created by rkhurana on 3/17/19.
 */
//Leetcode 986 Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
//Return the intersection of these two interval lists.

public class IntervalListIntersections {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return new Interval[] {};
        }

        int m = A.length, n = B.length;
        int i = 0, j = 0;
        List<Interval> res = new ArrayList<>();
        while (i < m && j < n) {
            Interval a = A[i];
            Interval b = B[j];

            // find the overlap... if there is any...
            int startMax = Math.max(a.start, b.start);
            int endMin = Math.min(a.end, b.end);

            if (endMin >= startMax) {
                res.add(new Interval(startMax, endMin));
            }

            //update the pointer with smaller end value...
            if (a.end == endMin) { i++; }
            if (b.end == endMin) { j++; }
        }

        //thanks EOAndersson for the concice expression of converting a list to an array
        //thanks Sithis for the explaination of using toArray (new T[0]) intead fo toArray newT[size])
        return res.toArray(new Interval[0]);
    }

    //or second way is
    public Interval[] intervalIntersection2(Interval[] A, Interval[] B) {

        List<Interval> retList = new ArrayList<Interval>();
        // Need to sort them if they are not sorted
        int i=0, j=0;
        while(i<A.length && j< B.length){
            if(A[i].end < B[j].start){    // 1.
                i++;
            } else if(B[j].end < A[i].start){    // 1.
                j++;
            }else{       //  2.
                Interval inter = new Interval(Math.max(A[i].start, B[j].start), Math.min(A[i].end, B[j].end));
                retList.add(inter);
                if(A[i].end < B[j].end){  // 3.
                    i++;
                }else
                    j++;
            }
        }
        Interval[] ret = new Interval[retList.size()];
        i=0;
        for(Interval item: retList){
            ret[i++] = item;
        }
        return ret;
    }

}

//        int size = res.size();
//        Interval[] list = new Interval[size];
//        for (int k = 0; k < size; k++) {
//            list[k] = res.get(k);
//        }
//        return list;

