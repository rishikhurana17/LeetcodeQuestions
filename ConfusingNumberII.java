package LeetcodePrograms;
import java.util.*;
/**
 * @author Rishi Khurana
 */
public class ConfusingNumberII {
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;
    public int confusingNumberII(int N) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        helper(N, 0);
        return res;
    }
    private void helper(int N, long cur) {
        if (isConfusingNumber(cur)) {
            res++;
        }
        for (Integer i : map.keySet()) {
            if (cur * 10 + i <= N && cur * 10 + i != 0) {
                helper(N, cur * 10 + i);
            }
        }
    }
    private boolean isConfusingNumber(long n) {
        long src = n;
        long res = 0;
        while (n > 0) {
            res = res * 10 + map.get((int) n % 10);
            n /= 10;
        }
        return res != src;
    }

    // -------------------------

    int[] digits = new int[]{0, 1, 6, 8, 9};
    int[] rotate = new int[]{0, 1, -1, -1, -1, -1, 9, -1, 8, 6};

    public int confusingNumberIIIterative(int N) {
        int res = 0;

        List<Integer> list = new ArrayList<>();
        list.add(0);

        boolean found = false;

        while (!found) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer n : list) {

                for (int i = 0; i < 5; i++) {
                    int nn = n * 10 + digits[i];

                    if (nn > N) {
                        found = true;
                        break;
                    }
                    if (nn != 0) {
                        tmp.add(nn);
                    }
                    if (isConfusing(nn)) {
                        res++;
                    }
                }
                if (found) {
                    break;
                }
            }
            list = tmp;
        }

        return res;
    }

    private boolean isConfusing(int num) {
        int tmp = num;
        int rot = 0;
        while (tmp > 0) {
            int d = tmp % 10;
            rot = rot * 10 + rotate[d];
            tmp /= 10;
        }
        return rot != num;
    }

    public static void main(String []args){
        ConfusingNumberII cNumber = new ConfusingNumberII();
        System.out.println(cNumber.confusingNumberII(20));
    }
}
