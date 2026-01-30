/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Logan Tran
 */

public class MakingChange {

    public static long[][] ways;

    public static long countWays(int target, int[] coins) {
        ways = new long[target + 1][coins.length];
        // Fill first col with 1s bc always 1 way to make 0
        for(int i = 0; i < coins.length; i++) {
            ways[0][i] = 1;
        }
        long include;
        long exclude;
        for(int i = 1; i < target + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                include = 0;
                exclude = 0;
                if(i - coins[j] >= 0) {
                    include = ways[i - coins[j]][j];
                }
                if(j - 1 >= 0) {
                    exclude = ways[i][j - 1];
                }
                ways[i][j] = include + exclude;
            }
        }

        // Recursive call for Memoization
//        count(target, coins.length - 1, coins);
        return ways[target][coins.length - 1];



        HE HE HE HAW HAW HAW
    }

    // Memoization
//    public static long count(int sum, int index, int[] coins) {
//        // If sum is perfect cut down it is a solution
//        if(sum == 0) {
//            return 1;
//        }
//        // Ensure within bounds
//        if(index < 0 || sum < 0) {
//            return 0;
//        }
//        // Use memoization if possible
//        if(ways[sum][index] != 0) {
//            return ways[sum][index];
//        }
//
//        // Update memoization
//        ways[sum][index] = count(sum - coins[index], index, coins) + count(sum, index - 1, coins);
//
//        return ways[sum][index];


//    }

}
