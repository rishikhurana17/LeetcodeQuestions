package LeetcodePrograms;

/**
 * Created by rkhurana on 8/3/18.
 */
public class NumberCompliment {
    public static int findComplement(int num) {
        int i = 0;
        int j = 0;
        while (i < num)	        {
            i += Math.pow(2, j);
            j++;
        }
        return i - num;
    }
    //Another way
    public static int findComplement2(int num) {
        String s = Integer.toBinaryString(num);
        int t = (int) (Math.pow(2, s.length()) - 1);
        return t - num;
    }

    public static void main(String [] args) {
            System.out.println(findComplement2(5));
          //  findComplement2(5);
    }
}
