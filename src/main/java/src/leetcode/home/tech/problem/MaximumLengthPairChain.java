package src.leetcode.home.tech.problem;

import java.util.Arrays;

public class MaximumLengthPairChain {
    public static void main(String[] args) {

        int[][] pairs = {{1,2}, {4,10},{5,6},{7,8},{9,10}};
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int res = 1;
        int prev = 0;

        for(int i=1; i<pairs.length; i++){
            int a = pairs[prev][1];
            int b = pairs[i][0];
            if(pairs[prev][1]<pairs[i][0]){
                prev = i;
                res++;
            }else
                prev = i;
        }

        System.out.println(res);
    }
}
