package org.learning.src.leetcode.home.tech.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	
	public static void main(String[] args) {
		int[][] in = {{1,10},{2,6},{15,18},{8,10},{1,3}};
		
		new MergeIntervals().merge(in);

	}
    public int[][] merge(int[][] intervals) {
    	List<int[]> out = new ArrayList<int[]>();
        
        Arrays.sort(intervals,(e1,e2) -> {
        	if(e1[0] < e2[0]) {
        		return -1;
        	}else if(e1[0] > e2[0]) {
        		return 1;
        	}else {
        		if(e1[1] < e2[1]) {
        			return -1;
        		}else if(e1[1] > e2[1]) {
        			return 1;
        		}else {
        			return 0;
        		}
        	}
        });
        
//        for(Integer[] in:intervals){
//            System.out.println(in[0]+" "+in[1]);
//        }
        
        out.add(intervals[0]);
        
        for(int i=1;i<intervals.length;i++) {
        	if(intervals[i][0]<= out.get(out.size()-1)[1]) {
        		if(intervals[i][1] > out.get(out.size()-1)[1])
        			out.get(out.size()-1)[1] = intervals[i][1];
        	}else 
        		out.add(intervals[i]);
        }
//        System.out.println("---------");
//        for(Integer[] in:out) {
//        	System.out.println(in[0]+" "+in[1]);
//        }
        
        int[][] output = new int[out.size()][];
        for(int i=0;i<out.size();i++) {
        	output[i] = new int[] {out.get(i)[0],out.get(i)[1]};
        }
        for(int[] in:output) {
        	System.out.println(in[0]+" "+in[1]);
        }
        return output;

    }
}