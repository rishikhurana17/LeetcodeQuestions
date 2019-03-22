package LeetcodePrograms;
import java.util.*;
//Not working correctly
/**
 * Created by rkhurana on 3/13/19.
 */
public class LongestAbsoluteFIlePath {

    public int lengthLongestPath(String input) {

            String[] paths = input.split("/n");
            int[] stack = new int[paths.length + 1];

            int maxLen = 0;
            for (String s : paths) {
                int lev = s.lastIndexOf("/t") + 1;
                stack[lev + 1] = stack[lev] + s.length() - lev + 1;
                if (s.contains(".")) {
                    maxLen = Math.max(maxLen, stack[lev + 1] - 1);
                }
            }

            return maxLen;

    }

    public static void main(String []args){
        LongestAbsoluteFIlePath s = new LongestAbsoluteFIlePath();
        String s1 = "dir/n/tsubdir1/n/t/tfile1.ext/n/t/tsubsubdir1/n/tsubdir2/n/t/tsubsubdir2/n/t/t/tfile2.ext";
                 //  dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext
        String s2 = "dir/n/tsubdir1/n/tsubdir2/n/t/tfile.ext";
        System.out.println(s.lengthLongestPath(s1));
    }
}
