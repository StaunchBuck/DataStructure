package src.leetcode.home.tech.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        int[] arr = new int[]{100,4,200,1,3,2};
        System.out.println(l.longestConsecutive(arr));
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            if(!set.contains(i)){
                set.add(i);
            }
        }
        Integer max = 1;
        List<Integer> list = new ArrayList<>(set);
        Set<Integer> processed = new HashSet<>();
        for(int i=0;i<list.size();i++){
            int curr_el = list.get(i);
            if(processed.contains(curr_el)){
                continue;
            }
            processed.add(curr_el);
            int seq_len = 1;
            int left_el = curr_el-1;
            if(set.contains(left_el)){
                while(set.contains(left_el)){
                    processed.add(left_el);
                    left_el -=1;
                }
                seq_len +=(curr_el-left_el-1);
            }
            int right_el = curr_el+1;
            if(set.contains(right_el)){
                while(set.contains(right_el)){
                    processed.add(right_el);
                    right_el +=1;
                }
                seq_len +=(right_el-curr_el-1);
            }
            max = Math.max(max,seq_len);
        }
        return max;
    }
}
