package org.learning.src.leetcode.home.tech.problem;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		int[][] in = {{1,3},{6,9}};
		int[] in1 = {2,5};
		new InsertInterval().insert(in, in1);

	}
	
	public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> out = new ArrayList<>();
        int index = 0;
        while(index < intervals.length && intervals[index][1] < newInterval[0])
            out.add(intervals[index++]);
        
        int start = newInterval[0];
        int end = newInterval[1];
        
        while(index < intervals.length && newInterval[1] >= intervals[index][0]){
            start = Math.min(start,intervals[index][0]);
            end = Math.max(end,intervals[index++][1]);
        }

        out.add(new int[]{start,end});
        
        while(index < intervals.length)
            out.add(intervals[index++]);
            
        return out.toArray(new int[out.size()][]);
    }


}
