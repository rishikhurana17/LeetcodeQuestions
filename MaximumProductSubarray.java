package LeetcodePrograms;

/**
 * Created by rkhurana on 12/19/18.
 */
public class MaximumProductSubarray {
    public static int maximumSubArray(int[] a) {
        int max_so_far = a[0];
        int curr_max = a[0];
        int index1,index2 = -1;
        int index1Number,index2Number = 1;
        for (int i = 1; i < a.length; i++)
        {
            curr_max = Math.max(a[i], curr_max+a[i]);

            max_so_far = Math.max(max_so_far, curr_max);

        }

        return max_so_far;
    }
    public static void main(String []args){
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        int max_sum = maximumSubArray(nums);
        System.out.println(max_sum);
    }

}
