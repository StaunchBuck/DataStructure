package src.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class DeleetAndEarn {
    // This problem is similar to House Robber
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,3,3,4,6,7,9};
        System.out.println(new DeleetAndEarn().deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        /* Create a count map */
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer num:nums){
            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);
        }
        /* Create array of unique elements and sort it*/
        Integer[] arr_no_duplicate = map.keySet().toArray(new Integer[0]);
        Arrays.sort(arr_no_duplicate);
        /* Create dp array and initilize the last position*/
        Integer[] dp = new Integer[arr_no_duplicate.length];
        dp[dp.length-1]=arr_no_duplicate[dp.length-1]*map.get(arr_no_duplicate[dp.length-1]);
        /* Iterate and if next element is adjacent value then consider current + next to next or else current + next element*/
        for(int i=dp.length-2;i>=0;i--){
            int key = arr_no_duplicate[i];
            if(arr_no_duplicate[i+1].equals(key+1)){
                int val = 0;
                if(i+2<dp.length)
                    val = dp[i+2];
                dp[i] = Math.max((key*map.get(key))+val,dp[i+1]);
            }else
                dp[i] = key*map.get(key)+dp[i+1];
        }
        /* Finally return the first position of the dp */
        return dp[0];
    }
}