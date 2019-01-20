package LeetcodePrograms;

/**
 * Created by rkhurana on 12/19/18.
 */
public class MaximumProductSubarray {
    public static int maximumSubArray(int[] a) {
        int max_so_far = a[0];
        int curr_max = a[0];
            int point1 = -1, point2=-1 ;
        for (int i = 1; i < a.length; i++)
        {
            curr_max = Math.max(a[i], curr_max+a[i]);
//            if( curr_max  >  max_so_far) {
//                    point1 = curr_max;
//                    point2 = max_so_far;
//            }
            max_so_far = Math.max(max_so_far, curr_max);

        }
 //       System.out.println("point 1 is " + point1 + "point 2 is "+ point2 +"for the max cvalue is " + max_so_far );
        return max_so_far;
    }
    public static void main(String []args){
        int []nums = {-2,-3,4,-1,-2,1,5,-3};
        int max_sum = maximumSubArray(nums);
        System.out.println(max_sum);
    }

}
