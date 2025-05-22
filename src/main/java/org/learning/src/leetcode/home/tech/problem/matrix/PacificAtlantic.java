package org.learning.src.leetcode.home.tech.problem.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlantic {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = { { 1, 1}, { 1, 1}, { 1, 1}};
		List<List<Integer>> output= new PacificAtlantic().pacificAtlantic(input);
		System.out.println(output);

	}
	
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] dp = new int[heights.length][heights[0].length];
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                int val = check(i,j,heights[i][j],heights,dp,result);
                if(val == 3)
                    result.add(new ArrayList<Integer>(Arrays.asList(i,j)));
            }
        }
        
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                System.out.print(dp[i][j]);
            }
            System.out.println("");
        }
        return result;
    }
    
    public int check(int x,int y,int val,int[][] heights,int[][] dp,List<List<Integer>> result){
        if(x<0 || y<0)
            return 1;
        if(x==heights.length || y==heights[0].length)
            return 2;
        if(heights[x][y]>val || heights[x][y] == -1)
            return -1;
        if(dp[x][y] == 3)
            return dp[x][y];
        
        Set<Integer> set = new HashSet<>();
        int temp = heights[x][y];
        heights[x][y] = -1;
        set.add(check(x-1,y,temp,heights,dp,result));
        set.add(check(x,y+1,temp,heights,dp,result));
        set.add(check(x+1,y,temp,heights,dp,result));
        set.add(check(x,y-1,temp,heights,dp,result));
        heights[x][y]=temp;
        if(set.contains(3) || (set.contains(1) && set.contains(2)))
            dp[x][y] = 3;
        else if(set.contains(1))
            dp[x][y] = 1;
        else if(set.contains(2))
            dp[x][y] = 2;
        else
            dp[x][y] = -1;
        return dp[x][y];
    }
}