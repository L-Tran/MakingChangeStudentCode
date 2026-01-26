/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Logan Tran
 */

public class MakingChange {

    public static int[] ways;

    public static long countWays(int target, int[] coins) {
        // Array representing the # of ways for the index amount of coins
        ways = new int[target + 1];
        for(int i = 0; i <= target; i++) {
            ways[i] = -1;
        }
        return waysPerCoin(target, coins);
    }

    public static int waysPerCoin(int target, int[] coins) {
        if(target == 0) {
            return 1;
        }

        if(target < 0) {
            return 0;
        }

        if(ways[target] != -1) {
            return ways[target];
        }

        int total = 0;

        for(int coin: coins) {
            total += waysPerCoin(target - coin, coins);
        }

        ways[target] = total;
        return total;



    }

}
