package LeetcodePrograms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by rkhurana on 2/16/19.
 */
public class LargestNumber {
    public static String largestNumber(int[] num) {
        if (num == null || num.length == 0)
            return "";

        // Convert int array to String array, so we can sort later on
        String[] s_num = new String[num.length];
        for (int i = 0; i < num.length; i++)
            s_num[i] = String.valueOf(num[i]);

        Arrays.sort(s_num, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2=o2+o1;
                return s2.compareTo(s1);
            }
        });
//        // Comparator to decide which string should come first in concatenation
//        Comparator<String> comp = new Comparator<String>() {
//            @Override
//            public int compare(String str1, String str2) {
//                String s1 = str1 + str2;
//                String s2 = str2 + str1;
//
//                return s2.compareTo(s1); // reverse order here, so we can do append() later
//            }
//        };
//
//        Arrays.sort(s_num, comp);

// the whole above commented out lines can be replaced by one below line.
// Arrays.sort(s_num, (a, b) -> (b + a).compareTo(a + b));
// An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if (s_num[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : s_num)
            sb.append(s);
        return sb.toString();

    }

    public static void main(String[]args){
        int []num  = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(num));
    }
}
