package LeetcodePrograms;

import java.util.Arrays;

/**
 * Created by rkhurana on 2/27/19.
 */



//minimum of being on the same line go j steps back + 1 or number above that
public class CoinChangeProblem {
    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }



        return dp[amount] > amount ? -1 : dp[amount];
    }
    public static void main(String []args){
        int []coins={1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }

}
