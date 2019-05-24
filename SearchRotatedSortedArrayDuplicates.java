package LeetcodePrograms;

public class SearchRotatedSortedArrayDuplicates {
    public static int search5(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            else if (nums[mid] <= nums[end]) { // right half is sorted
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String []args){
        int nums [] = {1,3,1,1,1};
        System.out.println(search5(nums,3));
    }
}
