package src.algorithm.dp;

import java.util.Stack;

public class PrintLongestCommonSubsequence {

    public static void main(String[] args) {
        PrintLongestCommonSubsequence obj = new PrintLongestCommonSubsequence();
        String text1 = "abcdgh", text2 = "abedfhr";
//        String text1 = "abcdaf", text2 = "acbcf";
        System.out.println(obj.longestCommonSubsequence(text1, text2));
    }

    public String longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        // traverse from last to first and check if the two characters are same,
        // if yes then pick the diagonally element and decrement i and j..or else
        // check which of the either element is greater [i-1][j] or [i][j-1],
        // pick the latest one and pick that character.
        StringBuilder res = new StringBuilder();
        int i = dp.length-1;
        int j = dp[0].length-1;
        Stack<String> stack = new Stack<>();
        stack.peek();
        while(i>0 && j>0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                res.append(text1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                }else
                    j--;
            }
        }
        return res.reverse().toString();

    }
}