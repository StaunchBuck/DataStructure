package src.algorithm.dp;

import java.util.stream.IntStream;

public class LastStoneWeight2 {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = IntStream.of(stones).sum();
        boolean[] dp = new boolean[totalSum+1];
        dp[0] = true;
        for(int stone :stones){
            for(int i=totalSum;i>=stone;i--){
                dp[i] = dp[i] || dp[i-stone];
            }
        }
        // Now for each dp position we know whether it is possible to have a sum equal to dp position.
        // If dp[2] == trie, then it means we can choose elements from the array to form a sum of 2.
        // To find the next partition sum we simply do totalSum-dp[i].
        // Then we go on to find the absolute difference between the 1st and 2nd partition.
        int res = totalSum;
        for(int i=0;i<=dp.length/2;i++){
            if(dp[i])
                res = Math.min(res,Math.abs((totalSum-i)-i));
        }
        return res;
    }
}