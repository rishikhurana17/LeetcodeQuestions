package leetcode;

/**
 * Created by rkhurana on 10/26/18.
 */
public class findDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = numBelow(nums, mid);
            if (count > mid)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public static int numBelow(int[] nums, int target) {
        int result = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] <= target)
                result++;
        return result;
    }

    public static void main(String []args){
        int []nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}
