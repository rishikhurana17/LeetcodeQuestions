package leetcode; /**
 * Created by rkhurana on 10/8/18.
 */

import java.util.*;
public class primeFactors {

    public static List<Integer> primeFactors(int numbers) {
        int n = numbers;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }

    public static void main(String [] args){
        System.out.println(primeFactors(44));
    }
}
