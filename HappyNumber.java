package leetcode;

/**
 * Created by rkhurana on 7/19/18.
 */
public class HappyNumber {
    public static boolean isHappy2(int n) {
        int slow = n, fast = n;
        do {	slow = next(slow);
            fast = next(next(fast));
        }while (slow != fast);

        return slow == 1 ? true : false;
    }

    private static int next(int n) {
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            n /= 10;
            sum += i * i;
        }
        return sum;
    }

    public static int titletoNum2(String s) {
        int result = 0;
        for(int i = 0 ; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }


    public static void main(String [] args){
        //System.out.println(isHappy2(15));
  //      System.out.println(titletoNum2("AA"));
        System.out.println(Math.pow(-13,10));
        System.out.println(Math.pow(-13,25));
    }
}
