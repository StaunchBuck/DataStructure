package org.learning.src.leetcode.home.tech.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Permutations {

	public static void main(String[] args) {
		Integer[] nums = new Integer[] {1,2,3};
		for(List<Integer> list :new Permutations().permute(nums)){
			System.out.print("[");
			for(Integer i:list)
				System.out.print(i+" ");
			System.out.print("]");
		}

	}
	
    public List<List<Integer>> permute(Integer[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 1){
            result.add(new ArrayList<Integer>(){{add(nums[0]);}});
            return result;
        }
        
        for (int i = 0;i< nums.length;i++){
            Integer [] sub = new Integer[nums.length-1]; 
            final int curr = nums[i]; 
            Arrays.asList(nums).stream().filter((e) -> e != curr).collect(Collectors.toList()).toArray(sub);
            
            for (List<Integer> list:permute(sub)){
                list.add(0,nums[i]);
                result.add(list);
            }
        }
        return result;
    }
}