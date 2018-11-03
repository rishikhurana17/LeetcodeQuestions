package leetcode;
import java.util.*;

public class LongestSubstring {

//    public Point[] findKClosestPoints(Point[] points, int k, Point target) {
//        if (points.length == 0 || k < 1 || k > points.length)   return points;
//        int left = 0, right = points.length - 1;
//        while (true) {
//            int pos = partition(points, left, right, target);
//            if (pos == k - 1)   break;
//            else if (pos > k - 1)   right = pos - 1;
//            else    left = pos + 1;
//        }
//        Point[] res = new Point[k];
//        for (int i = 0; i < k; i++)
//            res[i] = points[i];
//        return res;
//    }
//
//    private int partition(Point[] points, int left, int right, Point target) {
//        shuffle(points);
//        int idx = left; // important
//        Point pivot = points[idx];
//        int pDist = getDistance(pivot, target);
//        swap(points, idx, right);
//        for (int i = left; i < right; i++) {
//            int iDist = getDistance(points[i], target);
//            if (iDist < pDist)  swap(points, i, idx++);
//        }
//        swap(points, idx, right);
//        return idx;
//    }
//
//    private int getDistance(Point p, Point target) {
//        return (p.x - target.x) * (p.x - target.x) + (p.y - target.y) * (p.y - target.y);
//    }
//
//    private static void swap(Point[] points, int left, int right) {
//        Point temp = points[left];
//        points[left] = points[right];
//        points[right] = temp;
//    }

    // partition function used by quickselect
//    int quickselectPartition(vector<pair<int, int>>& nums, int start, int end) {
//        int pivot = nums[end].first;
//        int i = start, j = start;
//        for (; j < end; j++) {
//            if (nums[j].first <= pivot) {
//                swap(nums[i], nums[j]);
//                i++;
//            }
//        }
//        swap(nums[end], nums[i]);
//        return i;
//    }
//
//    // a combination of quickselect and quicksort
//    void quickselect(vector<pair<int, int>>& nums, int start, int end, int k) {
//        if (start >= end) {
//            return;
//        }
//        int pivotIndex = quickselectPartition(nums, start, end);
//        if (pivotIndex < k - 1) {
//            quickselect(nums, start, pivotIndex - 1, k);
//            quickselect(nums, pivotIndex + 1, end, k);
//        } else {
//            quickselect(nums, start, pivotIndex - 1, k);
//        }
//    }
//
//    // uses a combination of quickselect and quicksort to find k closest elements in O(n + k log k).
//    multiset<int> kClosestQuickselect(vector<int> nums, int target, int k) {
//        vector<pair<int, int>> distances(nums.size());
//        for (int i = 0; i < nums.size(); i++) {
//            distances[i] = make_pair(abs(nums[i] - target), nums[i]);
//        }
//
//        quickselect(distances, 0, distances.size() - 1, k);
//        multiset<int> result;
//        for (int i = 0; i < k; i++) {
//            result.insert(distances[i].second);
//        }
//        return result;
 //   }

    int lengthOfLongestSubstringKDistinct(String str, int k) {
        int s = 0, e = 0, maxlen = 0;
        Map<Character, Integer> dic = new HashMap<>();
        while (e < str.length()) {
            char c = str.charAt(e);
            if (dic.containsKey(c)) {
                dic.put(c, dic.get(c)+1);

            } else {
                dic.put(c, 1);
            }

            while (dic.size() > k) {
                c = str.charAt(s);
                if (dic.get(c) == 0)
                    dic.remove(c);
                else
                    dic.put(c, dic.get(c)-1);

                ++s;
            }
            maxlen = Math.max(maxlen, e - s + 1);
            ++e;
        }
        return maxlen;
    }


    public int lengthOfLongestSubstringKDistinct22(String s, int k) {
        if(k==0 || s==null || s.length()==0)
            return 0;

        if(s.length()<k)
            return s.length();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int maxLen=k;
        int left=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }

            if(map.size()>k){
                maxLen=Math.max(maxLen, i-left);

                while(map.size()>k){

                    char fc = s.charAt(left);
                    if(map.get(fc)==1){
                        map.remove(fc);
                    }else{
                        map.put(fc, map.get(fc)-1);
                    }

                    left++;
                }
            }

        }

        maxLen = Math.max(maxLen, s.length()-left);

        return maxLen;
    }

    public static void main(String [] args) {
           LongestSubstring o = new LongestSubstring();
            System.out.println(o.lengthOfLongestSubstringKDistinct("eceba",2));
    }
}

