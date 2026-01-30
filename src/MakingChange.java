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
        ways = new long[coins.length][target + 1];
        // Fill first col with 1s bc always 1 way to make 0
        for(int i = 0; i < coins.length; i++) {
            ways[i][0] = 1;
        }
        long include;
        long exclude;
        // Loop through ways array
        for(int i = 0; i < coins.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                // Set include and exclude to default to out of bounds
                include = 0;
                exclude = 0;
                // If indexes are in bounds
                if(j - coins[i] >= 0) {
                    // Set include value to included amount
                    include = ways[i][j - coins[i]];
                }
                if(i - 1 >= 0) {
                    // Set exclude value to excluded amount
                    exclude = ways[i - 1][j];
                }
                // The sum of include & exclude for an index is the amount of ways
                ways[i][j] = include + exclude;
            }
        }

        // Recursive call for Memoization
//        count(target, coins.length - 1, coins);

        return ways[coins.length - 1][target];
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
//        if(ways[index][sum] != 0) {
//            return ways[index][sum];
//        }
//
//        // Update memoization
//        ways[index][sum] = count(sum - coins[index], index, coins) + count(sum, index - 1, coins);
//
//        return ways[index][sum];
//    }

}
