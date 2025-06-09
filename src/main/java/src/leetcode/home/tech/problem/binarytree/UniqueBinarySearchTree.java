/*https://leetcode.com/problems/unique-binary-search-trees/?envType=problem-list-v2&envId=binary-tree*/
package src.leetcode.home.tech.problem.binarytree;

public class UniqueBinarySearchTree {

    public int numTrees(int n) {
        int[] dp= new int[n+1];
        dp[0] = 1;
        for(int element_count=1;element_count<=n;element_count++){
            int unique = 0;
            for(int i=1;i<=element_count;i++){
                int left_comb = dp[i-1];
                int right_comb = dp[element_count-i];
                unique+=(left_comb*right_comb);
            }
            dp[element_count]=unique;
        }
        return dp[n];
    }
}
